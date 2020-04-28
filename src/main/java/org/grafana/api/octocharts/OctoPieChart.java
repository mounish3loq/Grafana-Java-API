package org.grafana.api.octocharts;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.grafana.api.templates.Dashboard.GrafanaPanel.PieChartPanelTpl;

public class OctoPieChart extends OctoBaseChart {
    private String dashboarduid;
    private String dashboardtitle;
    private String tableName;
    private String columns;
    public PieChartPanelTpl piepanel;

    public OctoPieChart(SparkSession spark, String dashboarduid, Dataset<Row> df, String workunitname, String summaryname, String paneltitle){
        this.dashboarduid = dashboarduid;
        this.piepanel = new PieChartPanelTpl();
        this.piepanel.setDatasource(System.getenv("POSTGRES_DATASOURCE"));
        this.piepanel.setTitle(paneltitle);
        this.piepanel.setPieType("pie");
        this.updateChartData(spark,df,dashboarduid,workunitname,summaryname);
    }

    public void setColumns(String columns) {
        this.columns = columns;
    }
    public void setPietype(String type){
        this.piepanel.setPieType(type);
    }

    public void publish(){
        String query = String.format("SELECT\n now() as time, %s FROM %s where dashboardid = \'%s\'",this.columns,this.tableName,this.dashboarduid);
        this.piepanel.setTargets(query,"time_series");
        publish(this.dashboarduid,this.dashboardtitle,this.piepanel);
    }
    public void setDashboardtitle(String dashboardtitle){
        this.dashboardtitle = dashboardtitle;
    }
}
