package org.grafana.api.templates.Dashboard.GrafanaPanel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LineGraphXAxis{
    @SerializedName("buckets")
    @Expose
    private Integer buckets;

    @SerializedName("mode")
    @Expose
    private String mode;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("show")
    @Expose
    private boolean show;

    @SerializedName("values")
    @Expose
    private String[] values;

    public LineGraphXAxis(){
        this.buckets = null;
        this.mode = "time";
        this.name = null;
        this.show = true;
        this.values= new String[]{};

    }
}
