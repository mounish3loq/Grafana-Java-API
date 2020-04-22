package org.grafana.api.driver;

import ca.krasnay.sqlbuilder.SelectBuilder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.grafana.api.GrafanaAPI;
import org.grafana.api.responses.Dashboard.NewCreateUpdateDashboardRsp;
import org.grafana.api.templates.Charts.PlotlyHeatmapPanelChart;
import org.grafana.api.templates.Dashboard.CreateUpdateDashboardTpl;
import org.grafana.api.templates.Dashboard.DashboardTpl;

import java.io.FileWriter;
import java.io.IOException;

public class ExampleHeatmap {
    public static void main(String[] args){
        Gson gson = new GsonBuilder().create();
        //Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();
        String grafanaserver = "http://localhost:3000";
        String mainOrgApiKey = "Bearer eyJrIjoiSmtSNUY2R3RyV0hVQ0oxQ0E5NlJlZ0lXYVp4Z0s0T1QiLCJuIjoiVGVzdCBLZXkiLCJpZCI6MX0= ";

        //Initializing a panel
        PlotlyHeatmapPanelChart heatmapPanel = new PlotlyHeatmapPanelChart();
        heatmapPanel.setDatasource("MySQL-pre");

        //Setting configuration: xaxis-title,yaxis-title,type of chart
        heatmapPanel.setPconfig("XData","YData");
        heatmapPanel.setTraces("category","category","Agencia_de_tur");

        //Setting query
        String query = new SelectBuilder().column("category").from("insight8").toString();
        heatmapPanel.setTargets(query);
        String query2 = new SelectBuilder()
                            .column("Agencia_de_tur")
                            .column("Alug_de_carros")
                            .column("ARTIGOS_ELETRO")
                            .column("AUTO_PECAS")
                            .column("CIA_AEREAS")
                            .column("FARMACIAS")
                            .column("HOSP_E_CLINICA")
                            .column("HOTEIS")
                            .column("INEXISTENTE")
                            .column("JOALHERIA")
                            .column("LOJA_DE_DEPART")
                            .column("MOTO")
                            .column("MAT_CONSTRUCAO")
                            .column("MOVEIS_E_DECOR")
                            .column("POSTO_DE_GAS")
                            .column("RESTAURANTE")
                            .column("SEM_RAMO")
                            .column("SERVICO")
                            .column("SUPERMERCADOS")
                            .column("TRANS_FINANC")
                            .column("VAREJO")
                            .column("VESTUARIO")
                            .from("insight8")
                            .toString();
        heatmapPanel.setTargets(query2);

        //Setting title of panel
        heatmapPanel.setTitle("Bar chart");

        //Initialising grafana server
        GrafanaAPI grafanaAPI = new GrafanaAPI(grafanaserver);

        //Creating a template for dashboard higher level
        CreateUpdateDashboardTpl dashTest = new CreateUpdateDashboardTpl();

        //Creating a template for dashboard lower level
        DashboardTpl dashItems = new DashboardTpl();

        //Adding list/single of panels to dashboard
        dashItems.setPanels(heatmapPanel);

        //Setting title for dashboard
        dashItems.setTitle("MyTestTitle2");

        //Passing lower level dashboard to higher level dashboard
        dashTest.setDashboard(dashItems);
        //dashTest.setOverwrite(false);

        //Store generated dashboard json data
        try{
            FileWriter fw = new FileWriter("dashtest.json");
            fw.write(gson.toJson(dashTest));
            fw.close();
        }catch (IOException ie){
            System.out.println("File error");
        }

        //Calling dashboard creation API endpoint.
        NewCreateUpdateDashboardRsp createUpdateDashboard = grafanaAPI.orgAdminAPI(mainOrgApiKey).createUpdateDashboard(dashTest);
        System.out.println("Response msg : " + createUpdateDashboard.getStatus());
        System.out.println("url is : " + createUpdateDashboard.getUrl());
        System.out.println("Uid across grafana servers" + createUpdateDashboard.getUid());
        System.out.println("id unique within a server" + createUpdateDashboard.getId());
    }
}
