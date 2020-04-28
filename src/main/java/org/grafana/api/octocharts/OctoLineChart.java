package org.grafana.api.octocharts;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.grafana.api.templates.Charts.PlotlyPanelChart;
import org.grafana.api.templates.Dashboard.GrafanaPanel.LineGraphLegendTpl;
import org.grafana.api.templates.Dashboard.GrafanaPanel.LineGraphPanelTpl;

import java.util.logging.Level;
import java.util.logging.Logger;

public class OctoLineChart extends OctoBaseChart {
    static Logger log = Logger.getLogger(OctoLineChart.class.getName());
    private String dashboarduid;
    private String dashboardtitle;
    private String tableName;
    private String columns;
    private String timecolumn;
    public LineGraphPanelTpl lineGraph;

    public OctoLineChart(SparkSession spark, String dashboarduid, Dataset<Row> df, String workunitname, String summaryname, String paneltitle){
        log.info("OctoLineChart Spark Session : "+spark + " Dashboard UID: "+dashboarduid+ " Table Name : "+workunitname+"_"+summaryname+"Panel Title : "+paneltitle);
        this.dashboarduid = dashboarduid;
        this.dashboardtitle = null;
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
    public void setTimeColumn(String col){
        this.timecolumn = col;
    }
    public void publish(){
        String query = String.format("SELECT\n  %s AS \"time\", %s FROM %s \nWHERE\n dashboardid = \'%s\' and $__timeFilter(%s)\nORDER BY 1",this.timecolumn,this.columns,this.tableName,this.dashboarduid,this.timecolumn);
        this.lineGraph.setTargets(query,this.tableName,"time_series");
        try {
            publish(this.dashboarduid, this.dashboardtitle, this.lineGraph);
        }catch (Exception e){
            log.log(Level.SEVERE,"OctoLine Chart Publish Exception "+e.toString());
        }
    }
    public void setDashboardtitle(String dashboardtitle){
        this.dashboardtitle = dashboardtitle;
    }
}
