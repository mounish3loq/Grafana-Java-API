package org.grafana.api.driver;

import org.grafana.api.GrafanaAPI;
import org.grafana.api.responses.Dashboard.DashboardRsp;
import org.grafana.api.responses.Dashboard.NewCreateUpdateDashboardRsp;
import org.grafana.api.templates.Dashboard.CreateUpdateDashboardTpl;
import org.grafana.api.templates.Dashboard.DashboardTpl;
import org.grafana.api.templates.Dashboard.GrafanaPanel.TablePanelTpl;

public class OctoTable {
    private String uid;
    private String panelTitle;
    private String dataSource;
    private String dashboardTitle;
    private TablePanelTpl tpl;

    public OctoTable(String uid,String panelTitle){
        this.uid = uid;
        this.tpl = new TablePanelTpl();
        this.tpl.setType("table");
        this.tpl.setDatasource("PostgreSQL-5");
        this.tpl.setTitle(panelTitle);

    }
    public void setTargets(String query){
        this.tpl.setTargets(query);
    }
    public  void publish(){
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
        dashItems.setPanels(this.tpl);
        dashTest.setDashboard(dashItems);
        NewCreateUpdateDashboardRsp createUpdateDashboard = grafanaAPI.orgAdminAPI(mainOrgApiKey).createUpdateDashboard(dashTest);
    }
}
