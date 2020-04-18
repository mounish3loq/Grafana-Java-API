package org.grafana.api.templates.DataSource;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SecureJsonDataTpl {
    @SerializedName("password")
    @Expose
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
