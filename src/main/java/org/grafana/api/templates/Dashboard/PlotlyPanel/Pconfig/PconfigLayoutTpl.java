package org.grafana.api.templates.Dashboard.PlotlyPanel.Pconfig;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.grafana.api.templates.Dashboard.PlotlyPanel.Pconfig.Layout.AxisTpl;
import org.grafana.api.templates.Dashboard.PlotlyPanel.Pconfig.Layout.FontTpl;
import org.grafana.api.templates.Dashboard.PlotlyPanel.Pconfig.Layout.PlotlyLegendTpl;

public class PconfigLayoutTpl {
    @SerializedName("dragmode")
    @Expose
    private String dragmode;
    @SerializedName("font")
    @Expose
    private FontTpl font;
    @SerializedName("hovermode")
    @Expose
    private String hovermode;
    @SerializedName("legend")
    @Expose
    private PlotlyLegendTpl legend;
    @SerializedName("showlegend")
    @Expose
    private boolean showlegend;
    @SerializedName("xaxis")
    @Expose
    private AxisTpl xaxis;
    @SerializedName("yaxis")
    @Expose
    private AxisTpl yaxis;
    @SerializedName("zaxis")
    @Expose
    private AxisTpl zaxis;

    public PconfigLayoutTpl(){
        this.dragmode = "lasso";
        this.font = new FontTpl();
        this.hovermode = "closest";
        this.legend = new PlotlyLegendTpl();
        this.showlegend = false;
        this.xaxis = new AxisTpl();
        this.yaxis = new AxisTpl();
        this.zaxis = new AxisTpl();
    }

    public String getDragmode() {
        return dragmode;
    }

    public void setDragmode(String dragmode) {
        this.dragmode = dragmode;
    }

    public FontTpl getFont() {
        return font;
    }

    public void setFont(FontTpl font) {
        this.font = font;
    }

    public String getHovermode() {
        return hovermode;
    }

    public void setHovermode(String hovermode) {
        this.hovermode = hovermode;
    }

    public PlotlyLegendTpl getLegend() {
        return legend;
    }

    public void setLegend(PlotlyLegendTpl legend) {
        this.legend = legend;
    }

    public boolean isShowlegend() {
        return showlegend;
    }

    public void setShowlegend(boolean showlegend) {
        this.showlegend = showlegend;
    }

    public AxisTpl getXaxis() {
        return xaxis;
    }

    public void setXaxis(AxisTpl xaxis) {
        this.xaxis = xaxis;
    }

    public AxisTpl getYaxis() {
        return yaxis;
    }

    public void setYaxis(AxisTpl yaxis) {
        this.yaxis = yaxis;
    }

    public AxisTpl getZaxis() {
        return zaxis;
    }

    public void setZaxis(AxisTpl zaxis) {
        this.zaxis = zaxis;
    }
}
