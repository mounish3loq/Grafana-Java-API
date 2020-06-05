package org.grafana.api.driver;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.grafana.api.octocharts.*;

import java.util.Arrays;
import java.util.List;

public class ExampleHeatmap {
    public static void main(String[] args){
        SparkSession spark = SparkSession
                .builder()
                .master("local")
                .appName("Java Spark SQL basic example 2")
                .config("spark.some.config.option", "some-value2")
                .getOrCreate();
        /* data in sample1.csv  |  jan,feb,mar as x-axis & employees col as y-axis
        employees,jan,feb,mar   |   emp3 |  300  |  500  |  320  |
        emp1,100,150,200        |   emp2 |  200  |  130  |  20   |
        emp2,200,130,20         |   emp1 |__100__|__150__|__200__|
        emp3,300,500,320        |           jan     feb     mar
         */
        Dataset<Row> df1 = spark.read().format("csv").option("header","true").load("D:/Engineering/work_folders/heatmap_data/sample1.csv");

        OctoHeatmapChart octoHeatmapChart = new OctoHeatmapChart(spark,"ABCDE",df1,"abcd.sampleworkunit", "Heatworkunit","HeatSummary","xdata","ydata","Heatmap chart");
        octoHeatmapChart.setXaxis("jan,feb,mar"); //List of column headers
        octoHeatmapChart.setYaxis("employees"); // Column header of an ordered column
        octoHeatmapChart.publish();

        spark.stop();

    }
}
