package org.grafana.api.templates.Charts;

import org.grafana.api.templates.Dashboard.Panel.PanelTpl;
import org.grafana.api.templates.Dashboard.Panel.Pconfig.Layout.AxisTpl;
import org.grafana.api.templates.Dashboard.Panel.Pconfig.PconfigLayoutTpl;
import org.grafana.api.templates.Dashboard.Panel.Pconfig.PconfigSettingsTpl;
import org.grafana.api.templates.Dashboard.Panel.Pconfig.Traces.TraceMappingTpl;
import org.grafana.api.templates.Dashboard.Panel.Pconfig.TracesTpl;
import org.grafana.api.templates.Dashboard.Panel.PconfigTpl;
import org.grafana.api.templates.Dashboard.Panel.TargetsTpl;

import java.util.ArrayList;

public class PlotlyPanelChart extends PanelTpl {
    ArrayList<TracesTpl> listofTraces;
    ArrayList<TargetsTpl> listofTargets;
    public PlotlyPanelChart(){
        super();
        this.setType("natel-plotly-panel"); //Choosing type of plugin
        listofTraces = new ArrayList<>();
        listofTargets = new ArrayList<>();
    }

    public void setPconfig(String xtitle,String ytitle,String charttype) {

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
        pconfigSettingsTpl.setType(charttype);

        //Passing layout,settings,traces to pconfig object
        PconfigTpl pconfigTpl = this.getPconfig();
        pconfigTpl.setLayout(pconfigLayoutTpl);
        pconfigTpl.setSettings(pconfigSettingsTpl);
        this.setPconfig(pconfigTpl);
    }
    public void setTraces(String xmapping,String ymapping){
        PconfigTpl pconfigTpl = this.getPconfig();

        //Creating a mapping with axes to metrics
        TraceMappingTpl traceMappingTpl = new TraceMappingTpl();
        traceMappingTpl.setX(xmapping);
        traceMappingTpl.setY(ymapping);

        //Creating a trace and passing the mapping object
        TracesTpl tracesTpl = new TracesTpl();
        tracesTpl.setMapping(traceMappingTpl);
        this.listofTraces.add(tracesTpl);
        pconfigTpl.setTraces(this.listofTraces);
        this.setPconfig(pconfigTpl);
    }
    public void setTargets(String query){

        //Creating a target object which takes in an sql query
        TargetsTpl targetsTpl = new TargetsTpl(query);
        this.listofTargets.add(targetsTpl);
        this.setTargets(listofTargets);
    }
}
