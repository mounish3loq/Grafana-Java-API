package org.grafana.api.driver;

import org.grafana.api.GrafanaAPI;
import org.grafana.api.responses.Dashboard.NewCreateUpdateDashboardRsp;
import org.grafana.api.templates.Dashboard.CreateUpdateDashboardTpl;
import org.grafana.api.templates.Dashboard.DashboardTpl;
import org.grafana.api.templates.Dashboard.GrafanaPanel.PieChartPanelTpl;

public class ExamplePieChart {
    public static void main(String[] args){
        String grafanaserver = "http://172.105.54.174:9000";
        String mainOrgApiKey = "Bearer eyJrIjoieDc1a1lLRXZYVm82Q2p3ZVpnU2RzNWN1RWMzYjhCSXIiLCJuIjoiVGVzdGluZyBBcGkga2V5IiwiaWQiOjF9";
        PieChartPanelTpl pieChartPanel = new PieChartPanelTpl();
        pieChartPanel.setDatasource("PostgreSQL-5");
        pieChartPanel.setTitle("Pie chart test");
        String query = "SELECT now() as time,a.\"a\" as Converters ,a.\"b\" as non_converters FROM post_analysis_agg a";
        pieChartPanel.setTargets(query,"time_series");

        GrafanaAPI grafanaAPI = new GrafanaAPI(grafanaserver);
        CreateUpdateDashboardTpl dashTest = new CreateUpdateDashboardTpl();
        DashboardTpl dashItems = new DashboardTpl();
        dashItems.setPanels(pieChartPanel);
        dashItems.setTitle("MyTestTitle");
        dashTest.setDashboard(dashItems);
        NewCreateUpdateDashboardRsp createUpdateDashboard = grafanaAPI.orgAdminAPI(mainOrgApiKey).createUpdateDashboard(dashTest);
        System.out.println("Response msg : " + createUpdateDashboard.getStatus());
        System.out.println("url is : " + createUpdateDashboard.getUrl());
        System.out.println("id OF dashboard " + createUpdateDashboard.getUid());
    }
}
