package org.grafana.api.octocharts;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.grafana.api.templates.Dashboard.GrafanaPanel.LineGraphPanelTpl;
import org.grafana.api.templates.Dashboard.GrafanaPanel.TablePanelTpl;

public class OctoTableChart extends OctoBaseChart {
    private String dashboarduid;
    private String dashboardtitle;
    private String tableName;
    private String columns;
    public TablePanelTpl tablepanel;

    public OctoTableChart(SparkSession spark, String dashboarduid, Dataset<Row> df, String workunitname, String summaryname, String paneltitle){
        this.dashboarduid = dashboarduid;
        this.dashboardtitle = null;
        this.tablepanel = new TablePanelTpl();
        this.tablepanel.setDatasource(System.getenv("POSTGRES_DATASOURCE"));
        this.tablepanel.setTitle(paneltitle);
        this.tablepanel.setType("table");
        this.tableName=workunitname+"_"+summaryname;
        this.updateChartData(spark,df,dashboarduid,workunitname,summaryname);
    }
    public void setColumns(String cols){
        this.columns = cols;
    }
    public void publish(){
        String query = String.format("SELECT\n %s FROM %s where dashboardid = \'%s\'",this.columns,this.tableName,this.dashboarduid);
        this.tablepanel.setTargets(query);
        publish(this.dashboarduid,this.dashboardtitle,this.tablepanel);
    }
    public void setDashboardtitle(String dashboardtitle){
        this.dashboardtitle = dashboardtitle;
    }
}
