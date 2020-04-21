
package org.grafana.api.responses.Dashboard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.grafana.api.templates.Dashboard.DashboardTpl;

/**
 *
 * @author jh
 */
public class DashboardRsp {

    @SerializedName("dashboard")
    @Expose
    private DashboardTpl dashboard;
    @SerializedName("meta")
    @Expose
    private MetaRsp meta;

    /**
     *
     * @return DashboardTpl
     */
    public DashboardTpl getDashboard() {
        return dashboard;
    }

    /**
     *
     * @return MetaRsp
     */
    public MetaRsp getMeta() {
        return meta;
    }

}
