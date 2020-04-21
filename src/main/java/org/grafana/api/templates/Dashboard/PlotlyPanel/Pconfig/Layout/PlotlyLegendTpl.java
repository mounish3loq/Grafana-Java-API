package org.grafana.api.templates.Dashboard.PlotlyPanel.Pconfig.Layout;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlotlyLegendTpl {
    @SerializedName("orientation")
    @Expose
    private String orientation;

    public PlotlyLegendTpl(){
        this.orientation = "h";
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }
}
