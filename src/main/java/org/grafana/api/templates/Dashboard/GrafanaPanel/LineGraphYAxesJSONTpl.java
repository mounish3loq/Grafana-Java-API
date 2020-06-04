package org.grafana.api.templates.Dashboard.GrafanaPanel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.logging.Logger;

public class LineGraphYAxesJSONTpl{
    static Logger log = Logger.getLogger(LineGraphYAxesJSONTpl.class.getName());

    @SerializedName("format")
    @Expose
    private String format;

    @SerializedName("label")
    @Expose
    private String label;

    @SerializedName("logBase")
    @Expose
    private int logBase;

    @SerializedName("max")
    @Expose
    private Integer max;

    @SerializedName("min")
    @Expose
    private Integer min;

    @SerializedName("show")
    @Expose
    private boolean show;

    public LineGraphYAxesJSONTpl() {
        this.format= "short";
        this.label= null;
        this.logBase =1;
        this.max = null;
        this.min= null;
        this.show = true;
        log.info("LineGraphYAxesJSON Done");
    }
}
