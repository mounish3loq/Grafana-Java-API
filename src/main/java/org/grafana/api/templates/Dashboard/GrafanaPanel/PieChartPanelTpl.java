package org.grafana.api.templates.Dashboard.GrafanaPanel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.grafana.api.templates.Dashboard.PlotlyPanel.PlotlyPanelTpl;
import org.grafana.api.templates.Dashboard.PlotlyPanel.PlotlyTargetsTpl;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class PieChartPanelTpl extends PlotlyPanelTpl {
    @SerializedName("pieType")
    @Expose
    private String pieType;
    @SerializedName("legend")
    @Expose
    private GrafanaLegendTpl legend;
    @SerializedName("maxDataPoints")
    @Expose
    private int maxDataPoints;
    @SerializedName("interval")
    @Expose
    private String interval;
    @SerializedName("cacheTimeout")
    @Expose
    private String cacheTimeout;
    @SerializedName("nullPointMode")
    @Expose
    private String nullPointMode;
    @SerializedName("legendType")
    @Expose
    private String legendType;
    @SerializedName("breakPoint")
    @Expose
    private String breakPoint;
    @SerializedName("format")
    @Expose
    private String format;
    @SerializedName("valueName")
    @Expose
    private String valueName;
    @SerializedName("strokeWidth")
    @Expose
    private String strokeWidth;
    @SerializedName("fontSize")
    @Expose
    private String fontSize;
    @SerializedName("links")
    @Expose
    private List<Object> links; //this.links = [];
    @SerializedName("options")
    @Expose
    private String options;
    @SerializedName("pluginVersion")
    @Expose
    private String pluginVersion;
    @SerializedName("combine")
    @Expose
    private CombineTpl combine;

    private ArrayList<PlotlyTargetsTpl> listofTargets;
    public PieChartPanelTpl(){
        this.listofTargets = new ArrayList<>();
        this.setType("grafana-piechart-panel");
        this.combine = new CombineTpl();
        this.legend = new GrafanaLegendTpl();
        this.breakPoint  = "50%";
        this.cacheTimeout  = null;
        this.fontSize ="100%"  ;
        this.format = "short";
        this.interval = null;
        this.legendType ="On graph";
        this.links =null;
        this.maxDataPoints= 3;
        this.nullPointMode  = "connected";
        this.options =null;
        this.pieType = "pie";
        this.pluginVersion ="6.6.2";
        this.strokeWidth = "0";
        this.valueName = "current";
    }

    public void setTargets(String query,String format){

        //Creating a target object which takes in an sql query
        PlotlyTargetsTpl targetsTpl = new PlotlyTargetsTpl(query);
        targetsTpl.setFormat(format);
        this.listofTargets.add(targetsTpl);
        this.setTargets(listofTargets);
    }

    public String getPieType() {
        return pieType;
    }

    public void setPieType(String pieType) {
        if ((pieType.equals("pie")) || (pieType.equals("donut"))){
            this.pieType = pieType;
        }else{
            throw new InputMismatchException(pieType);
        }
    }

    public GrafanaLegendTpl getLegend() {
        return legend;
    }

    public void setLegend(GrafanaLegendTpl legend) {
        this.legend = legend;
    }

    public int getMaxDataPoints() {
        return maxDataPoints;
    }

    public void setMaxDataPoints(int maxDataPoints) {
        this.maxDataPoints = maxDataPoints;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getCacheTimeout() {
        return cacheTimeout;
    }

    public void setCacheTimeout(String cacheTimeout) {
        this.cacheTimeout = cacheTimeout;
    }

    public String getNullPointMode() {
        return nullPointMode;
    }

    public void setNullPointMode(String nullPointMode) {
        this.nullPointMode = nullPointMode;
    }

    public String getLegendType() {
        return legendType;
    }

    public void setLegendType(String legendType) {
        this.legendType = legendType;
    }

    public String getBreakPoint() {
        return breakPoint;
    }

    public void setBreakPoint(String breakPoint) {
        this.breakPoint = breakPoint;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public String getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(String strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public String getFontSize() {
        return fontSize;
    }

    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }

    public List<Object> getLinks() {
        return links;
    }

    public void setLinks(List<Object> links) {
        this.links = links;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getPluginVersion() {
        return pluginVersion;
    }

    public void setPluginVersion(String pluginVersion) {
        this.pluginVersion = pluginVersion;
    }

    public CombineTpl getCombine() {
        return combine;
    }

    public void setCombine(CombineTpl combine) {
        this.combine = combine;
    }
}