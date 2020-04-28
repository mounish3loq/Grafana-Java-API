package org.grafana.api.octocharts;

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
    public PlotlyHeatmapPanelChart heatmapPanel;

    public OctoHeatmapChart(String uid,String datasource,String xtitle,String ytitle,String paneltitle){
        log.info("Data Source: "+datasource+" X Title :"+xtitle +" Y Title : "+ytitle +" Panel Title : "+paneltitle);
        this.uid = uid;
        this.heatmapPanel = new PlotlyHeatmapPanelChart();
        this.heatmapPanel.setDatasource(datasource);
        this.heatmapPanel.setPconfig(xtitle,ytitle);
        this.heatmapPanel.setTitle(paneltitle);
    }
    public void setTrace(String xmapping,String ymapping,String zmapping){
        String s = String.format("SetTrace X Mappings %s Y Mappings %s Z Mappings %s",xmapping,ymapping,zmapping);
        log.info(s);
        this.heatmapPanel.setTraces(xmapping,ymapping,zmapping);
    }
    public void setTarget(String query){
        try{
        this.heatmapPanel.setTargets(query);
    }catch (Exception e){
         log.log(Level.SEVERE,"HeatMap Set Target Exception "+e.toString());
        }
    }
    public void setDashboardtitle(String dashboardtitle){
        this.dashboardtitle = dashboardtitle;
    }

    public void publish(){
        try {
            publish(this.uid,null,this.heatmapPanel);
        }catch (Exception e){
            log.log(Level.SEVERE,"HeatMap Publish Exception "+e.toString());
        }
    }

}
