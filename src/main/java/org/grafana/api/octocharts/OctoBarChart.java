package org.grafana.api.octocharts;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.grafana.api.templates.Charts.PlotlyPanelChart;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
public class OctoBarChart extends OctoBaseChart{
    static Logger log = Logger.getLogger(OctoBarChart.class.getName());
    private String uid;
    private String dashboardtitle;
    private String tableName;
    public PlotlyPanelChart barpanel;

    public OctoBarChart(SparkSession spark,String dashboarduid, Dataset<Row> df, String workunitname, String summaryname, String xtitle, String ytitle, String paneltitle){

        log.info("Octo Bar Chart Spark Session Id: " + spark +" Table Name: " + workunitname+ "_"+summaryname +" Panel Title : " +paneltitle);

        this.uid = dashboarduid;
        this.barpanel = new PlotlyPanelChart();
        this.barpanel.setDatasource("PostgreSQL");
        this.barpanel.setPconfig(xtitle,ytitle,"bar");
        this.barpanel.setTitle(paneltitle);
        this.tableName=workunitname+"_"+summaryname;
        this.updateChartData(spark,df,dashboarduid,workunitname,summaryname);


    }
    public void setTrace(String xmapping,String ymapping){
        log.info("X Mapping :"+xmapping+" Y Mapping : "+ymapping);
        this.barpanel.setTraces(xmapping,ymapping);
        this.barpanel.setTargets(String.format("select %s,%s from %s",xmapping,ymapping,this.tableName));
    }
    public void setTarget(String query){
        log.info("Set Target ");this.barpanel.setTargets(query);
    }
    public void setDashboardtitle(String dashboardtitle){
        log.info("Set Dashboard Title: "+ dashboardtitle);this.dashboardtitle = dashboardtitle;
    }
    public void publish(){

        log.info("OctoBar Chart Publish");
        try{
        publish(this.uid,null,this.barpanel);
    }catch (Exception e){
            log.log(Level.SEVERE,"Excepion "+e);
        }

    }

}
