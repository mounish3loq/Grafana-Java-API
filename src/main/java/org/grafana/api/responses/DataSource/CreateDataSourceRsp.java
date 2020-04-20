package org.grafana.api.responses.DataSource;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.grafana.api.templates.DataSource.CreateDataSourceTpl;

public class CreateDataSourceRsp {
    @SerializedName("datasource")
    @Expose
    private CreateDataSourceTpl datasource;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("name")
    @Expose
    private String name;

    public CreateDataSourceTpl getDatasource() {
        return datasource;
    }

    public void setDatasource(CreateDataSourceTpl datasource) {
        this.datasource = datasource;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
