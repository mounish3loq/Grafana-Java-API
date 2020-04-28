package org.grafana.api.octocharts;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.grafana.api.templates.Charts.PlotlyPanelChart;

public class OctoBarChart extends OctoBaseChart{
    private String uid;
    private String dashboardTitle;
    private String tableName;
    public PlotlyPanelChart barpanel;

    public OctoBarChart(SparkSession spark,String dashboarduid, Dataset<Row> df, String workunitname, String summaryname, String xtitle, String ytitle, String paneltitle){
        this.uid = dashboarduid;
        this.dashboardTitle = null;
        this.barpanel = new PlotlyPanelChart();
        this.barpanel.setDatasource("PostgreSQL");
        this.barpanel.setPconfig(xtitle,ytitle,"bar");
        this.barpanel.setTitle(paneltitle);
        this.tableName=workunitname+"_"+summaryname;
        this.updateChartData(spark,df,dashboarduid,workunitname,summaryname);
    }
    public void setTrace(String xmapping,String ymapping){
        this.barpanel.setTraces(xmapping,ymapping);
        this.barpanel.setTargets(String.format("select %s,%s from %s where dashboardid = \'%s\'",xmapping,ymapping,this.tableName,this.uid));
    }
    public void setTarget(String query){
        this.barpanel.setTargets(query);
    }
    public void setDashboardtitle(String dashboardTitle){
        this.dashboardTitle = dashboardTitle;
    }
    public void publish(){
        Gson gson = new GsonBuilder().create();
        publish(this.uid,this.dashboardTitle,this.barpanel);
    }

}
