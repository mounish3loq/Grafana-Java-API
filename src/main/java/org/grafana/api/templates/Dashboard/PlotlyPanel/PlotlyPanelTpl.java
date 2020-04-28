package org.grafana.api.templates.Dashboard.PlotlyPanel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.grafana.api.templates.Dashboard.abstractbasepanel.BasePanelTpl;

import java.util.ArrayList;
import java.util.List;

public class PlotlyPanelTpl extends BasePanelTpl {
    @SerializedName("datasource")
    @Expose
    private String datasource;
    @SerializedName("gridPos")
    @Expose
    private PlotlyGridPosTpl gridPos;
    @SerializedName("id")
    @Expose
    private Object id;
    @SerializedName("pconfig")
    @Expose
    private PlotlyPconfigTpl pconfig;
    @SerializedName("targets")
    @Expose
    private List<PlotlyTargetsTpl> targets = new ArrayList<>();
    @SerializedName("timefrom")
    @Expose
    private Object timefrom;
    @SerializedName("timeshift")
    @Expose
    private Object timeshift;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("version")
    @Expose
    private Integer version;

    public PlotlyPanelTpl(){
        this.id = null;
        this.gridPos = new PlotlyGridPosTpl();
        this.pconfig = new PlotlyPconfigTpl();
        this.timefrom = null;
        this.timeshift = null;
    }
    /**
     *
     * @return
     */
    public String getDatasource() {
        return datasource;
    }

    /**
     *
     * @param datasource
     */
    public void setDatasource(String datasource) {
        this.datasource = datasource;
    }

    /**
     *
     * @return
     */
    public PlotlyGridPosTpl getGridPos() {
        return gridPos;
    }

    /**
     *
     * @param gridPos
     */
    public void setGridPos(PlotlyGridPosTpl gridPos) {
        this.gridPos = gridPos;
    }

    /**
     *
     * @return
     */
    public Object getID() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setID(Object id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public PlotlyPconfigTpl getPconfig() {
        return pconfig;
    }

    /**
     *
     * @param pconfig
     */
    public void setPconfig(PlotlyPconfigTpl pconfig) {
        this.pconfig = pconfig;
    }

    /**
     *
     * @return
     */
    public List<PlotlyTargetsTpl> getTargets() {
        return targets;
    }

    /**
     *
     * @param targets
     */
    public void setTargets(List<PlotlyTargetsTpl> targets) {
        this.targets = targets;
    }

    /**
     *
     * @return
     */
    public Object getTimefrom() {
        return timefrom;
    }

    /**
     *
     * @param timefrom
     */
    public void setTimefrom(Object timefrom) {
        this.timefrom = timefrom;
    }

    /**
     *
     * @return
     */
    public Object getTimeshift() {
        return timeshift;
    }

    /**
     *
     * @param timeshift
     */
    public void setTimeshift(Object timeshift) {
        this.timeshift = timeshift;
    }

    /**
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     *
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     *
     * @return
     */
    public Integer getVersion() {
        return version;
    }

    /**
     *
     * @param version
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
}
