package org.grafana.api.templates.Dashboard.GrafanaPanel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.logging.Logger;

public  class LineGraphYAxis{
    static Logger log = Logger.getLogger(LineGraphYAxis.class.getName());

    @SerializedName("align")
    @Expose
    private boolean align;

    @SerializedName("alignLevel")
    @Expose
    private Integer alignLevel;

    public LineGraphYAxis(){
        this.align = false;
        this.alignLevel = null;
        log.info("LineGraph Y axis Done");
    }



}
