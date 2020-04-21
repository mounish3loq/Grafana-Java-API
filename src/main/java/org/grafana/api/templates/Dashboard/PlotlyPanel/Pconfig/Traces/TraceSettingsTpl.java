package org.grafana.api.templates.Dashboard.PlotlyPanel.Pconfig.Traces;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.grafana.api.templates.Dashboard.PlotlyPanel.Pconfig.Traces.Settings.TraceSettingsLineTpl;
import org.grafana.api.templates.Dashboard.PlotlyPanel.Pconfig.Traces.Settings.TraceSettingsMarkerTpl;

public class TraceSettingsTpl {

    @SerializedName("color_option")
    @Expose
    private String color_option;

    @SerializedName("line")
    @Expose
    private TraceSettingsLineTpl line;

    @SerializedName("marker")
    @Expose
    private TraceSettingsMarkerTpl marker;

    public TraceSettingsTpl(){
        this.color_option = "ramp";
        this.line = new TraceSettingsLineTpl();
        this.marker = null;
    }

    public String getColor_option() {
        return color_option;
    }

    public void setColor_option(String color_option) {
        this.color_option = color_option;
    }

    public TraceSettingsLineTpl getLine() {
        return line;
    }

    public void setLine(TraceSettingsLineTpl line) {
        this.line = line;
    }

    public TraceSettingsMarkerTpl getMarker() {
        return marker;
    }

    public void setMarker(TraceSettingsMarkerTpl marker) {
        this.marker = marker;
    }
}
