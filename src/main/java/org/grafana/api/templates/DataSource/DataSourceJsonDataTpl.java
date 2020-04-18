package org.grafana.api.templates.DataSource;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataSourceJsonDataTpl {
    @SerializedName("sslmode")
    @Expose
    private String sslmode;  //disable/require/verify-ca/verify-full
    @SerializedName("maxOpenConns")
    @Expose
    private Integer maxOpenConns;
    @SerializedName("maxIdleConns")
    @Expose
    private Integer maxIdleConns;
    @SerializedName("connMaxLifetime")
    @Expose
    private Integer connMaxLifetime;
    @SerializedName("postgresVersion")  //903=9.3, 904=9.4, 905=9.5, 906=9.6, 1000=10
    @Expose
    private Integer postgresVersion;
    @SerializedName("timescaledb")
    @Expose
    private boolean timescaledb;

    public String getSslmode() {
        return sslmode;
    }

    public void setSslmode(String sslmode) {
        this.sslmode = sslmode;
    }

    public Integer getMaxOpenConns() {
        return maxOpenConns;
    }

    public void setMaxOpenConns(Integer maxOpenConns) {
        this.maxOpenConns = maxOpenConns;
    }

    public Integer getMaxIdleConns() {
        return maxIdleConns;
    }

    public void setMaxIdleConns(Integer maxIdleConns) {
        this.maxIdleConns = maxIdleConns;
    }

    public Integer getConnMaxLifetime() {
        return connMaxLifetime;
    }

    public void setConnMaxLifetime(Integer connMaxLifetime) {
        this.connMaxLifetime = connMaxLifetime;
    }

    public Integer getPostgresVersion() {
        return postgresVersion;
    }

    public void setPostgresVersion(Integer postgresVersion) {
        this.postgresVersion = postgresVersion;
    }

    public boolean isTimescaledb() {
        return timescaledb;
    }

    public void setTimescaledb(boolean timescaledb) {
        this.timescaledb = timescaledb;
    }
}
