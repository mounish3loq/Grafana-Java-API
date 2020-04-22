package org.grafana.api.templates.Dashboard.PlotlyPanel.Pconfig.Traces;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TraceMappingTpl {
    @SerializedName("color")
    @Expose
    private Object color;

    @SerializedName("size")
    @Expose
    private Object size;

    @SerializedName("text")
    @Expose
    private Object text;

    @SerializedName("x")
    @Expose
    private String x;

    @SerializedName("y")
    @Expose
    private String y;

    @SerializedName("z")
    @Expose
    private String z;

    public TraceMappingTpl(){
        this.color = null;
        this.size = null;
        this.text = null;
        this.x = null;
        this.y = null;
        this.z = null;
    }

    public Object getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Object getSize() {
        return size;
    }

    public void setSize(Object size) {
        this.size = size;
    }

    public Object getText() {
        return text;
    }

    public void setText(Object text) {
        this.text = text;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getZ() {
        return z;
    }

    public void setZ(String z) {
        this.z = z;
    }
}
