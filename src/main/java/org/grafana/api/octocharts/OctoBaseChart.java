package org.grafana.api.octocharts;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.functions;
import org.grafana.api.GrafanaAPI;
import org.grafana.api.responses.Dashboard.DashboardRsp;
import org.grafana.api.responses.Dashboard.NewCreateUpdateDashboardRsp;
import org.grafana.api.templates.Dashboard.CreateUpdateDashboardTpl;
import org.grafana.api.templates.Dashboard.DashboardTpl;
import org.apache.spark.sql.Dataset;
import org.grafana.api.templates.Dashboard.abstractbasepanel.BasePanelTpl;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class OctoBaseChart {
    static Logger log = Logger.getLogger(OctoBaseChart.class.getName());
    public void updateChartData(SparkSession spark,Dataset<Row> df,String dashboarduid,String workunitname,String summaryname){
        log.info("UpdateChartData "+" Spark Session Id: " + spark +" Table Name: " + workunitname+"_"+summaryname);

        String tableName = workunitname +"_"+ summaryname;
        Properties connectionProperties = new Properties();
        connectionProperties.put("user", System.getenv("GRAFANA_POSTGRES_USERNAME"));
        connectionProperties.put("password", System.getenv("GRAFANA_POSTGRES_PASSWORD"));
        df = df.withColumn("dashboardid",functions.lit(dashboarduid));
        df = df.withColumn("workunitname", functions.lit(workunitname));
        df = df.withColumn("summaryname",functions.lit(summaryname));
        df.write()
                .mode("append")
                .jdbc("jdbc:postgresql://"+System.getenv("GRAFANA_POSTGRES_URL")+"/"+System.getenv("GRAFANA_POSTGRES_DB"), tableName, connectionProperties);
    }
  
    public void publish(String uid, String dashboardtitle, BasePanelTpl panel){
        log.info("Method Name : BasePanelTpl Publish"+"Uid : "+uid + "Dashboard Title : "+dashboardtitle);

        String grafanaserver = System.getenv("GRAFANA_SERVER");
//        "Bearer eyJrIjoiSmtSNUY2R3RyV0hVQ0oxQ0E5NlJlZ0lXYVp4Z0s0T1QiLCJuIjoiVGVzdCBLZXkiLCJpZCI6MX0= "
        String mainOrgApiKey = System.getenv("GRAFANA_APIKEY");
        GrafanaAPI grafanaAPI = new GrafanaAPI(grafanaserver);
        DashboardTpl dashItems;
        DashboardRsp dashboardRsp = grafanaAPI.orgAdminAPI(mainOrgApiKey).getDashboardByUid(uid);
        if (dashboardRsp == null){
            dashItems = new DashboardTpl();
            dashItems.setUid(uid);
            if (dashboardtitle == null) {
                dashItems.setTitle("MyTestTitle2");
            }else{
                dashItems.setTitle(dashboardtitle);
            }
        }else{
            dashItems = dashboardRsp.getDashboard();
        }
        CreateUpdateDashboardTpl dashTest = new CreateUpdateDashboardTpl();
        dashItems.setPanels(panel);
        dashTest.setDashboard(dashItems);
        NewCreateUpdateDashboardRsp createUpdateDashboard = grafanaAPI.orgAdminAPI(mainOrgApiKey).createUpdateDashboard(dashTest);
    }
}