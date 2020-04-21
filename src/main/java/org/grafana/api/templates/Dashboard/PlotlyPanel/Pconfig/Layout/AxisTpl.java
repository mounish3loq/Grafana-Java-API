package org.grafana.api.templates.Dashboard.PlotlyPanel.Pconfig.Layout;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AxisTpl {
    @SerializedName("rangemode")
    @Expose
    private String rangemode;
    @SerializedName("showgrid")
    @Expose
    private boolean showgrid;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("zeroline")
    @Expose
    private boolean zeroline;
    @SerializedName("title")
    @Expose
    private String title;

    public AxisTpl(){
        this.rangemode = "normal";
        this.showgrid = true;
        this.type = "auto";
        this.zeroline = false;
    }

    public String getRangemode() {
        return rangemode;
    }

    public void setRangemode(String rangemode) {
        this.rangemode = rangemode;
    }

    public boolean isShowgrid() {
        return showgrid;
    }

    public void setShowgrid(boolean showgrid) {
        this.showgrid = showgrid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isZeroline() {
        return zeroline;
    }

    public void setZeroline(boolean zeroline) {
        this.zeroline = zeroline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
