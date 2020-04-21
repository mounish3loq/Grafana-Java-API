package org.grafana.api.templates.Dashboard.PlotlyPanel.Pconfig.Traces.Settings;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TraceSettingsLineTpl {
    @SerializedName("color")
    @Expose
    private String color;

    @SerializedName("dash")
    @Expose
    private String dash;

    @SerializedName("shape")
    @Expose
    private String shape;

    @SerializedName("width")
    @Expose
    private Integer width;

    public TraceSettingsLineTpl(){
        this.color = "#005f81";
        this.dash = "solid";
        this.shape = "linear";
        this.width = 6;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDash() {
        return dash;
    }

    public void setDash(String dash) {
        this.dash = dash;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }
}
