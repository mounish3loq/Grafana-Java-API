package org.grafana.api.templates.Dashboard.PlotlyPanel.Pconfig.Layout;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FontTpl {
    @SerializedName("family")
    @Expose
    private String family;

    public FontTpl(){
        this.family = "\"Open Sans\", Helvetica, Arial, sans-serif";
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }
}
