package org.grafana.api.templates.Charts;

import org.grafana.api.templates.Dashboard.PlotlyPanel.PlotlyPanelTpl;
import org.grafana.api.templates.Dashboard.PlotlyPanel.Pconfig.Layout.AxisTpl;
import org.grafana.api.templates.Dashboard.PlotlyPanel.Pconfig.PconfigLayoutTpl;
import org.grafana.api.templates.Dashboard.PlotlyPanel.Pconfig.PconfigSettingsTpl;
import org.grafana.api.templates.Dashboard.PlotlyPanel.Pconfig.Traces.TraceMappingTpl;
import org.grafana.api.templates.Dashboard.PlotlyPanel.Pconfig.TracesTpl;
import org.grafana.api.templates.Dashboard.PlotlyPanel.PlotlyPconfigTpl;
import org.grafana.api.templates.Dashboard.PlotlyPanel.PlotlyTargetsTpl;

import java.util.ArrayList;
import java.util.List;

public class PlotlyHeatmapPanelChart extends PlotlyPanelTpl {
    ArrayList<TracesTpl> listofTraces;
    public PlotlyHeatmapPanelChart(){
        super();
        this.setType("natel-plotly-panel"); //Choosing type of plugin
        this.listofTraces = new ArrayList<>();
    }

    public void setPconfig(String xtitle,String ytitle) {

        //Setting x axis title
        AxisTpl xaxis = new AxisTpl();
        xaxis.setTitle(xtitle);

        //Setting y axis title
        AxisTpl yaxis = new AxisTpl();
        yaxis.setTitle(ytitle);

        //Passing xaxis and yaxis objects to layout object
        PconfigLayoutTpl pconfigLayoutTpl = new PconfigLayoutTpl();
        pconfigLayoutTpl.setXaxis(xaxis);
        pconfigLayoutTpl.setYaxis(yaxis);

        //Setting type of chart
        PconfigSettingsTpl pconfigSettingsTpl = new PconfigSettingsTpl();
        pconfigSettingsTpl.setType("heatmap");

        //Passing layout,settings,traces to pconfig object
        PlotlyPconfigTpl pconfigTpl = this.getPconfig();
        pconfigTpl.setLayout(pconfigLayoutTpl);
        pconfigTpl.setSettings(pconfigSettingsTpl);
        this.setPconfig(pconfigTpl);
    }
    public void setTraces(String xmapping,String ymapping,String zmapping){
        PlotlyPconfigTpl pconfigTpl = this.getPconfig();

        //Creating a mapping with axes to metrics
        TraceMappingTpl traceMappingTpl = new TraceMappingTpl();
        traceMappingTpl.setX(xmapping);
        traceMappingTpl.setY(ymapping);
        traceMappingTpl.setZ(zmapping);

        //Creating a trace and passing the mapping object
        TracesTpl tracesTpl = new TracesTpl();
        tracesTpl.setMapping(traceMappingTpl);
        this.listofTraces.add(tracesTpl);
        pconfigTpl.setTraces(this.listofTraces);
        this.setPconfig(pconfigTpl);
    }
    public void setTargets(String query){

        //Creating a target object which takes in an sql query
        List<PlotlyTargetsTpl> listofTargets = this.getTargets();
        PlotlyTargetsTpl targetsTpl = new PlotlyTargetsTpl(query);
        targetsTpl.setRefId(String.valueOf(listofTargets.size()));
        listofTargets.add(targetsTpl);
        this.setTargets(listofTargets);
    }
}
