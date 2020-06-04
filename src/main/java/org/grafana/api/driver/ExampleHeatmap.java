package org.grafana.api.driver;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.grafana.api.octocharts.*;

public class ExampleHeatmap {
    public static void main(String[] args){
        SparkSession spark = SparkSession
                .builder()
                .master("local")
                .appName("Java Spark SQL basic example 2")
                .config("spark.some.config.option", "some-value2")
                .getOrCreate();
        /* data in sample1.csv
        employees,jan,feb,mar
        emp1,100,150,200
        emp2,200,130,20
        emp3,300,500,320
         */
        Dataset<Row> df1 = spark.read().format("csv").option("header","true").load("D:/Engineering/work_folders/heatmap_data/sample1.csv");
        df1.show();

        OctoHeatmapChart2 octoHeatmapChart = new OctoHeatmapChart2(spark,"ABCDE",df1,"abcd.sampleworkunit", "Heatworkunit","HeatSummary","xdata","ydata","Heatmap chart");
        octoHeatmapChart.setXaxis("employees");
        octoHeatmapChart.setYaxis("jan,feb,mar");
        octoHeatmapChart.publish();

        spark.stop();

    }
}
