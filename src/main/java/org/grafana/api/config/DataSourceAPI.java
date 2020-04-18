package org.grafana.api.config;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataSourceAPI {
    @SerializedName("Version")
    @Expose
    private String version;
    @SerializedName("Authentication")
    @Expose
    private String authentication;
    @SerializedName("Link")
    @Expose
    private String link;
    @SerializedName("DataSourceByUid")
    @Expose
    private RequestParam dataSourceByUid;
    @SerializedName("DataSourceByName")
    @Expose
    private RequestParam dataSourceByName;
    @SerializedName("DataSourceIdByName")
    @Expose
    private RequestParam dataSourceIdByName;
    @SerializedName("CreateDataSource")
    @Expose
    private RequestParam createDataSource;
    @SerializedName("UpdateDataSource")
    @Expose
    private RequestParam updateDataSource;
    @SerializedName("DeleteDataSourceByUid")
    @Expose
    private RequestParam deleteDataSourceByUid;

    public String getVersion() {
        return version;
    }

    public String getAuthentication() {
        return authentication;
    }

    public String getLink() {
        return link;
    }

    public RequestParam getDataSourceByUid() {
        return dataSourceByUid;
    }

    public RequestParam getDataSourceByName() {
        return dataSourceByName;
    }

    public RequestParam getDataSourceIdByName() {
        return dataSourceIdByName;
    }

    public RequestParam getCreateDataSource() {
        return createDataSource;
    }

    public RequestParam getUpdateDataSource() {
        return updateDataSource;
    }

    public RequestParam getDeleteDataSourceByUid() {
        return deleteDataSourceByUid;
    }
}
