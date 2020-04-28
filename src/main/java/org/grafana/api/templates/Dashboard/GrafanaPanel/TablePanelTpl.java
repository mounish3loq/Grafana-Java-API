package org.grafana.api.templates.Dashboard.GrafanaPanel;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.grafana.api.octocharts.OctoHeatmapChart;
import org.grafana.api.templates.Dashboard.GrafanaPanel.tablestyles.TableStylesTpl1;
import org.grafana.api.templates.Dashboard.GrafanaPanel.tablestyles.TableStylesTpl2;
import org.grafana.api.templates.Dashboard.abstractbasepanel.BaseTargetsTpl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class TablePanelTpl extends GrafanaBasePanelTpl {
    static Logger log = Logger.getLogger(TablePanelTpl.class.getName());

    @SerializedName("options")
    @Expose
    private String options;

    @SerializedName("styles")
    @Expose
    private List<Object> styles;

    @SerializedName("transform")
    @Expose
    private String transform;

    @SerializedName("pageSize")
    @Expose
    private Integer pageSize;

    @SerializedName("showHeader")
    @Expose
    private Boolean showHeader;

    @SerializedName("fontSize")
    @Expose
    private String fontSize;

    @SerializedName("columns")
    @Expose
    private String[] columns;

    @SerializedName("sort")
    @Expose
    private TableSortTpl sort;

    public void setTargets(String query) {
        TableTargetTpl ttp = new TableTargetTpl();
        ttp.setRawSql(query);
        List<BaseTargetsTpl> tp =this.getTargets();
        tp.add(ttp);
        this.setTargets(tp);
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public List<Object> getStyles() {
        return styles;
    }

    public void setStyles(List<Object> styles) {
        this.styles = styles;
    }

    public String getTransform() {
        return transform;
    }

    public void setTransform(String transform) {
        this.transform = transform;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Boolean getShowHeader() {
        return showHeader;
    }

    public void setShowHeader(Boolean showHeader) {
        this.showHeader = showHeader;
    }

    public String getFontSize() {
        return fontSize;
    }

    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }

    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }

    public TableSortTpl getSort() {
        return sort;
    }

    public void setSort(TableSortTpl sort) {
        this.sort = sort;
    }



    public TablePanelTpl(){
        // The styles are standard. no need for separate Template.
        this.styles = new ArrayList<>();
        this.styles.add(new TableStylesTpl1());
        this.styles.add(new TableStylesTpl2());
        this.sort = new TableSortTpl();
        this.columns = new String[]{};
        this.options = null;
        this.transform = "table";
        this.pageSize = null;
        this.showHeader = true;
        this.fontSize ="100%";
        log.info("TablePanelTPL Done");
    }


}
