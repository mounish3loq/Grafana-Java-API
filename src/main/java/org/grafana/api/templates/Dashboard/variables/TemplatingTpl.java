package org.grafana.api.templates.Dashboard.variables;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TemplatingTpl {
    @SerializedName("list")
    @Expose
    private ArrayList listOfVariables = new ArrayList<>();

    public ArrayList getListOfVariables() {
        return listOfVariables;
    }

    public void setListOfVariables(ArrayList listOfVariables) {
        this.listOfVariables = listOfVariables;
    }

    public void setAVariable(CustomVariableTpl var){
        this.listOfVariables.add(var);
    }
}
