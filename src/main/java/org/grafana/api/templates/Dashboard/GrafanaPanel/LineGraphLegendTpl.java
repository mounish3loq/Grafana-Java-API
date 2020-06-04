package org.grafana.api.templates.Dashboard.GrafanaPanel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.logging.Logger;

public  class LineGraphLegendTpl{
    static Logger log = Logger.getLogger(LineGraphLegendTpl.class.getName());

    @SerializedName("avg")
    @Expose
    private boolean avg;

    @SerializedName("current")
    @Expose
    private boolean current;

    @SerializedName("max")
    @Expose
    private boolean max;

    @SerializedName("min")
    @Expose
    private boolean min;

    @SerializedName("show")
    @Expose
    private boolean show;

    @SerializedName("total")
    @Expose
    private boolean total;

    @SerializedName("values")
    @Expose
    private boolean values;

    public LineGraphLegendTpl(){
        this.avg = false;
        this.current= false;
        this.max =false;
        this.min= false;
        this.show= true;
        this.total = false;
        this.values = false;
        log.info("Line Graph Panel");
    }

    public boolean isAvg() {
        return avg;
    }

    public void setAvg(boolean avg) {
        this.avg = avg;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public boolean isMax() {
        return max;
    }

    public void setMax(boolean max) {
        this.max = max;
    }

    public boolean isMin() {
        return min;
    }

    public void setMin(boolean min) {
        this.min = min;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public boolean isTotal() {
        return total;
    }

    public void setTotal(boolean total) {
        this.total = total;
    }

    public boolean isValues() {
        return values;
    }

    public void setValues(boolean values) {
        this.values = values;
    }
}
