package org.grafana.api.octocharts;

import org.grafana.api.GrafanaAPI;
import org.grafana.api.responses.Dashboard.DashboardRsp;
import org.grafana.api.responses.Dashboard.NewCreateUpdateDashboardRsp;
import org.grafana.api.templates.Dashboard.CreateUpdateDashboardTpl;
import org.grafana.api.templates.Dashboard.DashboardTpl;
import org.grafana.api.templates.Dashboard.abstractbasepanel.BasePanelTpl;
import org.grafana.api.templates.Dashboard.variables.CustomVariableTpl;
import org.grafana.api.templates.Dashboard.variables.TemplatingTpl;

import java.time.LocalDateTime;
import java.util.logging.Logger;

public class OctoCreateDashboardVariable {
    static Logger log = Logger.getLogger("myLogger");
    private final String uid;
    private String dashboardTitle;
    private final String workunitName;
    public CustomVariableTpl customVar;

    public OctoCreateDashboardVariable(String dashboardId,String workunitName,String variableName){
        this.uid = dashboardId;
        this.workunitName = workunitName;
        this.customVar = new CustomVariableTpl(variableName);
    }

    public void setVariableOption(String var){
        this.customVar.setOption(var);
    }
    public void publish(){
        this.publish(uid,null,this.customVar,this.workunitName);
    }

    public void publish(String uid, String dashboardtitle, CustomVariableTpl custvar, String workunitName){
        String grafanaserver = System.getenv("GRAFANA_SERVER");
        String grafana_username = System.getenv("GRAFANA_USERNAME");
        String grafana_password = System.getenv("GRAFANA_PASSWORD");
        GrafanaAPI grafanaAPI = new GrafanaAPI(grafanaserver);
        DashboardTpl dashItems;
        DashboardRsp dashboardRsp = grafanaAPI.orgAdminAPI(grafana_username,grafana_password).getDashboardByUid(uid);
        if (dashboardRsp == null){
            dashItems = new DashboardTpl();
            dashItems.setUid(uid);
            if (dashboardtitle == null) {
                LocalDateTime localDt= LocalDateTime.now();
                dashItems.setTitle(workunitName.substring(workunitName.lastIndexOf('.') + 1) +"_"+localDt);
            }else{
                dashItems.setTitle(dashboardtitle);
            }
        }else{
            dashItems = dashboardRsp.getDashboard();
        }
        CreateUpdateDashboardTpl dashTest = new CreateUpdateDashboardTpl();
        TemplatingTpl temp = new TemplatingTpl();
        temp.setAVariable(custvar);
        dashItems.setTemplating(temp);
        dashTest.setDashboard(dashItems);
        NewCreateUpdateDashboardRsp createUpdateDashboard = grafanaAPI.orgAdminAPI(grafana_username,grafana_password).createUpdateDashboard(dashTest);

    }

}
