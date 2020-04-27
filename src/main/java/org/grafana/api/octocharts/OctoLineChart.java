package org.grafana.api.octocharts;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.grafana.api.templates.Charts.PlotlyPanelChart;
import org.grafana.api.templates.Dashboard.GrafanaPanel.LineGraphLegendTpl;
import org.grafana.api.templates.Dashboard.GrafanaPanel.LineGraphPanelTpl;

public class OctoLineChart extends OctoBaseChart {
    private String dashboarduid;
    private String dashboardtitle;
    private String tableName;
    private String columns;
    public LineGraphPanelTpl lineGraph;
    public OctoLineChart(SparkSession spark, String dashboarduid, Dataset<Row> df, String workunitname, String summaryname, String paneltitle){
        this.dashboarduid = dashboarduid;
        this.lineGraph = new LineGraphPanelTpl();
        this.lineGraph.setDatasource("PostgreSQL");
        this.lineGraph.setTitle(paneltitle);
        this.lineGraph.setType("graph");
        LineGraphLegendTpl lgl = new LineGraphLegendTpl();
        lgl.setShow(true);
        this.lineGraph.setLegend(lgl);
        this.tableName=workunitname+"_"+summaryname;
        this.updateChartData(spark,df,dashboarduid,workunitname,summaryname);
    }

    public void setColumns(String cols){
        this.columns = cols;
    }
    public void publish(){
        String query = String.format("SELECT\n  year_month AS \"time\", %s FROM %s \nWHERE\n  $__timeFilter(year_month)\nORDER BY 1",this.columns,this.tableName);
        this.lineGraph.setTargets(query,this.tableName,"time_series");
        publish(this.dashboarduid,null,this.lineGraph);
    }
}
