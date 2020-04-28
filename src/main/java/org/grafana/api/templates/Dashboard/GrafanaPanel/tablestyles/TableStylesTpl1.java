package org.grafana.api.templates.Dashboard.GrafanaPanel.tablestyles;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TableStylesTpl1 {
    @SerializedName("alias")
    @Expose
    private String alias;

    @SerializedName("align")
    @Expose
    private String align;

    @SerializedName("dateFormat")
    @Expose
    private String dateFormat;

    @SerializedName("pattern")
    @Expose
    private String pattern;

    @SerializedName("type")
    @Expose
    private String type;

    public TableStylesTpl1(){
        this.alias = "Time";
        this.align = "auto";
        this.dateFormat = "YYYY-MM-DD HH:mm:ss";
        this.pattern = "Time";
        this.type = "date";
    }

}
