package org.grafana.api.octocharts;

import org.grafana.api.GrafanaAPI;
import org.grafana.api.responses.Dashboard.DashboardRsp;
import org.grafana.api.responses.Dashboard.NewCreateUpdateDashboardRsp;
import org.grafana.api.templates.Charts.PlotlyHeatmapPanelChart;
import org.grafana.api.templates.Charts.PlotlyPanelChart;
import org.grafana.api.templates.Dashboard.CreateUpdateDashboardTpl;
import org.grafana.api.templates.Dashboard.DashboardTpl;

public class OctoHeatmapChart extends OctoBaseChart{
    private String uid;
    private String dashboardtitle;
    public PlotlyHeatmapPanelChart heatmapPanel;

    public OctoHeatmapChart(String uid,String datasource,String xtitle,String ytitle,String paneltitle){
        this.uid = uid;
        this.heatmapPanel = new PlotlyHeatmapPanelChart();
        this.heatmapPanel.setDatasource(datasource);
        this.heatmapPanel.setPconfig(xtitle,ytitle);
        this.heatmapPanel.setTitle(paneltitle);
    }
    public void setTrace(String xmapping,String ymapping,String zmapping){
        this.heatmapPanel.setTraces(xmapping,ymapping,zmapping);
    }
    public void setTarget(String query){
        this.heatmapPanel.setTargets(query);
    }
    public void setDashboardtitle(String dashboardtitle){
        this.dashboardtitle = dashboardtitle;
    }

    public void publish(){
        publish(this.uid,null,this.heatmapPanel);
    }

}
