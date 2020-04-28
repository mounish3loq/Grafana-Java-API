package org.grafana.api.templates.Dashboard.PlotlyPanel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.grafana.api.templates.Dashboard.PlotlyPanel.Targets.ParamsTpl;
import org.grafana.api.templates.Dashboard.PlotlyPanel.Targets.WhereTpl;
import org.grafana.api.templates.Dashboard.abstractbasepanel.BaseTargetsTpl;

import java.util.ArrayList;
import java.util.List;

public class PlotlyTargetsTpl extends BaseTargetsTpl {

    @SerializedName("format")
    @Expose
    private String format;
    @SerializedName("group")
    @Expose
    private List<Object> group;
    @SerializedName("metricColumn")
    @Expose
    private String metricColumn;
    @SerializedName("rawQuery")
    @Expose
    private boolean rawQuery;
    @SerializedName("rawSql")
    @Expose
    private String rawSql;
    @SerializedName("refId")
    @Expose
    private String refId;
    @SerializedName("select")
    @Expose
    private List<Object> select;
    @SerializedName("timeColumn")
    @Expose
    private String timeColumn;
    @SerializedName("where")
    @Expose
    private List<Object> where;

    public PlotlyTargetsTpl(String query){
        this.format = "table";
        this.group = new ArrayList<>();
        this.metricColumn = "none";
        this.rawQuery = true;
        this.rawSql = query;
        this.refId="A";
        ParamsTpl pt = new ParamsTpl();
        List<Object> paramTplList = new ArrayList<>();
        paramTplList.add(pt);
        this.select =new ArrayList<>();
        this.select.add(paramTplList);
        this.timeColumn ="time";
        this.where = new ArrayList<>();
        this.where.add(new WhereTpl());
    }



    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public List<Object> getGroup() {
        return group;
    }

    public void setGroup(List<Object> group) {
        this.group = group;
    }

    public String getMetricColumn() {
        return metricColumn;
    }

    public void setMetricColumn(String metricColumn) {
        this.metricColumn = metricColumn;
    }

    public boolean isRawQuery() {
        return rawQuery;
    }

    public void setRawQuery(boolean rawQuery) {
        this.rawQuery = rawQuery;
    }

    public String getRawSql() {
        return rawSql;
    }

    public void setRawSql(String rawSql) {
        this.rawSql = rawSql;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public List<Object> getSelect() {
        return select;
    }

    public void setSelect(List<Object> select) {
        this.select = select;
    }

    public String getTimeColumn() {
        return timeColumn;
    }

    public void setTimeColumn(String timeColumn) {
        this.timeColumn = timeColumn;
    }
    public List<Object> getWhere() {
        return where;
    }

    public void setWhere(List<Object> where) {
        this.where = where;
    }
}
