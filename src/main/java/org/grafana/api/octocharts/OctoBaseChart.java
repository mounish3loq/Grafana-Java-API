package org.grafana.api.octocharts;

import org.apache.spark.sql.Row;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.functions;
import org.apache.spark.sql.SparkSession;

import org.grafana.api.GrafanaAPI;
import org.grafana.api.templates.Dashboard.DashboardTpl;
import org.grafana.api.responses.Dashboard.DashboardRsp;
import org.grafana.api.templates.Dashboard.CreateUpdateDashboardTpl;
import org.grafana.api.responses.Dashboard.NewCreateUpdateDashboardRsp;
import org.grafana.api.templates.Dashboard.abstractbasepanel.BasePanelTpl;

import java.util.Properties;
import java.util.logging.Logger;

import java.time.*;

public abstract class OctoBaseChart {
    //static Logger log = Logger.getLogger(OctoBaseChart.class.getName());
    static Logger log = Logger.getLogger("myLogger");
    public void updateChartData(SparkSession spark,Dataset<Row> df,String dashboarduid,String workunitname,String summaryname){
        String tableName = workunitname.substring(workunitname.lastIndexOf('.') + 1) +"_"+ summaryname;
        log.info("UpdateChartData "+" Spark Session Id: " + spark +" Table Name: " + tableName);
        Properties connectionProperties = new Properties();
        connectionProperties.put("user", System.getenv("GRAFANA_POSTGRES_USERNAME"));
        connectionProperties.put("password", System.getenv("GRAFANA_POSTGRES_PASSWORD"));
        connectionProperties.put("driver", "org.postgresql.Driver");

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
        String grafana_username = System.getenv("GRAFANA_USERNAME");
        String grafana_password = System.getenv("GRAFANA_PASSWORD");
        GrafanaAPI grafanaAPI = new GrafanaAPI(grafanaserver);
        DashboardTpl dashItems;
        DashboardRsp dashboardRsp = grafanaAPI.orgAdminAPI(grafana_username,grafana_password).getDashboardByUid(uid);
        if (dashboardRsp == null){
            dashItems = new DashboardTpl();
            dashItems.setUid(uid);
            if (dashboardtitle == null) {
                LocalDateTime local= LocalDateTime.now();
                String localdt = String.valueOf(local);
                dashItems.setTitle(uid);
            }else{
                dashItems.setTitle(dashboardtitle);
            }
        }else{
            dashItems = dashboardRsp.getDashboard();
        }
        CreateUpdateDashboardTpl dashTest = new CreateUpdateDashboardTpl();
        dashItems.setPanels(panel);
        dashTest.setDashboard(dashItems);
        NewCreateUpdateDashboardRsp createUpdateDashboard = grafanaAPI.orgAdminAPI(grafana_username,grafana_password).createUpdateDashboard(dashTest);
        log.info("success");
    }
}
