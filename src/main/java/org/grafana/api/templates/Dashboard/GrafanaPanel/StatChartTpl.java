package org.grafana.api.templates.Dashboard.GrafanaPanel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.grafana.api.templates.Dashboard.abstractbasepanel.BaseTargetsTpl;

import java.util.List;
import java.util.logging.Logger;

public class StatChartTpl extends GrafanaBasePanelTpl {

    @SerializedName("pluginVersion")
    @Expose
    private String  pluginVersion;

    @SerializedName("options")
    @Expose
    private StatChartOptionsTpl options;
    //static Logger log = Logger.getLogger(StatChartTpl.class.getName());
    static Logger log = Logger.getLogger("myLogger");

    public StatChartTpl(){
        this.options = new StatChartOptionsTpl();
        this.pluginVersion = "6.6.2";
        log.info("StatChartTpl executed");
    }

    public String getPluginVersion() {
        return pluginVersion;
    }

    public void setPluginVersion(String pluginVersion) {
        this.pluginVersion = pluginVersion;
    }

    public void setTargets(String query) {
        TableTargetTpl ttp = new TableTargetTpl();
        ttp.setRawSql(query);
        List<BaseTargetsTpl> tp =this.getTargets();
        tp.add(ttp);
        this.setTargets(tp);
    }
}
