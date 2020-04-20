package org.grafana.api.templates.Charts;
import org.grafana.api.templates.Dashboard.Panel.PanelTpl;
import org.grafana.api.templates.Dashboard.Panel.Pconfig.Layout.AxisTpl;
import org.grafana.api.templates.Dashboard.Panel.Pconfig.PconfigLayoutTpl;
import org.grafana.api.templates.Dashboard.Panel.Pconfig.PconfigSettingsTpl;
import org.grafana.api.templates.Dashboard.Panel.Pconfig.TracesTpl;
import org.grafana.api.templates.Dashboard.Panel.PconfigTpl;

import java.util.ArrayList;

public class PlotlyPanelChart extends PanelTpl {
    public PlotlyPanelChart(){
        super();
    }

    public void setPconfig(String xtitle,String ytitle,String charttype, ArrayList<TracesTpl> traceslist) {

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
        PconfigTpl pconfigTpl = new PconfigTpl();
        pconfigTpl.setLayout(pconfigLayoutTpl);
        pconfigTpl.setSettings(pconfigSettingsTpl);
        pconfigTpl.setTraces(traceslist);
        this.setPconfig(pconfigTpl);
    }
}
