package org.grafana.api.octocharts;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.functions;
import org.grafana.api.GrafanaAPI;
import org.grafana.api.responses.Dashboard.DashboardRsp;
import org.grafana.api.responses.Dashboard.NewCreateUpdateDashboardRsp;
import org.grafana.api.templates.Dashboard.CreateUpdateDashboardTpl;
import org.grafana.api.templates.Dashboard.DashboardTpl;
import org.grafana.api.templates.Dashboard.PlotlyPanel.PlotlyPanelTpl;
import org.apache.spark.sql.Dataset;

import java.util.Properties;

public abstract class OctoBaseChart {
    public void updateChartData(SparkSession spark,Dataset<Row> df,String dashboarduid,String workunitname,String summaryname){
        String tableName = workunitname +"_"+ summaryname;
        Properties connectionProperties = new Properties();
        connectionProperties.put("user", "postgres");
        connectionProperties.put("password", "12345");
        df = df.withColumn("dashboardid",functions.lit(dashboarduid));
        df = df.withColumn("workunitname", functions.lit(workunitname));
        df = df.withColumn("summaryname",functions.lit(summaryname));
        df.write()
                .mode("append")
                .jdbc("jdbc:postgresql://localhost:5432/SampleDatabase", tableName, connectionProperties);
    }
    public void publish(String uid, String dashboardtitle, PlotlyPanelTpl panel){
        String grafanaserver = "http://localhost:3000";
        String mainOrgApiKey = "Bearer eyJrIjoiSmtSNUY2R3RyV0hVQ0oxQ0E5NlJlZ0lXYVp4Z0s0T1QiLCJuIjoiVGVzdCBLZXkiLCJpZCI6MX0= ";
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
