package de.tum.view;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.LinearAxis;
import org.primefaces.model.chart.BarChartSeries;

@ManagedBean
public class ChartView implements Serializable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = -6356102226341916730L;
	private LineChartModel lineModel1;
    private LineChartModel lineModel2;
    
    private LineChartModel multiAxisModel;

    @PostConstruct
    public void init() {
        createLineModels();
        createMultiAxisModel();
    }
 
    public LineChartModel getLineModel1() {
        return lineModel1;
    }
 
    public LineChartModel getLineModel2() {
        return lineModel2;
    }
     
    private void createLineModels() {
        lineModel1 = initLinearModel();
        lineModel1.setTitle("Linear Chart");
        lineModel1.setLegendPosition("e");
        Axis yAxis = lineModel1.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);
         
        lineModel2 = initCategoryModel();
        lineModel2.setTitle("Category Chart");
        lineModel2.setLegendPosition("e");
        lineModel2.setShowPointLabels(true);
        lineModel2.getAxes().put(AxisType.X, new CategoryAxis("Years"));
        yAxis = lineModel2.getAxis(AxisType.Y);
        yAxis.setLabel("Births");
        yAxis.setMin(0);
        yAxis.setMax(200);
    }
     
    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();
 
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Series 1");
 
        series1.set(1, 2);
        series1.set(2, 1);
        series1.set(3, 3);
        series1.set(4, 6);
        series1.set(5, 8);
 
        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Series 2");
 
        series2.set(1, 6);
        series2.set(2, 3);
        series2.set(3, 2);
        series2.set(4, 7);
        series2.set(5, 9);
 
        model.addSeries(series1);
        model.addSeries(series2);
         
        return model;
    }
    
    public LineChartModel getMultiAxisModel() {
        return multiAxisModel;
    }
     
    private void createMultiAxisModel() {
        multiAxisModel = new LineChartModel();
 
        BarChartSeries boys = new BarChartSeries();
        boys.setLabel("Steps");
 
        boys.set("2004", 120);
        boys.set("2005", 100);
        boys.set("2006", 44);
        boys.set("2007", 150);
        boys.set("2008", 25);
 
        LineChartSeries girls = new LineChartSeries();
        girls.setLabel("Heart Rate");
        girls.setXaxis(AxisType.X2);
        girls.setYaxis(AxisType.Y2);
         
        girls.set("A", 52);
        girls.set("B", 60);
        girls.set("C", 110);
        girls.set("D", 135);
        girls.set("E", 120);
        
//        LineChartSeries activity = new LineChartSeries();
//        activity.setLabel("Activity");
//        activity.setXaxis(AxisType.X3);
//        activity.setYaxis(AxisType.Y3);
//         
//        activity.set("I", 52);
//        activity.set("II", 60);
//        activity.set("III", 110);
//        activity.set("IV", 135);
//        activity.set("V", 120);
//        multiAxisModel.addSeries(activity);
 
        multiAxisModel.addSeries(boys);
        multiAxisModel.addSeries(girls);
         
        multiAxisModel.setTitle("Multi Axis Chart");
        multiAxisModel.setMouseoverHighlight(false);
         
        multiAxisModel.getAxes().put(AxisType.X, new CategoryAxis("Years"));
        multiAxisModel.getAxes().put(AxisType.X2, new CategoryAxis("Period"));
        multiAxisModel.getAxes().put(AxisType.X3, new CategoryAxis("Activity"));
         
        Axis yAxis = multiAxisModel.getAxis(AxisType.Y);
        yAxis.setLabel("Birth");
        yAxis.setMin(0);
        yAxis.setMax(200);
                 
        Axis y2Axis = new LinearAxis("Number");
        y2Axis.setMin(0);
        y2Axis.setMax(200);
        
        Axis y3Axis = new LinearAxis("Intensity");
        y3Axis.setMin(0);
        y3Axis.setMax(200);
        
        multiAxisModel.getAxes().put(AxisType.Y2, y2Axis);
        multiAxisModel.getAxes().put(AxisType.Y3, y3Axis);

    }
     
    private LineChartModel initCategoryModel() {
        LineChartModel model = new LineChartModel();
 
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Boys");
        boys.set("2004", 120);
        boys.set("2005", 100);
        boys.set("2006", 44);
        boys.set("2007", 150);
        boys.set("2008", 25);
 
        ChartSeries girls = new ChartSeries();
        girls.setLabel("Girls");
        girls.set("2004", 52);
        girls.set("2005", 60);
        girls.set("2006", 110);
        girls.set("2007", 90);
        girls.set("2008", 120);
 
        model.addSeries(boys);
        model.addSeries(girls);
         
        return model;
    }
 
}