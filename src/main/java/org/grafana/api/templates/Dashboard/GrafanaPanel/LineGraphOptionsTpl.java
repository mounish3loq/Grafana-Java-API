package org.grafana.api.templates.Dashboard.GrafanaPanel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LineGraphOptionsTpl{
    @SerializedName("datalinks")
    @Expose
    private String[] datalinks;

    public LineGraphOptionsTpl(){
        this.datalinks = new String[]{};
    }
}
