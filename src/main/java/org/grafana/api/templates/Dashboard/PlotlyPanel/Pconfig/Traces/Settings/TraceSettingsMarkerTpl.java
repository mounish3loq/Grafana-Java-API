package org.grafana.api.templates.Dashboard.PlotlyPanel.Pconfig.Traces.Settings;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TraceSettingsMarkerTpl {
    @SerializedName("color")
    @Expose
    private String color;

    @SerializedName("colorscale")
    @Expose
    private String colorscale;

    @SerializedName("line")
    @Expose
    private TraceSettingsLineTpl line;

    @SerializedName("showscale")
    @Expose
    private boolean showscale;

    @SerializedName("size")
    @Expose
    private Integer size;

    @SerializedName("sizemin")
    @Expose
    private Integer sizemin;

    @SerializedName("sizemode")
    @Expose
    private String sizemode;

    @SerializedName("symbol")
    @Expose
    private String symbol;

    @SerializedName("sizeref")
    @Expose
    private Float sizeref;
}
