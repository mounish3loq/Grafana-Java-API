package org.grafana.api.templates.Dashboard.Panel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class PanelTpl {
    @SerializedName("datasource")
    @Expose
    private String datasource;
    @SerializedName("gridPos")
    @Expose
    private GridPosTpl gridPos;
    @SerializedName("id")
    @Expose
    private Object id;
    @SerializedName("pconfig")
    @Expose
    private PconfigTpl pconfig;
    @SerializedName("targets")
    @Expose
    private List<TargetsTpl> targets = new ArrayList<>();
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

    public PanelTpl(){
        this.id = null;
        this.gridPos = new GridPosTpl();
        this.pconfig = new PconfigTpl();
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
    public GridPosTpl getGridPos() {
        return gridPos;
    }

    /**
     *
     * @param gridPos
     */
    public void setGridPos(GridPosTpl gridPos) {
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
    public PconfigTpl getPconfig() {
        return pconfig;
    }

    /**
     *
     * @param pconfig
     */
    public void setPconfig(PconfigTpl pconfig) {
        this.pconfig = pconfig;
    }

    /**
     *
     * @return
     */
    public List<TargetsTpl> getTargets() {
        return targets;
    }

    /**
     *
     * @param targets
     */
    public void setTargets(List<TargetsTpl> targets) {
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
