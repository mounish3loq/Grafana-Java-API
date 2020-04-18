package org.grafana.api.driver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.grafana.api.GrafanaAPI;
import org.grafana.api.responses.Dashboard.NewCreateUpdateDashboardRsp;
import org.grafana.api.templates.DataSource.CreateDataSourceTpl;
import org.grafana.api.templates.DataSource.DataSourceJsonDataTpl;
import org.grafana.api.templates.DataSource.SecureJsonDataTpl;

import java.io.FileWriter;
import java.io.IOException;

public class Example3 {
    public static void main(String args[]){
        Gson gson = new GsonBuilder().create();
        String grafanaserver = "http://localhost:3000";
        String mainOrgApiKey = "Bearer eyJrIjoiZ0ZNMVAyY0lTVHNMRzRSMmVMMTdIR0pHazlUSWlZQTUiLCJuIjoiSmF2YSBLZXkiLCJpZCI6MX0=";
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
        try{
            FileWriter fw = new FileWriter("dashtest.json");
            fw.write(gson.toJson(mysqldatasource));
            fw.close();
        }catch (IOException ie){
            System.out.println("File error");
        }
        System.out.println(grafanaAPI.orgAdminAPI(mainOrgApiKey).createDataSource(mysqldatasource));
        //NewCreateUpdateDashboardRsp createDataSource = grafanaAPI.orgAdminAPI(mainOrgApiKey).createUpdateDashboard(dashTest);
    }
}
