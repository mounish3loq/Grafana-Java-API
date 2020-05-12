package org.grafana.api.templates.Dashboard.GrafanaPanel;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class StatChartThresholdTpl {

    @SerializedName("mode")
    @Expose
    private String  mode;

    @SerializedName("steps")
    @Expose
    private List steps;

    public StatChartThresholdTpl(){
        this.mode = "absolute";

        JsonObject stepsobject = new JsonObject();
        stepsobject.addProperty("value","");
        stepsobject.addProperty("color","green");
        this.steps = new ArrayList();
        this.steps.add(stepsobject);
        this.steps.add(stepsobject);
    }
    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public List getSteps() {
        return steps;
    }

    public void setSteps(List steps) {
        this.steps = steps;
    }
}
