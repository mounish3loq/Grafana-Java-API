package org.grafana.api.templates.Dashboard.GrafanaPanel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.grafana.api.templates.Dashboard.PlotlyPanel.PlotlyTargetsTpl;

public class LineGraphTargetsTpl extends PlotlyTargetsTpl {

    public boolean isHide() {
        return hide;
    }

    public void setHide(boolean hide) {
        this.hide = hide;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    @SerializedName("hide")
    @Expose
    private boolean hide;

    @SerializedName("table")
    @Expose
    private String  table;


    public LineGraphTargetsTpl(String query,String table,String format) {
        super(query);
        super.setFormat(format);
        this.hide = false;
        this.table = table;
    }
}
