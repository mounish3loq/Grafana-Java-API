package org.grafana.api.driver;

import ca.krasnay.sqlbuilder.SelectBuilder;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.grafana.api.octocharts.OctoBarChart;
import org.grafana.api.octocharts.OctoHeatmapChart;

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
        connectionProperties.put("user", "postgres");
        connectionProperties.put("password", "12345");
        Dataset<Row> df =spark.read()
                .jdbc("jdbc:postgresql://localhost:5432/SampleDatabase", "table1", connectionProperties);
        OctoBarChart octoBarChart = new OctoBarChart(spark,"ABCDE",df,"Sampleworkunit","SampleSummary","xdata","ydata","Bar chart");
        octoBarChart.setTrace("a","b");
        octoBarChart.publish();
        spark.stop();
    }
}
