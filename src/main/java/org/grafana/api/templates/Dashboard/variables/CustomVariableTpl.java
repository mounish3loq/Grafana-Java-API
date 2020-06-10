package org.grafana.api.templates.Dashboard.variables;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CustomVariableTpl {
    @SerializedName("label")
    @Expose
    private String label;

    @SerializedName("multi")
    @Expose
    private Boolean multi;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("query")
    @Expose
    private String query;

    @SerializedName("queryValue")
    @Expose
    private String queryValue;

    @SerializedName("skipUrlSync")
    @Expose
    private Boolean skipUrlSync;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("options")
    @Expose
    private ArrayList options = new ArrayList<>();

    public CustomVariableTpl(String variableName){
        this.label = variableName;
        this.name = variableName;
        this.type = "custom";
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Boolean getMulti() {
        return multi;
    }

    public void setMulti(Boolean multi) {
        this.multi = multi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getQueryValue() {
        return queryValue;
    }

    public void setQueryValue(String queryValue) {
        this.queryValue = queryValue;
    }

    public Boolean getSkipUrlSync() {
        return skipUrlSync;
    }

    public void setSkipUrlSync(Boolean skipUrlSync) {
        this.skipUrlSync = skipUrlSync;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList getOptions() {
        return options;
    }

    public void setOptions(ArrayList options) {
        this.options = options;
    }

    public void setOption(String option){
        this.query = this.query + "," + option;
        this.options.add(new OptionsTpl(option));
    }
    public void setOption(String option,Boolean isSelected){
        this.options.add(new OptionsTpl(option,isSelected));
    }
}
