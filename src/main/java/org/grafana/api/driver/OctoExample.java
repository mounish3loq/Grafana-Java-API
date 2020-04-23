package org.grafana.api.driver;

import org.grafana.api.octocharts.OctoBarChart;

public class OctoExample {
    public static void main(String[] args){
        OctoBarChart octoBarChart = new OctoBarChart("ABCDE","MySQL-pre","XData","YData","Bar chart");
        octoBarChart.setTrace("A","B");
        octoBarChart.setTarget("select A,B from sample_table;");
        octoBarChart.publish();
    }
}
