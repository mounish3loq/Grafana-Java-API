package org.grafana.api.templates.Dashboard.GrafanaPanel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.logging.Logger;

public class GrafanaLegendTpl{
    static Logger log = Logger.getLogger(GrafanaLegendTpl.class.getName());
    @SerializedName("percentage")
    @Expose
    private boolean percentage;

    @SerializedName("show")
    @Expose
    private boolean show;

    @SerializedName("values")
    @Expose
    private boolean values;

    public GrafanaLegendTpl(){
        this.percentage = true;
        this.show = true;
        this.values = true;
        log.info("Grafana Legend Template");
    }

    public boolean isPercentage() {
        return percentage;
    }

    public void setPercentage(boolean percentage) {
        this.percentage = percentage;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public boolean isValues() {
        return values;
    }

    public void setValues(boolean values) {
        this.values = values;
    }




}
