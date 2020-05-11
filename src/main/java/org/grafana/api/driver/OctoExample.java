package org.grafana.api.driver;

import ca.krasnay.sqlbuilder.SelectBuilder;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.grafana.api.RequestBuilder;
import org.grafana.api.octocharts.OctoBarChart;
import org.grafana.api.octocharts.OctoHeatmapChart;
import org.grafana.api.octocharts.OctoLineChart;
import org.grafana.api.octocharts.OctoTableChart;

import java.util.Properties;

public class OctoExample {
    public static void main(String[] args){
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
                .jdbc("jdbc:postgresql://"+System.getenv("GRAFANA_POSTGRES_URL")+"/"+System.getenv("GRAFANA_POSTGRES_DB"), "table1", connectionProperties);
        Dataset<Row> df2 =spark.read()
                .jdbc("jdbc:postgresql://"+System.getenv("GRAFANA_POSTGRES_URL")+"/"+System.getenv("GRAFANA_POSTGRES_DB"), "mytable", connectionProperties);

        Dataset<Row> df3 =spark.read()
                .jdbc("jdbc:postgresql://"+System.getenv("GRAFANA_POSTGRES_URL")+"/"+System.getenv("GRAFANA_POSTGRES_DB"), "sample_heatmap_table", connectionProperties);

        OctoLineChart octoLineChart = new OctoLineChart(spark,"ABCDE",df2,"Lineworkunit","LineSummary","Line chart");
        octoLineChart.setTimeColumn("year_month");
        octoLineChart.setColumns("varejo AS \"Varejo\",vestuario AS \"Vestuario\",\"serviÇo\" AS \"Serviço\",supermercados AS \"Supermercados\",restaurante AS \"Restaurante\", \"posto_de_gas\" AS \"Posto De Gas\"");
        octoLineChart.publish();

        OctoBarChart octoBarChart = new OctoBarChart(spark,"ABCDE",df,"Sampleworkunit","SampleSummary","xdata","ydata","Bar chart");
        octoBarChart.setTrace("a","b");
        octoBarChart.publish();

        OctoHeatmapChart octoHeatmapChart = new OctoHeatmapChart(spark,"ABCDE",df3,"Heatworkunit","HeatSummary","xdata","ydata","Heatmap chart");
        octoHeatmapChart.setTrace("category","category","i0");
        octoHeatmapChart.setTarget("category");
        octoHeatmapChart.setTarget("i0,i1,i2,i3,i4");
        octoHeatmapChart.publish();

        OctoTableChart octoTableChart = new OctoTableChart(spark,"ABCDE",df3,"Tableworkunit","TableSummary","Table chart");
        octoTableChart.setColumns("category,i0");
        octoTableChart.publish();

        spark.stop();

    }
}
