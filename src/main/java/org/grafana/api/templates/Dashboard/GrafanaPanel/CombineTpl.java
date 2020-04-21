package org.grafana.api.templates.Dashboard.GrafanaPanel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CombineTpl{
    @SerializedName("label")
    @Expose
    private String label;

    @SerializedName("threshold")
    @Expose
    private Integer threshold;

    public CombineTpl(){
        this.label = "others";
        this.threshold = 0;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }
}
