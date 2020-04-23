package org.grafana.api.octocharts;

import org.grafana.api.GrafanaAPI;
import org.grafana.api.responses.Dashboard.DashboardRsp;
import org.grafana.api.responses.Dashboard.NewCreateUpdateDashboardRsp;
import org.grafana.api.templates.Charts.PlotlyPanelChart;
import org.grafana.api.templates.Dashboard.CreateUpdateDashboardTpl;
import org.grafana.api.templates.Dashboard.DashboardTpl;

public class OctoBarChart extends OctoBaseChart{
    private String uid;
    private String dashboardtitle;
    public PlotlyPanelChart barpanel;

    public OctoBarChart(String uid,String datasource,String xtitle,String ytitle,String paneltitle){
        this.uid = uid;
        this.barpanel = new PlotlyPanelChart();
        this.barpanel.setDatasource(datasource);
        this.barpanel.setPconfig(xtitle,ytitle,"bar");
        this.barpanel.setTitle(paneltitle);
    }
    public void setTrace(String xmapping,String ymapping){
        this.barpanel.setTraces(xmapping,ymapping);
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
