package org.grafana.api.driver;

import ca.krasnay.sqlbuilder.SelectBuilder;
import org.grafana.api.octocharts.OctoBarChart;
import org.grafana.api.octocharts.OctoHeatmapChart;

public class OctoExample {
    public static void main(String[] args){
        OctoBarChart octoBarChart = new OctoBarChart("ABCDE","MySQL-pre","XData","YData","Bar chart");
        octoBarChart.setTrace("A","B");
        octoBarChart.setTarget("select A,B from sample_table;");
        octoBarChart.publish();

        OctoHeatmapChart octoHeatmapChart = new OctoHeatmapChart("ABCDE","MySQL-pre","XData","YData","Bar chart");
        octoHeatmapChart.setTrace("category","category","Agencia_de_tur");
        String query = new SelectBuilder().column("category").from("insight8").toString();
        octoHeatmapChart.setTarget(query);
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
        octoHeatmapChart.setTarget(query2);
        octoHeatmapChart.publish();
    }
}
