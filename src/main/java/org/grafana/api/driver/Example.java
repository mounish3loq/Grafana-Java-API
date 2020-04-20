package org.grafana.api.driver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import org.grafana.api.GrafanaAPI;
import org.grafana.api.responses.AdminAPI.OrganisationRsp;
import org.grafana.api.responses.Dashboard.DashboardTagRsp;
import org.grafana.api.responses.Dashboard.NewCreateUpdateDashboardRsp;
import org.grafana.api.templates.Dashboard.CreateUpdateDashboardTpl;
import org.grafana.api.templates.Dashboard.DashboardTpl;
import org.grafana.api.templates.Dashboard.Panel.GridPosTpl;
import org.grafana.api.templates.Dashboard.Panel.PanelTpl;
import org.grafana.api.templates.Dashboard.Panel.Pconfig.Traces.TraceMappingTpl;
import org.grafana.api.templates.Dashboard.Panel.Pconfig.TracesTpl;
import org.grafana.api.templates.Dashboard.Panel.PconfigTpl;
import org.grafana.api.templates.Dashboard.Panel.TargetsTpl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Example {
    public static void main(String args[]) {
        Gson gson = new GsonBuilder().create();
        Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();
        String grafanaserver = "http://localhost:3000";
        String mainOrgApiKey = "Bearer eyJrIjoiSmtSNUY2R3RyV0hVQ0oxQ0E5NlJlZ0lXYVp4Z0s0T1QiLCJuIjoiVGVzdCBLZXkiLCJpZCI6MX0= ";
        String username = "admin";
        String passwd = "admin";

        PanelTpl barpanel = new PanelTpl();
        barpanel.setDatasource("MySQL-pre");

        GridPosTpl gr = new GridPosTpl();
        barpanel.setGridPos(gr);

        //barpanel.setID(2);

        PconfigTpl pct = new PconfigTpl();

        TraceMappingTpl tmpt = new TraceMappingTpl();
        tmpt.setX("A");
        tmpt.setY("B");

        TracesTpl trt = new TracesTpl();
        trt.setMapping(tmpt);

        List<TracesTpl> TracesTplList = new ArrayList<>();
        TracesTplList.add(trt);

        pct.setTraces(TracesTplList);
        barpanel.setPconfig(pct);

        TargetsTpl tt = new TargetsTpl("select * from sample_table;");
        List<Object> TargetsTplList = new ArrayList<>();
        TargetsTplList.add(tt);
        barpanel.setTargets(TargetsTplList);

        barpanel.setTitle("Bar Panel");
        barpanel.setType("natel-plotly-panel");
        //barpanel.setVersion(1);

        GrafanaAPI grafanaAPI = new GrafanaAPI(grafanaserver);
        CreateUpdateDashboardTpl dashTest = new CreateUpdateDashboardTpl();
        DashboardTpl dashItems = new DashboardTpl();
        List<Object> PanelsList = new ArrayList<>();
        PanelsList.add(barpanel);
        dashItems.setPanels(PanelsList);
        dashItems.setTitle("MyTestTitle");
        dashTest.setDashboard(dashItems);
        try{
            FileWriter fw = new FileWriter("dashtest.json");
            fw.write(gson.toJson(dashTest));
            fw.close();
        }catch (IOException ie){
            System.out.println("File error");
        }
        NewCreateUpdateDashboardRsp createUpdateDashboard = grafanaAPI.orgAdminAPI(mainOrgApiKey).createUpdateDashboard(dashTest);
        System.out.println("Response msg : " + createUpdateDashboard.getStatus());
        System.out.println("url is : " + createUpdateDashboard.getUrl());
        /*
        CreateUpdateDashboardTpl jr = null;
        try{
            BufferedReader br = new BufferedReader(new FileReader("DemoDash.json"));
            jr = gson.fromJson(br, CreateUpdateDashboardTpl.class);
        }catch (FileNotFoundException fe){
            System.out.println("File not found");
        }
        NewCreateUpdateDashboardRsp createUpdateDashboard = grafanaAPI.orgAdminAPI(mainOrgApiKey).createUpdateDashboard(jr);
        System.out.println("Response msg : " + createUpdateDashboard.getStatus());
        System.out.println("url is : " + createUpdateDashboard.getUrl());
         */
        /* Get all Dashboard Tags of current API Key Context*/
        /*
        grafanaAPI.orgAdminAPI(mainOrgApiKey).getDashboardTags().stream().forEach((DashboardTagRsp item) -> {
            System.out.println("Tags:");
            System.out.println(gsonPretty.toJson(item));
        });
         */
        //System.out.println(gsonPretty.toJson(grafanaAPI.orgAdminAPI(mainOrgApiKey).getDashboardHome()));
        //System.out.println(gsonPretty.toJson(grafanaAPI.serverAdminAPI(username,passwd).getOrgByID("1")));
    }
}
