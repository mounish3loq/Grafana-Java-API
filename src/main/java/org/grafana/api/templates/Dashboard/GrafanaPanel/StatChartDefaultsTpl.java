package org.grafana.api.templates.Dashboard.GrafanaPanel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class StatChartDefaultsTpl {
    @SerializedName("thresholds")
    @Expose
    private StatChartThresholdTpl  thresholds;

    @SerializedName("mappings")
    @Expose
    private List mappings;

    public StatChartDefaultsTpl(){
        this.thresholds = new StatChartThresholdTpl();
        this.mappings = new ArrayList(){};
    }
}
