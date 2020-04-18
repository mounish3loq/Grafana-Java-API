/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grafana.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import org.grafana.api.config.*;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jonathan Hetzer at Schramm und Partner GmbH
 */
public class ConfigLoader {
    
    private static final String pathAdminOrganisationAPI = "/config/AdminOrganisationAPI.json";
    private static final String pathAdminUserAPI = "/config/AdminUserAPI.json";
    private static final String pathCurrOrganisationAPI = "/config/CurrOrganisationAPI.json";
    private static final String pathDataSourceAPI = "/config/DataSourceAPI.json";
    private static final String pathDashboardAPI = "/config/DashboardAPI.json";
    private static final String pathFolderAPI = "/config/FolderAPI.json";
    private static final String pathFolderDashboardSearchAPI = "/config/FolderDashboardSearchAPI.json";
    private static final String pathAdminAPI = "/config/AdminAPI.json";
    private static final String pathAuthAPI = "/config/AdminAuthAPI.json";
    private static final String pathExperimental = "/config/Experimental.json";
    
    private final Gson gson;
    private final AdminOrganisationAPI adminOrganisationAPI;
    private final AdminUserAPI adminUserAPI;
    private final CurrOrganisationAPI currOrganisationAPI;
    private final DataSourceAPI dataSourceAPI;
    private final DashboardAPI dashboardAPI;
    private final FolderAPI folderAPI;
    private final FolderDashboardSearchAPI folderDashboardSearchAPI;
    private final AdminAPI adminAPI;
    private final AdminAuthAPI authAPI;
    private final Experimental experimental;
    
    /**
     * Load GrafanaAPI config from JSON Files
     *
     */
    public ConfigLoader() {
        this.gson = new GsonBuilder().create();
        this.adminOrganisationAPI = gson.fromJson(getJsonElementFromPath(pathAdminOrganisationAPI), AdminOrganisationAPI.class);
        this.adminUserAPI = gson.fromJson(getJsonElementFromPath(pathAdminUserAPI), AdminUserAPI.class);
        this.currOrganisationAPI = gson.fromJson(getJsonElementFromPath(pathCurrOrganisationAPI), CurrOrganisationAPI.class);
        this.dataSourceAPI = gson.fromJson(getJsonElementFromPath(pathDataSourceAPI), DataSourceAPI.class);
        this.dashboardAPI = gson.fromJson(getJsonElementFromPath(pathDashboardAPI), DashboardAPI.class);
        this.folderAPI = gson.fromJson(getJsonElementFromPath(pathFolderAPI), FolderAPI.class);
        this.folderDashboardSearchAPI = gson.fromJson(getJsonElementFromPath(pathFolderDashboardSearchAPI), FolderDashboardSearchAPI.class);
        this.adminAPI = gson.fromJson(getJsonElementFromPath(pathAdminAPI), AdminAPI.class);
        this.authAPI = gson.fromJson(getJsonElementFromPath(pathAuthAPI), AdminAuthAPI.class);
        this.experimental = gson.fromJson(getJsonElementFromPath(pathExperimental), Experimental.class);
        
    }

    /**
     *
     * @return
     */
    public AdminOrganisationAPI getAdminOrganisationAPI() {
        return adminOrganisationAPI;
    }

    /**
     *
     * @return
     */
    public AdminUserAPI getAdminUserAPI() {
        return adminUserAPI;
    }

    /**
     *
     * @return
     */
    public CurrOrganisationAPI getCurrOrganisationAPI() {
        return currOrganisationAPI;
    }

    /**
     *
     * @return
     */
    public DataSourceAPI getDataSourceAPI() {
        return dataSourceAPI;
    }

    /**
     *
     * @return
     */
    public DashboardAPI getDashboardAPI() {
        return dashboardAPI;
    }

    /**
     *
     * @return
     */
    public FolderAPI getFolderAPI() {
        return folderAPI;
    }

    /**
     *
     * @return
     */
    public FolderDashboardSearchAPI getFolderDashboardSearchAPI() {
        return folderDashboardSearchAPI;
    }

    /**
     *
     * @return
     */
    public AdminAPI getAdminAPI() {
        return adminAPI;
    }
    
    /**
     *
     * @return
     */
    public AdminAuthAPI getAuthAPI(){
        return authAPI;
    }

    /**
     *
     * @return
     */
    public Experimental getExperimental() {
        return experimental;
    }
    
    private JsonElement getJsonElementFromPath(String path){
        JsonElement jsonElement = null;
        try (Reader reader = new InputStreamReader(ConfigLoader.class.getResourceAsStream(path), "UTF-8"); 
            JsonReader jReader = new JsonReader(reader)) {
            jsonElement = gson.fromJson(jReader, JsonElement.class);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ConfigLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConfigLoader.class.getName()).log(Level.SEVERE, null, ex);
        } //catch (IO ex) {
        return jsonElement;
    }
}
