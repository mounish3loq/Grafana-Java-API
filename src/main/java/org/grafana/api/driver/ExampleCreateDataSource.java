package org.grafana.api.driver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.grafana.api.GrafanaAPI;
import org.grafana.api.responses.Dashboard.NewCreateUpdateDashboardRsp;
import org.grafana.api.responses.DataSource.CreateDataSourceRsp;
import org.grafana.api.templates.DataSource.CreateDataSourceTpl;
import org.grafana.api.templates.DataSource.DataSourceJsonDataTpl;
import org.grafana.api.templates.DataSource.SecureJsonDataTpl;

import java.io.FileWriter;
import java.io.IOException;

public class ExampleCreateDataSource {
    public static void main(String args[]){
        Gson gson = new GsonBuilder().create();
        String grafanaserver = "http://localhost:3000";
        String mainOrgApiKey = "Bearer eyJrIjoiSmtSNUY2R3RyV0hVQ0oxQ0E5NlJlZ0lXYVp4Z0s0T1QiLCJuIjoiVGVzdCBLZXkiLCJpZCI6MX0= ";
        GrafanaAPI grafanaAPI = new GrafanaAPI(grafanaserver);
        SecureJsonDataTpl pass = new SecureJsonDataTpl();
        pass.setPassword("12345");
        DataSourceJsonDataTpl jsonData = new DataSourceJsonDataTpl();
        CreateDataSourceTpl mysqldatasource = new CreateDataSourceTpl();
        mysqldatasource.setName("Mysql2");
        mysqldatasource.setType("mysql");
        mysqldatasource.setUrl("http://localhost:3306");
        mysqldatasource.setDatabase("pre_post_analysis");
        mysqldatasource.setUser("root");
        mysqldatasource.setSecureJsonData(pass);
        mysqldatasource.setAccess("proxy");
        mysqldatasource.setBasicAuth(false);
        /*
        try{
            FileWriter fw = new FileWriter("dashtest.json");
            fw.write(gson.toJson(mysqldatasource));
            fw.close();
        }catch (IOException ie){
            System.out.println("File error");
        }
        */
        CreateDataSourceRsp response = grafanaAPI.orgAdminAPI(mainOrgApiKey).createDataSource(mysqldatasource);
        System.out.println(response.getMessage());
        System.out.println(response.getId());
        System.out.println(response.getName());
        //NewCreateUpdateDashboardRsp createDataSource = grafanaAPI.orgAdminAPI(mainOrgApiKey).createUpdateDashboard(dashTest);
    }
}
