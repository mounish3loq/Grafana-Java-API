package org.grafana.api.templates.Dashboard.PlotlyPanel.Pconfig;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.grafana.api.templates.Dashboard.PlotlyPanel.Pconfig.Traces.TraceMappingTpl;
import org.grafana.api.templates.Dashboard.PlotlyPanel.Pconfig.Traces.TraceSettingsTpl;
import org.grafana.api.templates.Dashboard.PlotlyPanel.Pconfig.Traces.TraceShowTpl;

public class TracesTpl {
    @SerializedName("mapping")
    @Expose
    private TraceMappingTpl mapping;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("settings")
    @Expose
    private TraceSettingsTpl settings;

    @SerializedName("show")
    @Expose
    private TraceShowTpl show;

    public TracesTpl(){
        this.mapping = null;
        this.name = "Trace 1";
        this.settings = new TraceSettingsTpl();
        this.show = new TraceShowTpl();
    }

    public TraceMappingTpl getMapping() {
        return mapping;
    }

    public void setMapping(TraceMappingTpl mapping) {
        this.mapping = mapping;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TraceSettingsTpl getSettings() {
        return settings;
    }

    public void setSettings(TraceSettingsTpl settings) {
        this.settings = settings;
    }

    public TraceShowTpl getShow() {
        return show;
    }

    public void setShow(TraceShowTpl show) {
        this.show = show;
    }
}
