package org.grafana.api.templates.Dashboard.GrafanaPanel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.grafana.api.templates.Dashboard.PlotlyPanel.Targets.WhereTpl;
import org.grafana.api.templates.Dashboard.abstractbasepanel.BaseTargetsTpl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class TableTargetTpl extends BaseTargetsTpl {
    static Logger log = Logger.getLogger(TableTargetTpl.class.getName());

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getTimeColumn() {
        return timeColumn;
    }

    public void setTimeColumn(String timeColumn) {
        this.timeColumn = timeColumn;
    }

    public String getMetricColumn() {
        return metricColumn;
    }

    public void setMetricColumn(String metricColumn) {
        this.metricColumn = metricColumn;
    }

    public String[] getGroup() {
        return group;
    }

    public void setGroup(String[] group) {
        this.group = group;
    }

    public List<Object> getWhere() {
        return where;
    }

    public void setWhere(List<Object> where) {
        this.where = where;
    }

    public List<Object> getSelect() {
        return select;
    }

    public void setSelect(List<Object> select) {
        this.select = select;
    }

    public Boolean getRawQuery() {
        return rawQuery;
    }

    public void setRawQuery(Boolean rawQuery) {
        this.rawQuery = rawQuery;
    }

    public String getRawSql() {
        return rawSql;
    }

    public void setRawSql(String rawSql) {
        this.rawSql = rawSql;
    }

    @SerializedName("refId")
    @Expose
    private String refId;

    @SerializedName("format")
    @Expose
    private String format;

    @SerializedName("timeColumn")
    @Expose
    private String timeColumn;

    @SerializedName("metricColumn")
    @Expose
    private String metricColumn;

    @SerializedName("group")
    @Expose
    private String[] group;

    @SerializedName("where")
    @Expose
    private List<Object> where;

    @SerializedName("select")
    @Expose
    private List<Object> select;

    @SerializedName("rawQuery")
    @Expose
    private Boolean rawQuery;

    @SerializedName("rawSql")
    @Expose
    private String rawSql;

    public TableTargetTpl(){
        this.refId = null;
        this.format ="table";
        this.timeColumn = "time";
        this.metricColumn = "none";
        this.group = new String[]{};
        this.rawQuery = true;

//        JSONObject temp = new JSONObject();
//        String[] temp2 = new String[]{};
//        temp.put("type","macro");
//        temp.put("name","$__timeFilter");
//        temp.put("params",temp2);
//        this.where=  new ArrayList<>();
////        WhereTpl wtp = new WhereTpl();
//        this.where.add(temp);
        this.where = new ArrayList<>();
        this.where.add(new WhereTpl());
        this.select = new ArrayList<>();
        this.select.add(new String[]{});
        log.info("TableTargetTpl Done");

    }

}
