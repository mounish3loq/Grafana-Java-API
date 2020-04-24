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
        String query = "SELECT\n  year_month AS \"time\",\n  varejo AS \"Varejo\",\n  vestuario AS \"Vestuario\",\n  \"serviÇo\" AS \"Serviço\",\n  supermercados AS \"Supermercados\",\n  restaurante AS \"Restaurante\",\n  \"posto_de_gas\" AS \"Posto De Gas\"\nFROM " + this.tableName+" \nWHERE\n  $__timeFilter(year_month)\nORDER BY 1";
        this.lineGraph.setTargets(query,this.tableName,"time_series");
        this.updateChartData(spark,df,dashboarduid,workunitname,summaryname);
    }
    public void publish(){
        publish(this.dashboarduid,null,this.lineGraph);
    }
}
