package org.grafana.api.templates.Dashboard.GrafanaPanel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StatChartOptionsTpl {
    @SerializedName("graphMode")
    @Expose
    private String  graphMode;

    @SerializedName("colorMode")
    @Expose
    private String  colorMode;

    @SerializedName("justifyMode")
    @Expose
    private String  justifyMode;


    @SerializedName("fieldOptions")
    @Expose
    private StatChartFieldOptionsTpl  fieldOptions;

    @SerializedName("orientation")
    @Expose
    private String orientation;


    public StatChartOptionsTpl(){
        this.graphMode = "area";
        this.colorMode = "value";
        this.justifyMode = "auto";

        this.fieldOptions = new StatChartFieldOptionsTpl();
        this.orientation = "auto";

    }
}