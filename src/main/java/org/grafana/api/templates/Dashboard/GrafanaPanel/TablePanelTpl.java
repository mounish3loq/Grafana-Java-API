package org.grafana.api.templates.Dashboard.GrafanaPanel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TablePanelTpl extends GrafanaBasePanelTpl {
    @SerializedName("targets")
    @Expose
    private List<TableTargetTpl> targets = new ArrayList<>();

    public List<TableTargetTpl> getTargets() {
        return targets;
    }

    public void setTargets(List<TableTargetTpl> targets) {
        this.targets = targets;
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
        List<TableTargetTpl> tp =this.getTargets();
        tp.add(ttp);
        this.setTargets(tp);
    }



    public TablePanelTpl(){
        // The styles are standard. no need for separate Template.
        styles = new ArrayList<>();
        JSONObject temp = new JSONObject();
        temp.put("type","date");
        temp.put("pattern","Time");
        temp.put("alias","Time");
        temp.put("dateFormat","YYYY-MM-DD HH:mm:ss");
        temp.put("align","auto");

        String[] a = new String[]{};
        JSONObject temp2 = new JSONObject();
        temp2.put("unit","short");
        temp2.put("type","number");
        temp2.put("alias","");
        temp2.put("decimals",2);
        temp2.put("colors",a);
        temp2.put("colorMode","");
        temp2.put("pattern","/.*/");
        temp2.put("thresholds",a);
        temp2.put("align","right");

        this.sort = new TableSortTpl();
        this.columns = new String[]{};
        this.options = null;
        this.transform = "table";
        this.pageSize = null;
        this.showHeader = true;
        this.fontSize ="100%";
    }


}
