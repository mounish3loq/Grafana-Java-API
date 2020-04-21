package org.grafana.api.driver;

import ca.krasnay.sqlbuilder.SelectBuilder;
import org.grafana.api.GrafanaAPI;
import org.grafana.api.responses.Dashboard.NewCreateUpdateDashboardRsp;
import org.grafana.api.templates.Charts.PlotlyPanelChart;
import org.grafana.api.templates.Dashboard.CreateUpdateDashboardTpl;
import org.grafana.api.templates.Dashboard.DashboardTpl;

public class Example3 {
    public static void main(String args[]){
        //Gson gson = new GsonBuilder().create();
        //Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();
        String grafanaserver = "http://localhost:3000";
        String mainOrgApiKey = "Bearer eyJrIjoiSmtSNUY2R3RyV0hVQ0oxQ0E5NlJlZ0lXYVp4Z0s0T1QiLCJuIjoiVGVzdCBLZXkiLCJpZCI6MX0= ";

        //Initializing a panel
        PlotlyPanelChart barpanel = new PlotlyPanelChart();
        barpanel.setDatasource("MySQL-pre");

        //Setting configuration: xaxis-title,yaxis-title,type of chart
        barpanel.setPconfig("XData","YData","bar");
        barpanel.setTraces("A","B");

        //Setting query
        String query = new SelectBuilder().column("A").column("B").from("sample_table").toString();
        barpanel.setTargets(query);

        //Setting title of panel
        barpanel.setTitle("Bar chart");

        //Initialising grafana server
        GrafanaAPI grafanaAPI = new GrafanaAPI(grafanaserver);

        //Creating a template for dashboard higher level
        CreateUpdateDashboardTpl dashTest = new CreateUpdateDashboardTpl();

        //Creating a template for dashboard lower level
        DashboardTpl dashItems = new DashboardTpl();

        //Adding list/single of panels to dashboard
        dashItems.setPanels(barpanel);

        //Setting title for dashboard
        dashItems.setTitle("MyTestTitle");

        //Passing lower level dashboard to higher level dashboard
        dashTest.setDashboard(dashItems);

        /* Store generated dashboard json data
        try{
            FileWriter fw = new FileWriter("dashtest.json");
            fw.write(gson.toJson(dashTest));
            fw.close();
        }catch (IOException ie){
            System.out.println("File error");
        }
        */

        //Calling dashboard creation API endpoint.
        NewCreateUpdateDashboardRsp createUpdateDashboard = grafanaAPI.orgAdminAPI(mainOrgApiKey).createUpdateDashboard(dashTest);
        System.out.println("Response msg : " + createUpdateDashboard.getStatus());
        System.out.println("url is : " + createUpdateDashboard.getUrl());
        System.out.println("Uid across grafana servers" + createUpdateDashboard.getUid());
        System.out.println("id unique within a server" + createUpdateDashboard.getId());
    }
}
