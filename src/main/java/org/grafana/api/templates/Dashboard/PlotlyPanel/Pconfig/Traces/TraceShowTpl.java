package org.grafana.api.templates.Dashboard.PlotlyPanel.Pconfig.Traces;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TraceShowTpl {
    @SerializedName("line")
    @Expose
    private boolean line;
    @SerializedName("markers")
    @Expose
    private boolean markers;

    public TraceShowTpl(){
        this.line = true;
        this.markers = false;
    }
    public boolean isLine() {
        return line;
    }

    public void setLine(boolean line) {
        this.line = line;
    }

    public boolean isMarkers() {
        return markers;
    }

    public void setMarkers(boolean markers) {
        this.markers = markers;
    }
}
