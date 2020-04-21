package org.grafana.api.templates.Dashboard.PlotlyPanel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.grafana.api.templates.Dashboard.PlotlyPanel.Pconfig.PconfigLayoutTpl;
import org.grafana.api.templates.Dashboard.PlotlyPanel.Pconfig.PconfigSettingsTpl;
import org.grafana.api.templates.Dashboard.PlotlyPanel.Pconfig.TracesTpl;

import java.util.ArrayList;
import java.util.List;

public class PlotlyPconfigTpl {
    @SerializedName("fixScale")
    @Expose
    private String fixScale;
    @SerializedName("layout")
    @Expose
    private PconfigLayoutTpl layout;
    @SerializedName("loadFromCDN")
    @Expose
    private Boolean loadFromCDN;
    @SerializedName("settings")
    @Expose
    private PconfigSettingsTpl settings;
    @SerializedName("showAnnotations")
    @Expose
    private Boolean showAnnotations;
    @SerializedName("traces")
    @Expose
    private List<TracesTpl> traces = new ArrayList<>();

    public PlotlyPconfigTpl(){
        this.fixScale = "";
        this.layout = new PconfigLayoutTpl();
        this.loadFromCDN = false;
        this.settings = new PconfigSettingsTpl();
        this.showAnnotations = true;

    }

    public String getFixScale() {
        return fixScale;
    }

    public void setFixScale(String fixScale) {
        this.fixScale = fixScale;
    }

    public PconfigLayoutTpl getLayout() {
        return layout;
    }

    public void setLayout(PconfigLayoutTpl layout) {
        this.layout = layout;
    }

    public Boolean getLoadFromCDN() {
        return loadFromCDN;
    }

    public void setLoadFromCDN(Boolean loadFromCDN) {
        this.loadFromCDN = loadFromCDN;
    }

    public PconfigSettingsTpl getSettings() {
        return settings;
    }

    public void setSettings(PconfigSettingsTpl settings) {
        this.settings = settings;
    }

    public Boolean getShowAnnotations() {
        return showAnnotations;
    }

    public void setShowAnnotations(Boolean showAnnotations) {
        this.showAnnotations = showAnnotations;
    }

    public List<TracesTpl> getTraces() {
        return traces;
    }

    public void setTraces(List<TracesTpl> traces) {
        this.traces = traces;
    }
}
