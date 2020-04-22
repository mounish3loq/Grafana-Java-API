package org.grafana.api.templates.Dashboard.GrafanaPanel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public  class LineGraphLegendTpl{

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
        this.show= false;
        this.total = false;
        this.values = false;
    }


}
