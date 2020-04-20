package org.grafana.api.driver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.grafana.api.GrafanaAPI;
import org.grafana.api.responses.Dashboard.NewCreateUpdateDashboardRsp;
import org.grafana.api.templates.Charts.PlotlyPanelChart;
import org.grafana.api.templates.Dashboard.CreateUpdateDashboardTpl;
import org.grafana.api.templates.Dashboard.DashboardTpl;
import org.grafana.api.templates.Dashboard.Panel.Pconfig.Traces.TraceMappingTpl;
import org.grafana.api.templates.Dashboard.Panel.Pconfig.TracesTpl;
import org.grafana.api.templates.Dashboard.Panel.TargetsTpl;

import java.util.ArrayList;
import java.util.List;

public class Example2 {
    public static void main(String args[]){
        Gson gson = new GsonBuilder().create();
        Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();
        String grafanaserver = "http://localhost:3000";
        String mainOrgApiKey = "Bearer eyJrIjoiSmtSNUY2R3RyV0hVQ0oxQ0E5NlJlZ0lXYVp4Z0s0T1QiLCJuIjoiVGVzdCBLZXkiLCJpZCI6MX0= ";

        //Initializing a panel
        PlotlyPanelChart barpanel = new PlotlyPanelChart();
        barpanel.setDatasource("MySQL-pre");

        //Creating a mapping with axes to metrics
        TraceMappingTpl tmpt = new TraceMappingTpl();
        tmpt.setX("A");
        tmpt.setY("B");

        //Creating a trace and passing the mapping object
        TracesTpl trt = new TracesTpl();
        trt.setMapping(tmpt);

        //Creating a traces list and passing a trace object to it
        ArrayList<TracesTpl> TracesTplList = new ArrayList<>();
        TracesTplList.add(trt);

        //Setting configuration: xaxis-title,yaxis-title,type of chart,traceslist
        barpanel.setPconfig("XData","YData","bar",TracesTplList);

        //Creating a target object which takes in an sql query
        TargetsTpl tt = new TargetsTpl("select * from sample_table;");

        //Creating a list of target objects and passing a target object to it
        List<Object> TargetsTplList = new ArrayList<>();
        TargetsTplList.add(tt);
        //Setting target list.
        barpanel.setTargets(TargetsTplList);

        //Setting title of panel
        barpanel.setTitle("Bar chart");

        //Choosing type of plugin
        barpanel.setType("natel-plotly-panel");

        //Initialising grafana server
        GrafanaAPI grafanaAPI = new GrafanaAPI(grafanaserver);

        //Creating a template for dashboard higher level
        CreateUpdateDashboardTpl dashTest = new CreateUpdateDashboardTpl();

        //Creating a template for dashboard lower level
        DashboardTpl dashItems = new DashboardTpl();

        //Creating a list of panels to and appending a panel to it.
        List<Object> PanelsList = new ArrayList<>();
        PanelsList.add(barpanel);

        //Adding list of panels to dashboard
        dashItems.setPanels(PanelsList);

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
    }
}
