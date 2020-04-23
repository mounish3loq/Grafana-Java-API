package org.grafana.api.driver;

import org.grafana.api.GrafanaAPI;
import org.grafana.api.responses.Dashboard.DashboardRsp;
import org.grafana.api.responses.Dashboard.NewCreateUpdateDashboardRsp;
import org.grafana.api.templates.Dashboard.CreateUpdateDashboardTpl;
import org.grafana.api.templates.Dashboard.DashboardTpl;
import org.grafana.api.templates.Dashboard.GrafanaPanel.PieChartPanelTpl;
import org.grafana.api.templates.Dashboard.GrafanaPanel.TablePanelTpl;

public class OctoPieChart {
    private String uid;
    private String panelTitle;
    private String dataSource;
    private String dashboardTitle;

    private String type;

    private PieChartPanelTpl pct;
    public void setType(String type) {
        this.type = type;
    }

    public OctoPieChart(String uid,String panelTitle){
        this.uid = uid;
        this.pct = new PieChartPanelTpl();
        this.pct.setPieType("pie");
        this.pct.setDatasource("PostgreSQL-5");
        this.pct.setTitle(panelTitle);

    }
    public void setTargets(String query){
        this.pct.setTargets(query,"time_series");
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
        dashItems.setPanels(this.pct);
        dashTest.setDashboard(dashItems);
        NewCreateUpdateDashboardRsp createUpdateDashboard = grafanaAPI.orgAdminAPI(mainOrgApiKey).createUpdateDashboard(dashTest);
    }
}
