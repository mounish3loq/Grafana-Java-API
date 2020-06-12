package org.grafana.api.templates.Dashboard.GrafanaPanel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.logging.Logger;

public class LineGraphTooltipTpl{
    static Logger log = Logger.getLogger(LineGraphTooltipTpl.class.getName());

    @SerializedName("shared")
    @Expose
    private boolean shared;

    @SerializedName("sort")
    @Expose
    private int sort;

    @SerializedName("value_type")
    @Expose
    private String value_type;

    public LineGraphTooltipTpl(){
        this.shared = false;
        this.sort = 0;
        this.value_type = "individual";
        log.info("LineGraphToolTip Done");
    }

}
