package org.grafana.api.templates.Dashboard.PlotlyPanel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlotlyGridPosTpl {
    @SerializedName("h")
    @Expose
    private Integer h;
    @SerializedName("w")
    @Expose
    private Integer w;
    @SerializedName("x")
    @Expose
    private Integer x;
    @SerializedName("y")
    @Expose
    private Integer y;

    public PlotlyGridPosTpl(){
        this.h = 9;
        this.w = 12;
        this.x = 0;
        this.y = 0;
    }

    public Integer getH() {
        return h;
    }

    public void setH(Integer h) {
        this.h = h;
    }

    public Integer getW() {
        return w;
    }

    public void setW(Integer w) {
        this.w = w;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}
