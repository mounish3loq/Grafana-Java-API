
package org.grafana.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.grafana.api.responses.AdminAPI.OrganisationRsp;
import org.grafana.api.responses.AdminAPI.OrganisationUsersRsp;
import org.grafana.api.responses.Dashboard.DashboardRsp;
import org.grafana.api.responses.Dashboard.DashboardTagRsp;
import org.grafana.api.responses.Dashboard.DeleteDashboardRsp;
import org.grafana.api.responses.Dashboard.HomeDashboardRsp;
import org.grafana.api.responses.Dashboard.NewCreateUpdateDashboardRsp;
import org.grafana.api.responses.DataSource.CreateDataSourceRsp;
import org.grafana.api.responses.Folder.FolderRsp;
import org.grafana.api.responses.MessageRsp;
import org.grafana.api.templates.Dashboard.CreateUpdateDashboardTpl;
import org.grafana.api.templates.DataSource.CreateDataSourceTpl;
import org.grafana.api.templates.Folder.CreateFolderTpl;
import org.grafana.api.templates.Organisation.AddOrgUserTpl;
import org.grafana.api.templates.User.CreateUserInviteTpl;
import java.util.Arrays;
import java.util.LinkedList;
import org.grafana.api.config.RequestParam;
import org.grafana.api.responses.SearchFolderDashboardRsp;
import org.grafana.api.templates.Search.FolderDashboardTpl;

/**
 * Methodes/Requests available form the current user/org context (Api Key)
 *
 * @author Jonathan Hetzer at Schramm und Partner GmbH
 */
public class OrgAdminAPI {

    private final GrafanaAPI grafanaAPI;
    private final Gson gson;
    private final RequestBuilder requestBuilder;

    /**
     *
     * @param grafanaAPI
     */
    public OrgAdminAPI(GrafanaAPI grafanaAPI) {
        this.grafanaAPI = grafanaAPI;
        this.gson = new GsonBuilder().create();
        this.requestBuilder = new RequestBuilder(grafanaAPI);
    }

    /**
     *
     * @param dashUid
     * @return
     */
    public DashboardRsp getDashboardByUid(String dashUid) {
        RequestParam dashboardByUid = grafanaAPI.getConfiguration().getDashboardAPI().getDashboardByUid();
        return requestBuilder.setServerRequest(dashboardByUid, dashUid, DashboardRsp.class);
    }

    /**
     * Grafana Doc not complete. Manually added "redirectUri" property to response message
     *
     * @return
     */
    public HomeDashboardRsp getDashboardHome() {
        RequestParam dashboardHome = grafanaAPI.getConfiguration().getDashboardAPI().getDashboardHome();
        return requestBuilder.setServerRequest(dashboardHome, HomeDashboardRsp.class);
    }

    /**
     *
     * @return
     */
    public LinkedList<DashboardTagRsp> getDashboardTags() {
        RequestParam dashboardTag = grafanaAPI.getConfiguration().getDashboardAPI().getDashboardTags();
        return (new LinkedList(Arrays.asList(requestBuilder.setServerRequest(dashboardTag, DashboardTagRsp[].class))));
    }

    /**
     *
     * @param json
     * @return
     */
    public CreateDataSourceRsp createDataSource(String json) {
        return createDataSourceExtented(json);

    }

    /**
     *
     * @param dataSourceObj
     * @return
     */
    public CreateDataSourceRsp createDataSource(CreateDataSourceTpl dataSourceObj) {
        return createDataSourceExtented(gson.toJson(dataSourceObj));
    }

    /**
     *
     * @param json
     * @return
     */
    private CreateDataSourceRsp createDataSourceExtented(String json) {
        RequestParam createDataSource = grafanaAPI.getConfiguration().getDataSourceAPI().getCreateDataSource();
        return requestBuilder.setServerRequest(createDataSource, CreateDataSourceRsp.class, json);
    }

    /**
     *
     * @param json
     * @return
     */
    public NewCreateUpdateDashboardRsp createUpdateDashboard(String json) {
        return createUpdateDashboardExtented(json);

    }

    /**
     *
     * @param dashbordObj
     * @return
     */
    public NewCreateUpdateDashboardRsp createUpdateDashboard(CreateUpdateDashboardTpl dashbordObj) {
        return createUpdateDashboardExtented(gson.toJson(dashbordObj));
    }

    /**
     *
     * @param json
     * @return
     */
    private NewCreateUpdateDashboardRsp createUpdateDashboardExtented(String json) {
        RequestParam createUpdateDashboard = grafanaAPI.getConfiguration().getDashboardAPI().getCreateUpdateDashboard();
        return requestBuilder.setServerRequest(createUpdateDashboard, NewCreateUpdateDashboardRsp.class, json);
    }

    /**
     *
     * @param dashUid
     * @return
     */
    public DeleteDashboardRsp deleteDashboardByUid(String dashUid) {
        RequestParam deleteDashboardByUid = grafanaAPI.getConfiguration().getDashboardAPI().getDeleteDashboardByUid();
        return requestBuilder.setServerRequest(deleteDashboardByUid, dashUid, DeleteDashboardRsp.class);
    }
    
