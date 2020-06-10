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
        /* data in sample1.csv  |  jan,feb,mar as x-axis & employees col as y-axis
        employees,jan,feb,mar   |   emp3 |  7  |  8  |  9  |
        emp1,       1, 2, 3     |   emp2 |  4  |  5  |  6  |
        emp2,       4, 5, 6     |   emp1 |__1__|__2__|__3__|
        emp3,       7, 8, 9     |           jan     feb     mar
         */
        Dataset<Row> df1 = spark.read().format("csv").option("header","true").load("D:/Engineering/work_folders/heatmap_data/sample1.csv");
        df1.orderBy("employees");
        OctoHeatmapChart octoHeatmapChart = new OctoHeatmapChart(spark,"ABCDEE",df1,"abcd.sampleworkunit_2", "Heatworkunit","HeatSummary","xdata","ydata","Heatmap chart");
        octoHeatmapChart.setXaxis("jan,feb,mar"); //Always a string containing either (one column header) or  (List of column headers)
        octoHeatmapChart.setYaxis("employees"); // Always a String containing Column header of an ordered column

        /* Don't set like this .It will produce chart with wrong data.
        octoHeatmapChart.setXaxis("employees");
        octoHeatmapChart.setYaxis("jan,feb,mar");
        Because the dataframe needs to be transposed to be displayed correctly.

        Correct chart is this

        |   mar |  3    |  6    |    9   |
        |   feb |  2    |  5    |    8   |
        |   jan |__1____|__4____|____7___|
        |           emp1     emp2    emp3

        But however the chart will be displayed incorrectly.

        |   mar |  7    |  8    |  9   |
        |   feb |  4    |  5    |  6   |
        |   jan |__1  __|__2  __|__3 __|
        |           emp1     emp2    emp3

        Because this transpose needs to happen

        emp1,emp2,emp3
        1, 	  4,   7
        2, 	  5,   8
        3,    6,   9
         */
        octoHeatmapChart.publish();

        spark.stop();

    }
}
