package org.grafana.api.templates.Dashboard.GrafanaPanel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.grafana.api.templates.Dashboard.PlotlyPanel.PlotlyGridPosTpl;

import java.util.ArrayList;
import java.util.List;

public class GrafanaBasePanelTpl {

    @SerializedName("datasource")
    @Expose
    private String datasource;

    @SerializedName("gridPos")
    @Expose
    private PlotlyGridPosTpl gridPos;

    @SerializedName("id")
    @Expose
    private Object id;

    @SerializedName("targets")
    @Expose
    private List<LineGraphTargetsTpl> targets = new ArrayList<>();

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

    public String getDatasource() {
        return datasource;
    }

    public void setDatasource(String datasource) {
        this.datasource = datasource;
    }

    public PlotlyGridPosTpl getGridPos() {
        return gridPos;
    }

    public void setGridPos(PlotlyGridPosTpl gridPos) {
        this.gridPos = gridPos;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }


    public List<LineGraphTargetsTpl> getTargets() {
        return targets;
    }

    public void setTargets(List<LineGraphTargetsTpl> targets) {
        this.targets = targets;
    }

    public Object getTimefrom() {
        return timefrom;
    }

    public void setTimefrom(Object timefrom) {
        this.timefrom = timefrom;
    }

    public Object getTimeshift() {
        return timeshift;
    }

    public void setTimeshift(Object timeshift) {
        this.timeshift = timeshift;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @SerializedName("version")
    @Expose
    private Integer version;

    public GrafanaBasePanelTpl(){
        this.id = null;
        this.gridPos = new PlotlyGridPosTpl();
        this.gridPos.setH(8);
        this.gridPos.setW(24);
        this.gridPos.setY(48);
        this.timefrom = null;
        this.timeshift = null;
    }

}
