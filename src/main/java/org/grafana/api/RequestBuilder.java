package org.grafana.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.grafana.api.config.RequestParam;
import org.grafana.api.templates.Search.FolderDashboardTpl;

/**
 *
 * @author Jonathan Hetzer at Schramm und Partner GmbH
 */
public class RequestBuilder {
    
    private final GrafanaAPI grafanaAPI;
    private final Gson gson;
    private final String authentication;
    
    /**
     *
     * @param grafanaAPI
     */
    public RequestBuilder(GrafanaAPI grafanaAPI){
        this.grafanaAPI = grafanaAPI;
        this.gson = new GsonBuilder().create();
        if(grafanaAPI.getBasic() != null && !grafanaAPI.getBasic().isEmpty()){
            this.authentication = grafanaAPI.getBasic();
        }else if(grafanaAPI.getoAuth() != null && !grafanaAPI.getoAuth().isEmpty()){
            this.authentication = grafanaAPI.getoAuth();
        }else{
            throw new NullPointerException("Authentication method not found");
        }
    }
    
    /**
     *
     * @param <T>
     * @param requestParam
     * @param classOfT
     * @return
     */
    public <T> T setServerRequest(RequestParam requestParam, Class<T> classOfT){
        try{
            JsonElement createServerRequest = grafanaAPI.getServerConnection().createServerRequest(
                    requestParam.getURL().replace(" ", "%20"),
                    requestParam.getMethode(),
                    authentication
            );
            return gson.fromJson(createServerRequest, classOfT);
        }catch(NullPointerException ex){
            Logger.getLogger(RequestBuilder.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    /**
     *
     * @param <T>
     * @param requestParam
     * @param replacement
     * @param classOfT
     * @return
     */
    public <T> T setServerRequest(RequestParam requestParam, String replacement, Class<T> classOfT){
        try{
            String urlpath = requestParam.getURL().replace(requestParam.getParameter(), replacement).replace(" ", "%20");
            JsonElement createServerRequest = grafanaAPI.getServerConnection().createServerRequest(
                    requestParam.getURL().replace(requestParam.getParameter(), replacement).replace(" ", "%20"),
                    requestParam.getMethode(),
                    authentication
            );
            return gson.fromJson(createServerRequest, classOfT);
        }catch(NullPointerException ex){
            Logger.getLogger(RequestBuilder.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    /**
     *
     * @param <T>
     * @param requestParam
     * @param classOfT
     * @param body
     * @return
     */
    public <T> T setServerRequest(RequestParam requestParam, Class<T> classOfT, String body){
        try{
            JsonElement createServerRequest = grafanaAPI.getServerConnection().createServerRequest(
                    requestParam.getURL().replace(" ", "%20"),
                    requestParam.getMethode(),
                    body,
                    authentication
            );
            return gson.fromJson(createServerRequest, classOfT);
        }catch(NullPointerException ex){
            Logger.getLogger(RequestBuilder.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    /**
     *
     * @param <T>
     * @param requestParam
     * @param orgID
     * @param userID
     * @param classOfT
     * @return
     */
    public <T> T setServerRequest(RequestParam requestParam, String orgID, String userID, Class<T> classOfT){
        try{
            JsonElement createServerRequest = grafanaAPI.getServerConnection().createServerRequest(
                    requestParam.getURL()
                            .replace(requestParam.getParameters().getOrg(), orgID)
                            .replace(requestParam.getParameters().getUser(), userID)
                            .replace(" ", "%20"),
                    requestParam.getMethode(),
                    authentication
            );
            return gson.fromJson(createServerRequest, classOfT);
        }catch(NullPointerException ex){
            Logger.getLogger(RequestBuilder.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    

    /**
     *
     * @param <T>
     * @param requestParam
     * @param folderDashSearch
     * @param classOfT
     * @return
     */
    public <T> T setServerRequest(RequestParam requestParam, FolderDashboardTpl folderDashSearch, Class<T> classOfT){
        try{
            JsonElement createServerRequest = grafanaAPI.getServerConnection().createServerRequest(
                    getBuildedSearchUrl(requestParam, folderDashSearch).replace(" ", "%20"),
                    requestParam.getMethode(),
                    authentication
            );
            return gson.fromJson(createServerRequest, classOfT);
        }catch(NullPointerException ex){
            Logger.getLogger(RequestBuilder.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    private String getBuildedSearchUrl(RequestParam requestParam, FolderDashboardTpl folderDashSearch){
        LinkedList<String> urlParamList = new LinkedList();
        if(folderDashSearch.getQuery() != null && !folderDashSearch.getQuery().isEmpty()){
            urlParamList.add(
                    requestParam.getURLParameters().getQuery()
                    + folderDashSearch.getQuery()
            ); 
        }
        if(!folderDashSearch.getTags().isEmpty()){
            folderDashSearch.getTags().stream().forEach((item) -> {
                if(!item.isEmpty()){
                    urlParamList.add(requestParam.getURLParameters().getTag() + item);
                }
            });  
        }
        if(folderDashSearch.getType() != null && !folderDashSearch.getType().isEmpty()){
            urlParamList.add(
                    requestParam.getURLParameters().getType()
                    + folderDashSearch.getQuery()
            );
        }
        if(!folderDashSearch.getDashboardIds().isEmpty()){
            folderDashSearch.getDashboardIds().stream().forEach((item) -> {
                if(!item.isEmpty()){
                    urlParamList.add(requestParam.getURLParameters().getDashboardIds() + item);
                }
            }); 
        }
        if(!folderDashSearch.getFolderIds().isEmpty()){
            folderDashSearch.getFolderIds().stream().forEach((item) -> {
                if(!item.isEmpty()){
                    urlParamList.add(requestParam.getURLParameters().getFolderIds() + item);
                }
            }); 
        }
        if(folderDashSearch.getStarred() != null){
            urlParamList.add(
                    requestParam.getURLParameters().getStarred()
                    +folderDashSearch.getStarred().toString()
            );
        }
        if(folderDashSearch.getLimit() != null){
            urlParamList.add(
                    requestParam.getURLParameters().getLimit()
                    + folderDashSearch.getLimit().toString()
            );
        }
        return String.join("&", urlParamList);
    }
    
    
}
