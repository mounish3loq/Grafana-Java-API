package org.grafana.api.templates.Dashboard.variables;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OptionsTpl {

    @SerializedName("selected")
    @Expose
    private Boolean selected;

    @SerializedName("text")
    @Expose
    private String text;

    @SerializedName("value")
    @Expose
    private String value;

    public OptionsTpl(String option){
        this.selected = false;
        this.text = option;
        this.value = option;
    }

    public OptionsTpl(String option,Boolean isthisSelected){
        this.selected = isthisSelected;
        this.text = option;
        this.value = option;
    }
    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
