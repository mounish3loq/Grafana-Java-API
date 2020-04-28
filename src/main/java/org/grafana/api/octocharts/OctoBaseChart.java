package org.grafana.api.octocharts;
import com.google.gson.GsonBuilder;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.functions;
import org.grafana.api.GrafanaAPI;
import org.grafana.api.responses.Dashboard.DashboardRsp;
import org.grafana.api.responses.Dashboard.NewCreateUpdateDashboardRsp;
import org.grafana.api.templates.Dashboard.CreateUpdateDashboardTpl;
import org.grafana.api.templates.Dashboard.DashboardTpl;
import org.apache.spark.sql.Dataset;
import org.grafana.api.templates.Dashboard.abstractbasepanel.BasepanelTpl;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class OctoBaseChart {
    static Logger log = Logger.getLogger(OctoBaseChart.class.getName());
    private String grafanaserver = System.getenv("GRAFANA_SERVER");
    private String mainOrgApiKey = System.getenv("GRAFANA_APIKEY");
    private String postgre_user = System.getenv("POSTGRES_USERNAME");
    private String postgre_password = System.getenv("POSTGRES_PASSWORD");
    private String postgres_url = System.getenv("POSTGRES_URL");
    private String postgres_db = System.getenv("POSTGRES_DB");
    public void updateChartData(SparkSession spark,Dataset<Row> df,String dashboarduid,String workunitname,String summaryname){
        log.info("UpdateChartData "+" Spark Session Id: " + spark +" Table Name: " + workunitname+"_"+summaryname);

        String tableName = workunitname +"_"+ summaryname;
        Properties connectionProperties = new Properties();
        connectionProperties.put("user", this.postgre_user);
        connectionProperties.put("password", this.postgre_password);
        df = df.withColumn("dashboardid",functions.lit(dashboarduid));
        df = df.withColumn("workunitname", functions.lit(workunitname));
        df = df.withColumn("summaryname",functions.lit(summaryname));
        df.write()
                .mode("append")
                .jdbc("jdbc:postgresql://"+this.postgres_url+"/"+this.postgres_db, tableName, connectionProperties);
    }
    public void publish(String uid, String dashboardtitle, BasepanelTpl panel){
        log.info("Method Name : BasePanelTpl Publish"+"Uid : "+uid + "Dashboard Title : "+dashboardtitle);

        String grafanaserver = this.grafanaserver;
//        "Bearer eyJrIjoiSmtSNUY2R3RyV0hVQ0oxQ0E5NlJlZ0lXYVp4Z0s0T1QiLCJuIjoiVGVzdCBLZXkiLCJpZCI6MX0= "
        String mainOrgApiKey = this.mainOrgApiKey;
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
            System.out.println("dashboard not null");
            try{
                FileWriter fw = new FileWriter("dashtest.json");
                Gson gson = new GsonBuilder().create();
                fw.write(gson.toJson(dashItems));
                fw.close();
            }catch (IOException ie){
                System.out.println("File error");
                log.log(Level.SEVERE,"File Not Found");
            }
        }
        CreateUpdateDashboardTpl dashTest = new CreateUpdateDashboardTpl();
        dashItems.setPanels(panel);
        dashTest.setDashboard(dashItems);
        NewCreateUpdateDashboardRsp createUpdateDashboard = grafanaAPI.orgAdminAPI(mainOrgApiKey).createUpdateDashboard(dashTest);
    }
}
