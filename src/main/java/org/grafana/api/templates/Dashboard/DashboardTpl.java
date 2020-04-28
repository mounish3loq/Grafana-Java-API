
package org.grafana.api.templates.Dashboard;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.grafana.api.templates.Dashboard.GrafanaPanel.GrafanaBasePanelTpl;
import org.grafana.api.templates.Dashboard.PlotlyPanel.PlotlyPanelTpl;
import org.grafana.api.templates.Dashboard.abstractbasepanel.BasePanelTpl;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jh
 */
public class DashboardTpl {
    /**
     *
     * @return
     */
    public String getUid() {
        return uid;
    }
    /**
     *
     * @param uid
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    @SerializedName("uid")
    @Expose
    private String uid;

    @SerializedName("annotations")
    @Expose
    private AnnotationsTpl annotations;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("editable")
    @Expose
    private Boolean editable;
    @SerializedName("graphTooltip")
    @Expose
    private Integer graphTooltip;
    @SerializedName("id")
    @Expose
    private Object id;
    @SerializedName("links")
    @Expose
    private List<Object> links = new ArrayList<>();
    @SerializedName("panels")
    @Expose
    private ArrayList panels = new ArrayList<>();
    @SerializedName("refresh")
    @Expose
    private Boolean refresh;
    @SerializedName("schemaVersion")
    @Expose
    private Integer schemaVersion;
    @SerializedName("style")
    @Expose
    private String style;
    @SerializedName("tags")
    @Expose
    private List<Object> tags = new ArrayList<Object>();
    @SerializedName("templating")
    @Expose
    private TemplatingTpl templating;
    @SerializedName("time")
    @Expose
    private TimeTpl time;
    @SerializedName("timepicker")
    @Expose
    private TimepickerTpl timepicker;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("version")
    @Expose
    private Integer version;

    /**
     *
     * @return
     */
    public AnnotationsTpl getAnnotations() {
        return annotations;
    }

    /**
     *
     * @param annotations
     */
    public void setAnnotations(AnnotationsTpl annotations) {
        this.annotations = annotations;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public Boolean getEditable() {
        return editable;
    }

    /**
     *
     * @param editable
     */
    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    /**
     *
     * @return
     */
    public Integer getGraphTooltip() {
        return graphTooltip;
    }

    /**
     *
     * @param graphTooltip
     */
    public void setGraphTooltip(Integer graphTooltip) {
        this.graphTooltip = graphTooltip;
    }

    /**
     *
     * @return
     */
    public Object getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Object id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public List<Object> getLinks() {
        return links;
    }

    /**
     *
     * @param links
     */
    public void setLinks(List<Object> links) {
        this.links = links;
    }

    /**
     *
     * @return
     */
    public List<?> getPanels() {
        return panels;
    }

    /**
     *
     * @param panels
     */
    public void setPanels(ArrayList panels) {
        this.panels = panels;
    }
    public void setPanels(BasePanelTpl panel) {
        System.out.println("used basepanel");
        this.panels.add(panel);
    }
    public void setPanels(GrafanaBasePanelTpl panel){
        this.panels.add(panel);
    }

    /**
     *
     * @return
     */
    public Boolean getRefresh() {
        return refresh;
    }

    /**
     *
     * @param refresh
     */
    public void setRefresh(Boolean refresh) {
        this.refresh = refresh;
    }

    /**
     *
     * @return
     */
    public Integer getSchemaVersion() {
        return schemaVersion;
    }

    /**
     *
     * @param schemaVersion
     */
    public void setSchemaVersion(Integer schemaVersion) {
        this.schemaVersion = schemaVersion;
    }

    /**
     *
     * @return
     */
    public String getStyle() {
        return style;
    }

    /**
     *
     * @param style
     */
    public void setStyle(String style) {
        this.style = style;
    }

    /**
     *
     * @return
     */
    public List<Object> getTags() {
        return tags;
    }

    /**
     *
     * @param tags
     */
    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    /**
     *
     * @return
     */
    public TemplatingTpl getTemplating() {
        return templating;
    }

    /**
     *
     * @param templating
     */
    public void setTemplating(TemplatingTpl templating) {
        this.templating = templating;
    }

    /**
     *
     * @return
     */
    public TimeTpl getTime() {
        return time;
    }

    /**
     *
     * @param time
     */
    public void setTime(TimeTpl time) {
        this.time = time;
    }

    /**
     *
     * @return
     */
    public TimepickerTpl getTimepicker() {
        return timepicker;
    }

    /**
     *
     * @param timepicker
     */
    public void setTimepicker(TimepickerTpl timepicker) {
        this.timepicker = timepicker;
    }

    /**
     *
     * @return
     */
    public String getTimezone() {
        return timezone;
    }

    /**
     *
     * @param timezone
     */
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    /**
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     */
    public Integer getVersion() {
        return version;
    }

    /**
     *
     * @param version
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

}
