package org.grafana.api.templates.Dashboard.GrafanaPanel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class StatChartFieldOptionsTpl {
    @SerializedName("values")
    @Expose
    private boolean  values;

    @SerializedName("calcs")
    @Expose
    private List calcs;

    @SerializedName("overrides")
    @Expose
    private List overrides;

    @SerializedName("defaults")
    @Expose
    private StatChartDefaultsTpl defaults;




    public StatChartFieldOptionsTpl(){
        this.defaults = new StatChartDefaultsTpl();
        this.calcs = new ArrayList(){};
        this.overrides = new ArrayList(){};
        this.values = false;


    }


}
