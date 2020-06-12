package org.grafana.api.driver;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.grafana.api.octocharts.OctoBarChart;
import org.grafana.api.octocharts.OctoCreateDashboardVariable;


import java.util.Properties;

public class DashboardVariableExample {
    public static void main(String[] args) {
        SparkSession spark = SparkSession
                .builder()
                .master("local")
                .appName("Java Spark SQL basic example")
                .config("spark.some.config.option", "some-value")
                .getOrCreate();
        Properties connectionProperties = new Properties();
        connectionProperties.put("user", System.getenv("GRAFANA_POSTGRES_USERNAME"));
        connectionProperties.put("password", System.getenv("GRAFANA_POSTGRES_PASSWORD"));
        Dataset<Row> df =spark.read()
                .jdbc("jdbc:postgresql://"+System.getenv("GRAFANA_POSTGRES_URL")+"/"+System.getenv("GRAFANA_POSTGRES_DB"), "sample_table", connectionProperties);

        String dashboardId = "ABCDKE";

        OctoCreateDashboardVariable var = new OctoCreateDashboardVariable(dashboardId,"worker1","change");
        var.setVariableOption("a");
        var.setVariableOption("b");
        var.publish();

        OctoBarChart octoBarChart = new OctoBarChart(spark,dashboardId,df,"asd.abc.worker1", "asd.abc.Sampleworkunit","SampleSummary_1","xdata","ydata","Bar chart");
        octoBarChart.setTrace("a","$change");
        octoBarChart.publish();

        spark.stop();
    }
}
