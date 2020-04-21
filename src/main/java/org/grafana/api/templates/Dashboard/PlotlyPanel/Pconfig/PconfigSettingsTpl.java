package org.grafana.api.templates.Dashboard.PlotlyPanel.Pconfig;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PconfigSettingsTpl {
    @SerializedName("displayModeBar")
    @Expose
    private Boolean displayModeBar;
    @SerializedName("type")
    @Expose
    private String type;

    public PconfigSettingsTpl(){
        this.displayModeBar = false;
        this.type = "bar";
    }
    public Boolean getDisplayModeBar() {
        return displayModeBar;
    }

    public void setDisplayModeBar(Boolean displayModeBar) {
        this.displayModeBar = displayModeBar;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
