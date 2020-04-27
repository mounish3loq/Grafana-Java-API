package org.grafana.api.templates.Dashboard.GrafanaPanel.tablestyles;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class TableStylesTpl2 {
    @SerializedName("alias")
    @Expose
    private String alias;

    @SerializedName("align")
    @Expose
    private String align;

    @SerializedName("colorMode")
    @Expose
    private String colorMode;

    @SerializedName("colors")
    @Expose
    private List<String> colors;

    @SerializedName("decimals")
    @Expose
    private Integer decimals;

    @SerializedName("pattern")
    @Expose
    private String pattern;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("unit")
    @Expose
    private String unit;

    @SerializedName("thresholds")
    @Expose
    private List<String> thresholds;

    public TableStylesTpl2(){
        this.alias = "";
        this.align = "right";
        this.colorMode = null;
        this.colors = new ArrayList<>();
        this.colors.add("rgba(245, 54, 54, 0.9)");
        this.colors.add("rgba(237, 129, 40, 0.89)");
        this.colors.add("rgba(50, 172, 45, 0.97)");
        this.decimals = 2;
        this.pattern = "/.*/";
        this.type = "number";
        this.unit = "short";
    }
}
