package org.grafana.api.templates.Dashboard.GrafanaPanel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.grafana.api.octocharts.OctoHeatmapChart;

import java.util.logging.Logger;

public class TableSortTpl {
    static Logger log = Logger.getLogger(TableSortTpl.class.getName());

    public Integer getCol() {
        return col;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public Boolean getDesc() {
        return desc;
    }

    public void setDesc(Boolean desc) {
        this.desc = desc;
    }

    @SerializedName("col")
    @Expose
    private Integer col;

    @SerializedName("desc")
    @Expose
    private Boolean desc;

    public TableSortTpl(){
        this.col= 0;
        this.desc = true;
        log.info("TableSortTpl Done");
    }
}
