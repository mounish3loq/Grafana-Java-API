package org.grafana.api.templates.Dashboard.GrafanaPanel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.grafana.api.octocharts.OctoHeatmapChart;

import java.util.logging.Logger;

public class LineGraphOptionsTpl{
    static Logger log = Logger.getLogger(LineGraphOptionsTpl.class.getName());

    @SerializedName("datalinks")
    @Expose
    private String[] datalinks;

    public LineGraphOptionsTpl(){
        this.datalinks = new String[]{};
        log.info("LineGraphOptions Template");
    }
}