    /**
     *
     * @return
     */
    public LinkedList<OrganisationRsp> getCurrOrgList(){
        RequestParam currorgList = grafanaAPI.getConfiguration().getCurrOrganisationAPI().getCurrOrgList();
        return (new LinkedList(Arrays.asList(requestBuilder.setServerRequest(currorgList, OrganisationRsp[].class))));
    }

    /**
     *
     * @return
     */
    public LinkedList<OrganisationUsersRsp> getCurrOrgUsers(){
        RequestParam currOrgUsers = grafanaAPI.getConfiguration().getCurrOrganisationAPI().getCurrOrgUsers();     
        return (new LinkedList(Arrays.asList(requestBuilder.setServerRequest(currOrgUsers, OrganisationUsersRsp[].class))));
    }

    /**
     *
     * @param json
     * @return
     */
    public MessageRsp addOrgCurrUser(String json){
        return addOrgCurrUserExtented(json);
    }

    /**
     *
     * @param json
     * @return
     */
    public MessageRsp addOrgCurrUser(AddOrgUserTpl json){
        return addOrgCurrUserExtented(gson.toJson(json));
    }
    private MessageRsp addOrgCurrUserExtented(String json){
        RequestParam addOrgCurrUser = grafanaAPI.getConfiguration().getCurrOrganisationAPI().getAddOrgCurrUser();
        return requestBuilder.setServerRequest(addOrgCurrUser, MessageRsp.class, json);
    }
    
    /**
     *
     * @param userID
     * @return
     */
    public MessageRsp deleteCurrOrgUserByID(String userID){
        RequestParam deleteCurrOrgUserByID = grafanaAPI.getConfiguration().getCurrOrganisationAPI().getDeleteCurrOrgUserByID();
        return requestBuilder.setServerRequest(deleteCurrOrgUserByID, userID, MessageRsp.class);
    }

    /**
     *
     * @return
     */
    public LinkedList<FolderRsp> getFolderList(){
        RequestParam folderList = grafanaAPI.getConfiguration().getFolderAPI().getFolderList();
        return (new LinkedList(Arrays.asList(requestBuilder.setServerRequest(folderList, FolderRsp[].class))));
    }
    
    /**
     *
     * @param folderUid
     * @return
     */
    public FolderRsp getFolderByUid (String folderUid){
        RequestParam folderByUid = grafanaAPI.getConfiguration().getFolderAPI().getFolderByUid();
        return requestBuilder.setServerRequest(folderByUid, folderUid, FolderRsp.class);
    }

    /**
     *
     * @param folderID
     * @return
     */
    public FolderRsp getFolderByID (String folderID){
        RequestParam folderByID = grafanaAPI.getConfiguration().getFolderAPI().getFolderByID();
        return requestBuilder.setServerRequest(folderByID, folderID, FolderRsp.class);
    }

    /**
     *
     * @param json
     * @return
     */
    public FolderRsp createFolder(String json) {
        return createFolderExtented(json);

    }

    /**
     *
     * @param folderObj
     * @return
     */
    public FolderRsp createFolder(CreateFolderTpl folderObj) {
        return createFolderExtented(gson.toJson(folderObj));
    }

    /**
     *
     * @param json
     * @return
     */
    private FolderRsp createFolderExtented(String json) {
        RequestParam createFolder = grafanaAPI.getConfiguration().getFolderAPI().getCreateFolder();
        return requestBuilder.setServerRequest(createFolder, FolderRsp.class, json);
    }
    
    /**
     *
     * @param userInviteObj
     * @return
     */
    public MessageRsp createUserInvite(CreateUserInviteTpl userInviteObj){
        return createUserInviteExtented(gson.toJson(userInviteObj));
    }

    /**
     *
     * @param json
     * @return
     */
    public MessageRsp createUserInvite(String json){
        return createUserInviteExtented(json);
    }
    
    private MessageRsp createUserInviteExtented(String json){
        RequestParam createUserInvite = grafanaAPI.getConfiguration().getExperimental().getCreateUserInvite();
        return requestBuilder.setServerRequest(createUserInvite, MessageRsp.class, json);
    }

    /**
     *
     * @param folderDashSearch
     * @return
     */
    public LinkedList<SearchFolderDashboardRsp> searchFolderDashboard(FolderDashboardTpl folderDashSearch){
        return searchFolderDashboardExtented(folderDashSearch);
    }

    /**
     *
     * @param json
     * @return
     */
    public LinkedList<SearchFolderDashboardRsp> searchFolderDashboard(String json){
        return searchFolderDashboardExtented(gson.fromJson(json, FolderDashboardTpl.class));
    }

    private LinkedList<SearchFolderDashboardRsp> searchFolderDashboardExtented(FolderDashboardTpl folderDashSearch){
        RequestParam searchGrafana = grafanaAPI.getConfiguration().getFolderDashboardSearchAPI().getSearchGrafana();
        return (new LinkedList(Arrays.asList(requestBuilder.setServerRequest(searchGrafana, folderDashSearch, SearchFolderDashboardRsp[].class))));
    }
}
