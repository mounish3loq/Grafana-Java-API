package org.grafana.api.templates.DataSource;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.grafana.api.templates.Dashboard.AnnotationsTpl;

public class CreateDataSourceTpl {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("database")
    @Expose
    private String database;
    @SerializedName("user")
    @Expose
    private String user;
    @SerializedName("secureJsonData")
    @Expose
    private SecureJsonDataTpl secureJsonData;
    @SerializedName("access")
    @Expose
    private String access;
    @SerializedName("basicAuth")
    @Expose
    private boolean basicAuth;
    @SerializedName("jsonData")
    @Expose
    private DataSourceJsonDataTpl jsonData;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public SecureJsonDataTpl getSecureJsonData() {
        return secureJsonData;
    }

    public void setSecureJsonData(SecureJsonDataTpl secureJsonData) {
        this.secureJsonData = secureJsonData;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public boolean isBasicAuth() {
        return basicAuth;
    }

    public void setBasicAuth(boolean basicAuth) {
        this.basicAuth = basicAuth;
    }

    public DataSourceJsonDataTpl getJsonData() {
        return jsonData;
    }

    public void setJsonData(DataSourceJsonDataTpl jsonData) {
        this.jsonData = jsonData;
    }
}
