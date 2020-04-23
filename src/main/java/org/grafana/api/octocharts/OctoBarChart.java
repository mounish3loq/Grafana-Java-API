package org.grafana.api.octocharts;

import org.grafana.api.GrafanaAPI;
import org.grafana.api.responses.Dashboard.DashboardRsp;
import org.grafana.api.responses.Dashboard.NewCreateUpdateDashboardRsp;
import org.grafana.api.templates.Charts.PlotlyPanelChart;
import org.grafana.api.templates.Dashboard.CreateUpdateDashboardTpl;
import org.grafana.api.templates.Dashboard.DashboardTpl;

public class OctoBarChart {
    private String uid;
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
    public void publish(){
        String grafanaserver = "http://localhost:3000";
        String mainOrgApiKey = "Bearer eyJrIjoiSmtSNUY2R3RyV0hVQ0oxQ0E5NlJlZ0lXYVp4Z0s0T1QiLCJuIjoiVGVzdCBLZXkiLCJpZCI6MX0= ";
        GrafanaAPI grafanaAPI = new GrafanaAPI(grafanaserver);
        DashboardTpl dashItems;
        DashboardRsp dashboardRsp = grafanaAPI.orgAdminAPI(mainOrgApiKey).getDashboardByUid(this.uid);
        if (dashboardRsp == null){
            dashItems = new DashboardTpl();
            dashItems.setUid(this.uid);
            dashItems.setTitle("MyTestTitle2");
        }else{
            dashItems = dashboardRsp.getDashboard();
        }
        CreateUpdateDashboardTpl dashTest = new CreateUpdateDashboardTpl();
        dashItems.setPanels(this.barpanel);
        dashTest.setDashboard(dashItems);
        NewCreateUpdateDashboardRsp createUpdateDashboard = grafanaAPI.orgAdminAPI(mainOrgApiKey).createUpdateDashboard(dashTest);
    }

}
