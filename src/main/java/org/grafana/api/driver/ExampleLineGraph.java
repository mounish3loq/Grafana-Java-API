package org.grafana.api.driver;
import org.grafana.api.GrafanaAPI;
import org.grafana.api.responses.Dashboard.NewCreateUpdateDashboardRsp;
import org.grafana.api.templates.Dashboard.CreateUpdateDashboardTpl;
import org.grafana.api.templates.Dashboard.DashboardTpl;
import org.grafana.api.templates.Dashboard.GrafanaPanel.LineGraphPanelTpl;

public class ExampleLineGraph {
    public static void main(String[] args){
    String grafanaserver = "http://172.105.54.174:9000";
    String mainOrgApiKey = "Bearer eyJrIjoianJldWtyMTdGbkgzNUJHT3kzMmlhbzNDMHBieU5XT0giLCJuIjoiVXNlZCBieSBHYW5nYWRoYXIiLCJpZCI6MX0=";
    LineGraphPanelTpl p = new LineGraphPanelTpl();
    p.setDatasource("PostgreSQL-5");
    p.setTitle("Sample Line Test");
    p.setType("graph");
    String query = "SELECT\n  year_month AS \"time\",\n  varejo AS \"Varejo\",\n  vestuario AS \"Vestuario\",\n  \"serviço\" AS \"Serviço\",\n  supermercados AS \"Supermercados\",\n  restaurante AS \"Restaurante\",\n  \"posto de gas\" AS \"Posto De Gas\"\nFROM timeseries_analysis\nWHERE\n  $__timeFilter(year_month)\nORDER BY 1";
    p.setTargets(query,"timeseries_analysis","time_series");


    GrafanaAPI grafanaAPI = new GrafanaAPI(grafanaserver);
    CreateUpdateDashboardTpl dashTest = new CreateUpdateDashboardTpl();
    DashboardTpl dashItems = new DashboardTpl();
    dashItems.setPanels(p);
    dashItems.setTitle("MyTestTitle1");
    dashTest.setDashboard(dashItems);
    NewCreateUpdateDashboardRsp createUpdateDashboard = grafanaAPI.orgAdminAPI(mainOrgApiKey).createUpdateDashboard(dashTest);
    System.out.println("Response msg : " + createUpdateDashboard.getStatus());
    System.out.println("url is : " + createUpdateDashboard.getUrl());
    System.out.println("id OF dashboard " + createUpdateDashboard.getUid());
}}