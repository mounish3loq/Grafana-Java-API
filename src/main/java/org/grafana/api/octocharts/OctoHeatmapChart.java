package org.grafana.api.octocharts;

import org.apache.spark.sql.*;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import org.grafana.api.templates.Charts.PlotlyHeatmapPanelChart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OctoHeatmapChart extends OctoBaseChart{
    static Logger log = Logger.getLogger("myLogger");
    private final SparkSession sparkWorker;
    private final String uid;
    private final Dataset<Row> df_main;
    private String dashboardtitle;
    private final String tableNameLarge;
    private final String tableNameShort;
    private final String workunitClass;
    private final String workunitName;
    private final String summaryName;
    public PlotlyHeatmapPanelChart heatmapPanel;
    public String xmapping;
    public String ymapping;
    public String zmapping;

    public OctoHeatmapChart(SparkSession spark, String dashboarduid, Dataset<Row> df, String workunitClass, String workunitName, String summaryname, String xtitle, String ytitle, String paneltitle){
        this.sparkWorker = spark;
        this.uid = dashboarduid;
        this.df_main = df;
        this.dashboardtitle = null;
        this.heatmapPanel = new PlotlyHeatmapPanelChart();
        this.heatmapPanel.setDatasource(System.getenv("GRAFANA_POSTGRES_DATASOURCE"));
        this.heatmapPanel.setPconfig(xtitle,ytitle);
        this.heatmapPanel.setTitle(paneltitle);
        this.workunitClass = workunitClass;
        this.workunitName = workunitName;
        this.summaryName = summaryname;
        this.tableNameLarge=(workunitClass.substring(workunitClass.lastIndexOf('.') + 1) +"_"+ summaryname + "_1").toLowerCase();
        this.tableNameShort=(workunitClass.substring(workunitClass.lastIndexOf('.') + 1) +"_"+ summaryname + "_2").toLowerCase();
        super.updateChartData(this.sparkWorker,df,this.uid,this.workunitClass,this.workunitName,this.summaryName,this.tableNameLarge);
    }

    public void setXaxis(String columnNames){
        List<String> arr = Arrays.asList(columnNames.split(","));
        List<String> arr2 = new ArrayList<>();
        for (String s : arr){
            arr2.add("\"" + s +"\"");
        }
        String xaxis_cols = String.join(",",arr2);

        if (arr.size() > 1){
            this.zmapping = columnNames;
            this.xmapping = "xlabel";
            this.heatmapPanel.setTargets(String.format("select %s from %s where dashboardid = \'%s\' and workunitname = \'%s\'",this.xmapping,this.tableNameShort,this.uid, this.workunitName));
            convertToDataFrameAndPersist(arr,this.xmapping);
        }
        else{
            List<String> list_x_axis = this.df_main.select(columnNames).as(Encoders.STRING()).collectAsList();
            this.zmapping = String.join(",",list_x_axis);
            this.heatmapPanel.setTargets(String.format("select %s from %s where dashboardid = \'%s\' and workunitname = \'%s\'",this.zmapping,this.tableNameLarge,this.uid, this.workunitName));
            this.xmapping = columnNames;
        }
        this.heatmapPanel.setTargets(String.format("select %s from %s where dashboardid = \'%s\' and workunitname = \'%s\'", xaxis_cols,this.tableNameLarge,this.uid, this.workunitName));
        //if xcolumn names are >1 then x is also z.
        //store into table.
    }
    public void setYaxis(String columnNames){
        List<String> arr = Arrays.asList(columnNames.split(","));
        if (arr.size() > 1){
            this.zmapping = columnNames;
            this.ymapping = "ylabel";
            this.heatmapPanel.setTargets(String.format("select %s from %s where dashboardid = \'%s\' and workunitname = \'%s\'",this.ymapping,this.tableNameShort,this.uid, this.workunitName));
            convertToDataFrameAndPersist(arr,this.ymapping);
        }
        else{
            this.ymapping = columnNames;
        }
        this.heatmapPanel.setTargets(String.format("select %s from %s where dashboardid = \'%s\' and workunitname = \'%s\'",columnNames,this.tableNameLarge,this.uid, this.workunitName));
        //if ycolumn names are > 1 then y axis is also z
        //store into table.
    }
    public void convertToDataFrameAndPersist(List<String> arr,String colHeader){
        List<Row> list=new ArrayList<>();
        for(String x:arr){
            list.add(RowFactory.create(x));
        }
        List<StructField> listOfStructField=new ArrayList<>();
        listOfStructField.add(DataTypes.createStructField(colHeader, DataTypes.StringType, true));
        StructType structType=DataTypes.createStructType(listOfStructField);
        Dataset<Row> df_x = sparkWorker.createDataFrame(list,structType);
        df_x.show();
        super.updateChartData(this.sparkWorker,df_x,this.uid,this.workunitClass,this.workunitName,this.summaryName,this.tableNameShort);
    }
    public void setDashboardtitle(String dashboardtitle){
        this.dashboardtitle = dashboardtitle;
    }

    public void publish(){
        try {
            String s = String.format("SetTrace X Mappings %s Y Mappings %s Z Mappings %s",this.xmapping,this.ymapping,this.zmapping);
            log.info(s);
            this.heatmapPanel.setTraces(this.xmapping,this.ymapping,this.zmapping.split(",")[0]);
            super.publish(this.uid,this.dashboardtitle,this.heatmapPanel,this.workunitClass);
        }catch (Exception e){
            log.log(Level.SEVERE,"HeatMap Publish Exception "+e.toString());
        }
    }

}
