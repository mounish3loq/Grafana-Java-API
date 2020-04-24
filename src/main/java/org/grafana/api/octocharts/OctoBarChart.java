package org.grafana.api.octocharts;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.grafana.api.templates.Charts.PlotlyPanelChart;

public class OctoBarChart extends OctoBaseChart{
    private String uid;
    private String dashboardtitle;
    private String tableName;
    public PlotlyPanelChart barpanel;

    public OctoBarChart(SparkSession spark,String dashboarduid, Dataset<Row> df, String workunitname, String summaryname, String xtitle, String ytitle, String paneltitle){
        this.uid = dashboarduid;
        this.barpanel = new PlotlyPanelChart();
        this.barpanel.setDatasource("PostgreSQL");
        this.barpanel.setPconfig(xtitle,ytitle,"bar");
        this.barpanel.setTitle(paneltitle);
        this.tableName=workunitname+"_"+summaryname;
        this.updateChartData(spark,df,dashboarduid,workunitname,summaryname);
    }
    public void setTrace(String xmapping,String ymapping){
        this.barpanel.setTraces(xmapping,ymapping);
        this.barpanel.setTargets(String.format("select %s,%s from %s",xmapping,ymapping,this.tableName));
    }
    public void setTarget(String query){
        this.barpanel.setTargets(query);
    }
    public void setDashboardtitle(String dashboardtitle){
        this.dashboardtitle = dashboardtitle;
    }
    public void publish(){
        publish(this.uid,null,this.barpanel);
    }

}
