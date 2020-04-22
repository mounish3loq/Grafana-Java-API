package org.grafana.api.templates.Dashboard.GrafanaPanel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public  class LineGraphYAxis{
    @SerializedName("align")
    @Expose
    private boolean align;

    @SerializedName("alignLevel")
    @Expose
    private Integer alignLevel;

    public LineGraphYAxis(){
        this.align = false;
        this.alignLevel = null;
    }



}
