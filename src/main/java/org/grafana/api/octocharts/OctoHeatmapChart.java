package org.grafana.api.octocharts;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.grafana.api.GrafanaAPI;
import org.grafana.api.responses.Dashboard.DashboardRsp;
import org.grafana.api.responses.Dashboard.NewCreateUpdateDashboardRsp;
import org.grafana.api.templates.Charts.PlotlyHeatmapPanelChart;
import org.grafana.api.templates.Charts.PlotlyPanelChart;
import org.grafana.api.templates.Dashboard.CreateUpdateDashboardTpl;
import org.grafana.api.templates.Dashboard.DashboardTpl;

import java.util.logging.Level;
import java.util.logging.Logger;

public class OctoHeatmapChart extends OctoBaseChart{ 
    static Logger log = Logger.getLogger(OctoHeatmapChart.class.getName());
    private String uid;
    private String dashboardtitle;
    private String tableName;
    private String workunitName;
    public PlotlyHeatmapPanelChart heatmapPanel;
  
    public OctoHeatmapChart(SparkSession spark, String dashboarduid, Dataset<Row> df, String workunitname, String summaryname, String xtitle, String ytitle, String paneltitle){
        this.uid = dashboarduid;
        this.dashboardtitle = null;
        this.heatmapPanel = new PlotlyHeatmapPanelChart();
        this.heatmapPanel.setDatasource(System.getenv("GRAFANA_POSTGRES_DATASOURCE"));
        this.heatmapPanel.setPconfig(xtitle,ytitle);
        this.heatmapPanel.setTitle(paneltitle);
        this.workunitName = workunitname;
        this.tableName=workunitname.substring(workunitname.lastIndexOf('.') + 1) +"_"+ summaryname;
        this.updateChartData(spark,df,dashboarduid,workunitname,summaryname);
    }
    public void setTrace(String xmapping,String ymapping,String zmapping){
        String s = String.format("SetTrace X Mappings %s Y Mappings %s Z Mappings %s",xmapping,ymapping,zmapping);
        log.info(s);
        this.heatmapPanel.setTraces(xmapping,ymapping,zmapping);
    }
    public void setTarget(String column){
        try{
            this.heatmapPanel.setTargets(String.format("select %s from %s where dashboardid = \'%s\'",column,this.tableName,this.uid));
        }catch (Exception e){
            log.log(Level.SEVERE,"HeatMap Set Target Exception "+e.toString());
        }
    }
    public void setDashboardtitle(String dashboardtitle){
        this.dashboardtitle = dashboardtitle;
    }

    public void publish(){
        try {
            super.publish(this.uid,this.dashboardtitle,this.heatmapPanel,this.workunitName);
        }catch (Exception e){
            log.log(Level.SEVERE,"HeatMap Publish Exception "+e.toString());
        }
    }

}
