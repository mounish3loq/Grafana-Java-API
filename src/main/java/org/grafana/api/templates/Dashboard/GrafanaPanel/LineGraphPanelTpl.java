package org.grafana.api.templates.Dashboard.GrafanaPanel;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class LineGraphPanelTpl extends GrafanaBasePanelTpl {

    @SerializedName("targets")
    @Expose
    private List<LineGraphTargetsTpl> targets = new ArrayList<>();

    public List<LineGraphTargetsTpl> getTargets() {
        return targets;
    }

    public void setTargets(List<LineGraphTargetsTpl> targets) {
        this.targets = targets;
    }

    public void setTargets(String query,String table,String format){
        //Creating a target object which takes in an sql query
        LineGraphTargetsTpl targetsTpl = new LineGraphTargetsTpl(query,table,format);
        List<LineGraphTargetsTpl> listofTargets= this.getTargets();
        listofTargets.add(targetsTpl);
        this.setTargets(listofTargets);
    }


    public String getAliasColors() {
        return aliasColors;
    }

    public void setAliasColors(String  aliasColors) {
        this.aliasColors = aliasColors;
    }

    public boolean isBars() {
        return bars;
    }

    public void setBars(boolean bars) {
        this.bars = bars;
    }

    public Integer getDashLength() {
        return dashLength;
    }

    public void setDashLength(Integer dashLength) {
        this.dashLength = dashLength;
    }

    public boolean isDashes() {
        return dashes;
    }

    public void setDashes(boolean dashes) {
        this.dashes = dashes;
    }

    public Integer getFill() {
        return fill;
    }

    public void setFill(Integer fill) {
        this.fill = fill;
    }

    public Integer getFillGradient() {
        return fillGradient;
    }

    public void setFillGradient(Integer fillGradient) {
        this.fillGradient = fillGradient;
    }

    public boolean isHiddenSeries() {
        return hiddenSeries;
    }

    public void setHiddenSeries(boolean hiddenSeries) {
        this.hiddenSeries = hiddenSeries;
    }

    public boolean isLines() {
        return lines;
    }

    public void setLines(boolean lines) {
        this.lines = lines;
    }

    public Integer getLinewidth() {
        return linewidth;
    }

    public void setLinewidth(Integer linewidth) {
        this.linewidth = linewidth;
    }

    public String getNullPointMode() {
        return nullPointMode;
    }

    public void setNullPointMode(String nullPointMode) {
        this.nullPointMode = nullPointMode;
    }

    public boolean isPercentage() {
        return percentage;
    }

    public void setPercentage(boolean percentage) {
        this.percentage = percentage;
    }

    public int getPointradius() {
        return pointradius;
    }

    public void setPointradius(int pointradius) {
        this.pointradius = pointradius;
    }

    public boolean isPoints() {
        return points;
    }

    public void setPoints(boolean points) {
        this.points = points;
    }

    public String getRenderer() {
        return renderer;
    }

    public void setRenderer(String renderer) {
        this.renderer = renderer;
    }

    public Integer getSpaceLength() {
        return spaceLength;
    }

    public void setSpaceLength(Integer spaceLength) {
        this.spaceLength = spaceLength;
    }

    public boolean isStack() {
        return stack;
    }

    public void setStack(boolean stack) {
        this.stack = stack;
    }

    public boolean isSteppedLine() {
        return steppedLine;
    }

    public void setSteppedLine(boolean steppedLine) {
        this.steppedLine = steppedLine;
    }

    public String[] getThresholds() {
        return thresholds;
    }

    public void setThresholds(String[] thresholds) {
        this.thresholds = thresholds;
    }

    public String[] getTimeRegions() {
        return timeRegions;
    }

    public void setTimeRegions(String[] timeRegions) {
        this.timeRegions = timeRegions;
    }

    public LineGraphTooltipTpl getTooltip() {
        return tooltip;
    }

    public void setTooltip(LineGraphTooltipTpl tooltip) {
        this.tooltip = tooltip;
    }

    public LineGraphLegendTpl getLegend() {
        return legend;
    }

    public void setLegend(LineGraphLegendTpl legend) {
        this.legend = legend;
    }

    public LineGraphOptionsTpl getOptions() {
        return options;
    }

    public void setOptions(LineGraphOptionsTpl options) {
        this.options = options;
    }

    public JsonObject[] getSeriesOverrides() {
        return seriesOverrides;
    }

    public void setSeriesOverrides(JsonObject[] seriesOverrides) {
        this.seriesOverrides = seriesOverrides;
    }

    public LineGraphXAxis getXaxis() {
        return xaxis;
    }

    public void setXaxis(LineGraphXAxis xaxis) {
        this.xaxis = xaxis;
    }

    public LineGraphYAxis getYaxis() {
        return yaxis;
    }

    public void setYaxis(LineGraphYAxis yaxis) {
        this.yaxis = yaxis;
    }

    public List<LineGraphYAxesJSONTpl> getYaxes() {
        return yaxes;
    }

    public void setYaxes(List<LineGraphYAxesJSONTpl> yaxes) {
        this.yaxes = yaxes;
    }



    @SerializedName("aliasColors")
    @Expose
    private String aliasColors;

    @SerializedName("bars")
    @Expose
    private boolean bars;

    @SerializedName("dashLength")
    @Expose
    private Integer dashLength;

    @SerializedName("dashes")
    @Expose
    private boolean dashes;

    @SerializedName("fill")
    @Expose
    private Integer fill;

    @SerializedName("fillGradient")
    @Expose
    private Integer fillGradient;


    @SerializedName("hiddenSeries")
    @Expose
    private boolean hiddenSeries;

    @SerializedName("lines")
    @Expose
    private boolean lines;

    @SerializedName("linewidth")
    @Expose
    private Integer linewidth;

    @SerializedName("nullPointMode")
    @Expose
    private String nullPointMode;

    @SerializedName("percentage")
    @Expose
    private boolean percentage;

    @SerializedName("pointradius")
    @Expose
    private int pointradius;

    @SerializedName("points")
    @Expose
    private boolean points;

    @SerializedName("renderer")
    @Expose
    private String renderer;

    @SerializedName("spaceLength")
    @Expose
    private Integer spaceLength;

    @SerializedName("stack")
    @Expose
    private boolean stack;

    @SerializedName("steppedLine")
    @Expose
    private boolean steppedLine;


    @SerializedName("thresholds")
    @Expose
    private String[] thresholds = {};


    @SerializedName("timeRegions")
    @Expose
    private String[] timeRegions={};

    @SerializedName("tooltip")
    @Expose
    private LineGraphTooltipTpl tooltip;

    @SerializedName("legend")
    @Expose
    private LineGraphLegendTpl legend;

    @SerializedName("options")
    @Expose
    private LineGraphOptionsTpl options;

    @SerializedName("seriesOverrides")
    @Expose
    private JsonObject[] seriesOverrides; //initialize with empty JSONObject array

    @SerializedName("xaxis")
    @Expose
    private LineGraphXAxis xaxis;

    @SerializedName("yaxis")
    @Expose
    private LineGraphYAxis yaxis;

    @SerializedName("yaxes")
    @Expose
    private List<LineGraphYAxesJSONTpl> yaxes;





    public LineGraphPanelTpl(){
        super();
        this.yaxes = new ArrayList<>();
        LineGraphYAxesJSONTpl j = new LineGraphYAxesJSONTpl();
        this.yaxes.add(j);
        this.yaxes.add(j);

        this.yaxis = new LineGraphYAxis();
        this.xaxis = new LineGraphXAxis();
        this.aliasColors =null;// Verify prone to error
        this.seriesOverrides = new JsonObject[]{};
        this.options = new LineGraphOptionsTpl();
        this.legend = new LineGraphLegendTpl();
        this.tooltip = new LineGraphTooltipTpl();

        this.bars = false;
        this.dashLength =10;
        this.dashes = false;
        this.fill =0;
        this.fillGradient=0;
        this.hiddenSeries = false;
        this.lines = true;
        this.linewidth= 1;
        this.nullPointMode = null;
        this.percentage = false;
        this.pointradius = 2;
        this.renderer= "flot";
        this.spaceLength = 10;
        this.stack = false;
        this.steppedLine = false;
        this.points = true;


    }
}




