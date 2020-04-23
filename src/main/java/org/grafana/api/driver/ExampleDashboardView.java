package org.grafana.api.driver;

import ca.krasnay.sqlbuilder.SelectBuilder;
import org.grafana.api.GrafanaAPI;
import org.grafana.api.responses.Dashboard.NewCreateUpdateDashboardRsp;
import org.grafana.api.templates.Dashboard.CreateUpdateDashboardTpl;
import org.grafana.api.templates.Dashboard.DashboardTpl;
import org.grafana.api.templates.Dashboard.GrafanaPanel.LineGraphPanelTpl;
import org.grafana.api.templates.Dashboard.GrafanaPanel.PieChartPanelTpl;
import org.grafana.api.templates.Dashboard.GrafanaPanel.TablePanelTpl;

public class ExampleDashboardView {
//    Dashboard will not generate while the dashboard is have same name even with different Uid
    public static void main(String[] args){
        String query = "SELECT\n  year_month AS \"time\",\n  varejo AS \"Varejo\",\n  vestuario AS \"Vestuario\",\n  \"serviço\" AS \"Serviço\",\n  supermercados AS \"Supermercados\",\n  restaurante AS \"Restaurante\",\n  \"posto de gas\" AS \"Posto De Gas\"\nFROM timeseries_analysis\nWHERE\n  $__timeFilter(year_month)\nORDER BY 1";
        OctoLineGraph ol = new OctoLineGraph("ALphabetic1","PanelTitl");
        ol.setTarget(query,"timeseries_analysis");
        ol.publish();

        String tquery = new SelectBuilder()
                .column("a as Converters").column("b as non_Converters").from("post_analysis_agg").toString();
        OctoTable ot = new OctoTable("ALphabetic1","Table Title");
        ot.setTargets(tquery);
        ot.publish();

        String opcquery = "select now() as time,a as Converters,b as Non_Converters from post_analysis_agg";
        OctoPieChart opc = new OctoPieChart("ALphabetic1","piechartTitle");
        opc.setTargets(opcquery);
        opc.publish();

    }
}
