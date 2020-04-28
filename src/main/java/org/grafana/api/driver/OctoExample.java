package org.grafana.api.driver;

import ca.krasnay.sqlbuilder.SelectBuilder;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.grafana.api.RequestBuilder;
import org.grafana.api.octocharts.OctoBarChart;
import org.grafana.api.octocharts.OctoHeatmapChart;
import org.grafana.api.octocharts.OctoLineChart;

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
        Dataset<Row> df2 =spark.read()
                .jdbc("jdbc:postgresql://localhost:5432/SampleDatabase", "mytable", connectionProperties);

//        OctoBarChart octoBarChart = new OctoBarChart(spark,"ABCDE",df,"Sampleworkunit","SampleSummary","xdata","ydata","Bar chart");
        //octoBarChart.setTrace("a","b");
        //octoBarChart.publish();

        OctoLineChart octoLineChart = new OctoLineChart(spark,"ABCDE",df2,"Lineworkunit","LineSummary","Line chart");
        octoLineChart.setColumns("varejo AS \"Varejo\",vestuario AS \"Vestuario\",\"serviÇo\" AS \"Serviço\",supermercados AS \"Supermercados\",restaurante AS \"Restaurante\", \"posto_de_gas\" AS \"Posto De Gas\"");
        octoLineChart.setTimeColumn("year_month");
        octoLineChart.publish();
        spark.stop();

    }
}
