package org.grafana.api.driver;

import org.grafana.api.GrafanaAPI;
import org.grafana.api.responses.Dashboard.DashboardRsp;
import org.grafana.api.responses.Dashboard.NewCreateUpdateDashboardRsp;
import org.grafana.api.templates.Dashboard.CreateUpdateDashboardTpl;
import org.grafana.api.templates.Dashboard.DashboardTpl;
import org.grafana.api.templates.Dashboard.GrafanaPanel.LineGraphLegendTpl;
import org.grafana.api.templates.Dashboard.GrafanaPanel.LineGraphPanelTpl;

public class OctoLineGraph {
    private String uid;
    private String panelTitle;
    private String dataSource;
    private String dashboardTitle;
    private LineGraphPanelTpl lineGraph;

    public String getDashboardTitle() {
        return dashboardTitle;
    }

    public void setDashboardTitle(String dashboardTitle) {
        this.dashboardTitle = dashboardTitle;
    }

    public  OctoLineGraph(String uid,String panelTitle){
        this.uid = uid;
        this.lineGraph = new LineGraphPanelTpl();
        this.lineGraph.setDatasource("PostgreSQL-5");
        this.lineGraph.setTitle(panelTitle);
        this.lineGraph.setType("graph");
        LineGraphLegendTpl lgl = new LineGraphLegendTpl();
        lgl.setShow(true);
        this.lineGraph.setLegend(lgl);


    }
    public void setTarget(String query,String tablename ){
        this.lineGraph.setTargets(query,tablename,"time_series");
    }
    public void publish(){
        String grafanaserver = "http://172.105.54.174:9000";
        String mainOrgApiKey = "Bearer eyJrIjoianJldWtyMTdGbkgzNUJHT3kzMmlhbzNDMHBieU5XT0giLCJuIjoiVXNlZCBieSBHYW5nYWRoYXIiLCJpZCI6MX0=";
        GrafanaAPI grafanaAPI = new GrafanaAPI(grafanaserver);
        DashboardTpl dashItems;
        DashboardRsp dashboardRsp = grafanaAPI.orgAdminAPI(mainOrgApiKey).getDashboardByUid(this.uid);
        if (dashboardRsp == null){
            dashItems = new DashboardTpl();
            dashItems.setUid(this.uid);
            if (this.dashboardTitle == null) {
                dashItems.setTitle("MyTestTitle2");
            }else{
                dashItems.setTitle(this.dashboardTitle);
            }
        }else{
            dashItems = dashboardRsp.getDashboard();
        }
        CreateUpdateDashboardTpl dashTest = new CreateUpdateDashboardTpl();
        dashItems.setPanels(this.lineGraph);
        dashTest.setDashboard(dashItems);
        NewCreateUpdateDashboardRsp createUpdateDashboard = grafanaAPI.orgAdminAPI(mainOrgApiKey).createUpdateDashboard(dashTest);
    }

}
