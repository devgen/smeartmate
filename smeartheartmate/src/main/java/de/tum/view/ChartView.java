package de.tum.view;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.sound.sampled.Line;

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
	private LineChartModel metabolismModel;
	private LineChartModel multiAxisModel;
	private LineChartModel stepsModel;
	private String[] heartData;

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
	
	public LineChartModel getMetabolismModel() {
		return metabolismModel;
	}
	
	public LineChartModel getStepsModel(){
		return stepsModel;
	}

	private Integer[] getHeartRate() {
		return new Integer[] { 64, 64, 64, 63, 64, 62, 63, 64, 64, 64, 64, 62, 63, 62, 64, 62, 64, 63, 62, 64, 64, 62,
				63, 63, 63, 63, 64, 62, 63, 64, 62, 72, 68, 70, 78, 82, 83, 78, 66, 78, 66, 68, 87, 71, 76, 94, 92, 76,
				64, 64, 62, 63, 63, 63, 63, 64, 66, 81, 71, 77, 99, 79, 80, 79, 77, 77, 68, 77, 77, 77, 74, 74, 64, 64,
				62, 63, 63, 63, 63, 64, 66, 79, 82, 72, 77, 68, 97, 73, 79, 77, 77, 72, 83, 100, 81, 81, 64, 64, 62, 63,
				63, 63, 63, 64, 66, 67, 77, 77, 70, 77, 99, 77, 77, 77, 86, 77, 75, 99, 77, 77, 64, 64, 62, 63, 63, 63,
				63, 64, 66, 89, 82, 74, 87, 85, 100, 92, 89, 80, 75, 85, 77, 74, 69, 77, 64, 64, 62, 63, 63, 63, 63, 64,
				66, 76, 87, 77, 77, 78, 82, 77, 68, 78, 83, 83, 82, 78, 77, 76, 64, 64, 62, 63, 63, 63, 63, 64, 66, 77,
				79, 89, 88, 95, 72, 78, 77, 76, 84, 67, 99, 91, 69, 87, 64, 64, 62, 63, 63, 63, 63, 64, 66, 70, 77, 71,
				77, 86, 77, 73, 77, 77, 77, 81, 83, 73, 89, 86, 64, 64, 62, 63, 63, 63, 63, 64, 66, 77, 77, 67, 67, 75,
				77, 66, 70, 77, 77, 71, 71, 77, 70, 77, 64, 64, 62, 63, 63, 63, 63, 64, 66, 77, 71, 87, 80, 77, 67, 94,
				77, 77, 77, 79, 77, 77, 71, 77, 64, 64, 62, 63, 63, 63, 63, 64, 66, 71, 77, 77, 69, 77, 77, 77, 77, 73,
				75, 77, 77, 77, 77, 87, 64, 64, 62, 63, 63, 63, 63, 64, 66, 98, 76, 79, 77, 79, 66, 77, 74, 78, 93, 71,
				82, 77, 74, 99, 64, 64, 62, 63, 63, 63, 63, 64, 66, 66, 77, 74, 73, 78, 84, 77, 77, 77, 74, 76, 79, 70,
				66, 72, 64, 64, 62, 63, 63, 63, 63, 64, 66, 75, 84, 76, 76, 78, 68, 69, 79, 84, 74, 88, 76, 83, 78, 76,
				64, 64, 62, 63, 63, 63, 63, 64, 66, 68, 73, 97, 81, 99, 82, 73, 71, 78, 76, 87, 76, 70, 76, 87, 64, 64,
				62, 63, 63, 63, 63, 64, 66, 93, 68, 73, 79, 75, 76, 76, 76, 76, 68, 74, 95, 83, 98, 76, 64, 64, 62, 63,
				63, 63, 63, 64, 66, 97, 98, 96, 76, 72, 72, 70, 67, 72, 72, 81, 83, 72, 68, 67, 64, 64, 62, 63, 63, 63,
				63, 64, 66, 82, 84, 76, 77, 84, 72, 72, 72, 70, 72, 81, 84, 80, 77, 67, 64, 64, 62, 63, 63, 63, 63, 64,
				66, 85, 72, 75, 72, 71, 83, 83, 67, 72, 73, 89, 72, 72, 84, 72, 64, 64, 62, 63, 63, 63, 63, 64, 66, 72,
				83, 72, 72, 77, 72, 66, 71, 79, 72, 73, 84, 77, 68, 81, 64, 64, 62, 63, 63, 63, 63, 64, 66, 99, 99, 70,
				75, 78, 72, 68, 72, 72, 82, 83, 82, 72, 79, 70, 64, 64, 62, 63, 63, 63, 63, 64, 66, 100, 86, 70, 89, 85,
				96, 69, 72, 81, 69, 97, 91, 79, 72, 66, 64, 64, 62, 63, 63, 63, 63, 64, 66, 76, 96, 70, 87, 95, 72, 86,
				72, 72, 82, 70, 80, 66, 72, 72, 64, 64, 62, 63, 63, 63, 63, 64, 66, 97, 72, 72, 72, 66, 88, 72, 74, 76,
				77, 71, 73, 71, 72, 82, 64, 64, 62, 63, 63, 63, 63, 64, 66, 84, 98, 72, 72, 73, 85, 72, 75, 72, 77, 76,
				95, 72, 76, 76, 64, 64, 62, 63, 63, 63, 63, 64, 66, 84, 79, 72, 73, 74, 100, 72, 77, 86, 84, 76, 82, 72,
				77, 78, 64, 64, 62, 63, 63, 63, 63, 64, 66, 94, 67, 79, 72, 67, 100, 73, 84, 72, 80, 72, 82, 72, 67, 77,
				64, 64, 62, 63, 63, 63, 63, 64, 66, 72, 87, 73, 72, 88, 81, 69, 72, 73, 71, 84, 75, 77, 78, 68, 77, 68,
				72, 72, 77, 80, 84, 72, 85, 86, 85, 77, 69, 69, 70, 72, 70, 72, 72, 66, 72, 73, 77, 67 };
	}

	private Integer[] getRestingRate() {
		return new Integer[] { 60, 65, 65, 60, 60, 62, 62, 60, 60, 60, 62, 61, 62, 71, 71, 140, 71, 70, 70, 64, 60, 61,
				61, 60, 60, 60, 61, 60, 61, 61, 60, 62, 62, 63, 62, 64, 63, 62, 62, 62, 63, 63, 62, 63, 63, 64, 62, 63,
				64, 60, 61, 61, 60, 60, 60, 61, 63, 63, 62, 62, 62, 63, 64, 63, 63, 62, 63, 64, 63, 64, 63, 62, 64, 60,
				61, 61, 60, 60, 60, 61, 63, 64, 62, 63, 64, 64, 62, 64, 63, 63, 64, 63, 64, 77, 62, 62, 64, 60, 61, 61,
				60, 60, 60, 61, 63, 63, 62, 62, 63, 62, 73, 64, 62, 64, 63, 64, 63, 63, 64, 62, 64, 60, 61, 61, 60, 60,
				60, 61, 63, 64, 63, 63, 64, 63, 63, 62, 63, 64, 64, 64, 62, 62, 63, 62, 64, 60, 61, 61, 60, 60, 60, 61,
				63, 62, 64, 63, 63, 63, 65, 64, 64, 66, 63, 63, 63, 66, 64, 64, 64, 60, 61, 61, 60, 60, 60, 61, 63, 65,
				65, 64, 64, 66, 64, 63, 65, 66, 63, 63, 64, 65, 63, 63, 64, 60, 61, 61, 60, 60, 60, 61, 63, 65, 65, 63,
				65, 66, 63, 64, 65, 64, 66, 66, 66, 64, 64, 63, 64, 60, 61, 61, 60, 60, 60, 61, 63, 65, 65, 64, 66, 66,
				63, 65, 63, 65, 65, 65, 64, 63, 64, 66, 64, 60, 61, 61, 60, 60, 60, 61, 63, 64, 63, 65, 65, 66, 65, 63,
				66, 66, 64, 63, 63, 63, 65, 63, 64, 60, 61, 61, 60, 60, 60, 61, 63, 65, 65, 64, 63, 64, 63, 64, 65, 64,
				65, 64, 66, 64, 64, 63, 64, 60, 61, 61, 60, 60, 60, 61, 63, 66, 64, 63, 66, 64, 65, 66, 64, 65, 63, 66,
				64, 63, 63, 64, 64, 60, 61, 61, 60, 60, 60, 61, 63, 64, 66, 64, 63, 65, 65, 64, 65, 65, 64, 63, 65, 64,
				63, 65, 64, 60, 61, 61, 60, 60, 60, 61, 63, 66, 66, 64, 65, 66, 66, 64, 65, 66, 63, 65, 65, 66, 64, 66,
				64, 60, 61, 61, 60, 60, 60, 61, 63, 60, 60, 60, 60, 61, 61, 61, 61, 61, 61, 61, 60, 60, 60, 60, 64, 60,
				61, 61, 60, 60, 60, 61, 63, 60, 61, 61, 61, 60, 61, 60, 61, 61, 61, 61, 60, 60, 61, 60, 64, 60, 61, 61,
				60, 60, 60, 61, 63, 61, 60, 61, 61, 60, 60, 60, 60, 60, 61, 61, 61, 61, 60, 61, 64, 60, 61, 61, 60, 60,
				60, 61, 63, 60, 60, 61, 60, 60, 60, 61, 61, 61, 61, 60, 61, 61, 60, 60, 64, 60, 61, 61, 60, 60, 60, 61,
				63, 60, 60, 61, 61, 60, 60, 60, 60, 61, 61, 61, 61, 60, 61, 60, 64, 60, 61, 61, 60, 60, 60, 61, 63, 60,
				60, 61, 60, 60, 61, 60, 61, 61, 61, 60, 60, 60, 61, 60, 64, 60, 61, 61, 60, 60, 60, 61, 63, 60, 61, 61,
				61, 61, 60, 61, 60, 61, 60, 60, 61, 61, 60, 61, 64, 60, 61, 61, 60, 60, 60, 61, 63, 61, 60, 61, 61, 60,
				61, 61, 60, 61, 61, 61, 60, 61, 61, 60, 64, 60, 61, 61, 60, 60, 60, 61, 63, 61, 60, 60, 60, 60, 60, 60,
				60, 60, 60, 60, 60, 61, 61, 61, 64, 60, 61, 61, 60, 60, 60, 61, 63, 60, 61, 61, 60, 61, 60, 60, 60, 60,
				60, 60, 60, 60, 60, 60, 64, 60, 61, 61, 60, 60, 60, 61, 63, 60, 61, 61, 61, 60, 60, 60, 60, 60, 61, 61,
				61, 60, 60, 60, 64, 60, 61, 61, 60, 60, 60, 61, 63, 60, 61, 60, 61, 60, 61, 60, 60, 61, 61, 60, 60, 60,
				60, 61, 64, 60, 61, 61, 60, 60, 60, 61, 63, 60, 61, 60, 61, 61, 61, 60, 61, 60, 61, 60, 61, 60, 60, 61,
				64, 60, 61, 61, 60, 60, 60, 61, 63, 60, 61, 61, 61, 61, 60, 61, 60, 61, 60, 60, 60, 60, 61, 61, 61, 60,
				60, 61, 60, 60, 61, 61, 61, 60, 60, 61, 61, 60, 60, 61, 61, 60, 61, 61, 60, 61, 60, 60 };
	}

	private void createLineModels() {
		lineModel1 = initLinearModel();
		lineModel1.setTitle("Heart rate / Resting heart rate / Activity (hour)");
		lineModel1.setLegendPosition("e");
		Axis yAxis = lineModel1.getAxis(AxisType.Y);
		yAxis.setMin(50);
		yAxis.setMax(90);

		lineModel2 = initCategoryModel();
		lineModel2.setTitle("Heart rate / Resting heart rate / Activity (hour)");
		lineModel2.setLegendPosition("w");
		lineModel2.setShowPointLabels(true);
		lineModel2.getAxes().put(AxisType.X, new CategoryAxis("Day, Hour"));
		Axis xAxis = lineModel2.getAxis(AxisType.X);
		xAxis.setTickAngle(-90);
		yAxis = lineModel2.getAxis(AxisType.Y);
		yAxis.setLabel("Rate");
		yAxis.setMin(50);
		yAxis.setMax(150);
		
	
		metabolismModel = initMetaModel();
		metabolismModel.setTitle("Metabolism");
		metabolismModel.setLegendPosition("w");
		metabolismModel.setShowPointLabels(true);
		metabolismModel.getAxes().put(AxisType.X, new CategoryAxis("Day"));
		xAxis = metabolismModel.getAxis(AxisType.X);
		xAxis.setTickAngle(-90);
		yAxis = metabolismModel.getAxis(AxisType.Y);
		yAxis.setLabel("Calories");
		yAxis.setMin(1700);
		yAxis.setMax(2800);
		
		stepsModel = initStepsModel();
		stepsModel.setTitle("Exercise / Weight");
		stepsModel.setLegendPosition("w");
		stepsModel.setShowPointLabels(true);
		stepsModel.getAxes().put(AxisType.X, new CategoryAxis("Day"));
		xAxis = stepsModel.getAxis(AxisType.X);
		xAxis.setTickAngle(-90);
//		yAxis = stepsModel.getAxis(AxisType.Y);
//		yAxis.setLabel("Steps");
//		yAxis.setMin(2000);
//		yAxis.setMax(11000);

	}
	
	
	
	private LineChartModel initStepsModel() {
		LineChartModel model = new LineChartModel();

		String[] dates = new String[] { "01.05.2017","02.05.2017","03.05.2017","04.05.2017","05.05.2017","06.05.2017","07.05.2017","08.05.2017","09.05.2017","10.05.2017","11.05.2017","12.05.2017","13.05.2017","14.05.2017","15.05.2017","16.05.2017","17.05.2017","18.05.2017","19.05.2017","20.05.2017","21.05.2017","22.05.2017","23.05.2017","24.05.2017","25.05.2017","26.05.2017","27.05.2017","28.05.2017","29.05.2017","30.05.2017"};

		ChartSeries stepSeries = new ChartSeries();
		stepSeries.setLabel("Steps");
		
		Integer[] steps = new Integer[]{10977,6040,8890,4445,8120,10094,3095,5823,6451,10053,9666,6602,3182,10364,8613,8847,8256,2215,5550,8096,8438,7260,4490,8277,7107,9433,2154,6012,10838,10349};

		for (int i = 0; i < dates.length; i++) {
			stepSeries.set(dates[i], steps[i]);
		}
		
		ChartSeries weightSeries = new ChartSeries();
		weightSeries.setLabel("Weight");
		Number[] weight = new Number[]{92.7,92.7,92.7,92.7,92.7,92.6,92.6,92.6,92.6,92.6,92.6,92.6,92.6,92.6,93,93,93,93,93,93,92.8,92.8,92.8,92.8,92.8,92.8,92.8,93.1,93.1,93.1};
		for (int i = 0; i < dates.length; i++) {
			weightSeries.set(dates[i], weight[i]);
		}
		
		weightSeries.setYaxis(AxisType.Y2);

		model.addSeries(stepSeries);
		model.addSeries(weightSeries);
		model.setZoom(true);
		
        Axis yAxis = model.getAxis(AxisType.Y);
        yAxis.setLabel("Steps");
        yAxis.setMin(2000);
        yAxis.setMax(12000);
                 
        Axis y2Axis = new LinearAxis("kg");
        y2Axis.setMin(90);
        y2Axis.setMax(95);
         
        model.getAxes().put(AxisType.Y2, y2Axis);

		return model;
	}

	private LineChartModel initMetaModel() {
		LineChartModel model = new LineChartModel();

		String[] dates = new String[] { "01.05.2017","02.05.2017","03.05.2017","04.05.2017","05.05.2017","06.05.2017","07.05.2017","08.05.2017","09.05.2017","10.05.2017","11.05.2017","12.05.2017","13.05.2017","14.05.2017","15.05.2017","16.05.2017","17.05.2017","18.05.2017","19.05.2017","20.05.2017","21.05.2017","22.05.2017","23.05.2017","24.05.2017","25.05.2017","26.05.2017","27.05.2017","28.05.2017","29.05.2017","30.05.2017"};

		ChartSeries burntSeries = new ChartSeries();
		burntSeries.setLabel("Burnt");
		
		Integer[] burnt = new Integer[]{2334,2377,2552,2697,2368,2467,2373,2495,2340,2652,2663,2487,2303,2613,2559,2686,2385,2331,2391,2589,2531,2459,2388,2318,2353,2659,2592,2333,2481,2393};

		for (int i = 0; i < dates.length; i++) {
			burntSeries.set(dates[i], burnt[i]);
		}

		ChartSeries gainedSeries = new ChartSeries();
		gainedSeries.setLabel("Gained");
		Integer[] gained = new Integer[]{1871,2334,2377,2552,2697,2368,2467,2373,2495,2340,2652,2663,2487,2303,2613,2559,2686,2385,2331,2391,2589,2531,2459,2388,2318,2353,2659,2592,2333,2481,2393,2305,2291,2198,2284,2002,2160,1854,1956,2023,2393,2263,2256,1986,2239,2354,2202,1913,2293,1852,2059,2359,2124,2172,2377,2025,2145,2047,2208,1947};
		for (int i = 0; i < dates.length; i++) {
			gainedSeries.set(dates[i], gained[i]);
		}

		model.addSeries(burntSeries);
		model.addSeries(gainedSeries);
		model.setZoom(true);

		return model;
	}


	private LineChartModel initLinearModel() {
		LineChartModel model = new LineChartModel();

		LineChartSeries series1 = new LineChartSeries();
		series1.setLabel("Heart rate");

		// getHeartDate();
		Integer[] heartRate = getHeartRate();

		String[] dates = new String[] { "01.05.17 00:00", "01.05.17 01:00", "01.05.17 02:00", "01.05.17 03:00",
				"01.05.17 04:00", "01.05.17 05:00", "01.05.17 06:00", "01.05.17 07:00", "01.05.17 08:00",
				"01.05.17 09:00", "01.05.17 10:00", "01.05.17 11:00", "01.05.17 12:00", "01.05.17 13:00",
				"01.05.17 14:00", "01.05.17 15:00", "01.05.17 16:00", "01.05.17 17:00", "01.05.17 18:00",
				"01.05.17 19:00", "01.05.17 20:00", "01.05.17 21:00", "01.05.17 22:00", "01.05.17 23:00",
				"02.05.17 00:00", "02.05.17 01:00", "02.05.17 02:00", "02.05.17 03:00", "02.05.17 04:00",
				"02.05.17 05:00", "02.05.17 06:00", "02.05.17 07:00", "02.05.17 08:00", "02.05.17 09:00",
				"02.05.17 10:00", "02.05.17 11:00", "02.05.17 12:00", "02.05.17 13:00", "02.05.17 14:00",
				"02.05.17 15:00", "02.05.17 16:00", "02.05.17 17:00", "02.05.17 18:00", "02.05.17 19:00",
				"02.05.17 20:00", "02.05.17 21:00", "02.05.17 22:00", "02.05.17 23:00", "03.05.17 00:00",
				"03.05.17 01:00", "03.05.17 02:00", "03.05.17 03:00", "03.05.17 04:00", "03.05.17 05:00",
				"03.05.17 06:00", "03.05.17 07:00", "03.05.17 08:00", "03.05.17 09:00", "03.05.17 10:00",
				"03.05.17 11:00", "03.05.17 12:00", "03.05.17 13:00", "03.05.17 14:00", "03.05.17 15:00",
				"03.05.17 16:00", "03.05.17 17:00", "03.05.17 18:00", "03.05.17 19:00", "03.05.17 20:00",
				"03.05.17 21:00", "03.05.17 22:00", "03.05.17 23:00" };

		for (int i = 0; i < dates.length; i++) {
			series1.set(dates[i], heartRate[i]);
		}

		// LineChartSeries series2 = new LineChartSeries();
		// series2.setLabel("Resting heart rate");
		//
		// series2.set(1, 6);

		model.setZoom(true);
		model.addSeries(series1);

		// model.addSeries(series2);

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

		Integer[] heartRate = getHeartRate();

		String[] dates = new String[] { "01.05.17 00:00", "01.05.17 01:00", "01.05.17 02:00", "01.05.17 03:00",
				"01.05.17 04:00", "01.05.17 05:00", "01.05.17 06:00", "01.05.17 07:00", "01.05.17 08:00",
				"01.05.17 09:00", "01.05.17 10:00", "01.05.17 11:00", "01.05.17 12:00", "01.05.17 13:00",
				"01.05.17 14:00", "01.05.17 15:00", "01.05.17 16:00", "01.05.17 17:00", "01.05.17 18:00",
				"01.05.17 19:00", "01.05.17 20:00", "01.05.17 21:00", "01.05.17 22:00", "01.05.17 23:00",
				"02.05.17 00:00", "02.05.17 01:00", "02.05.17 02:00", "02.05.17 03:00", "02.05.17 04:00",
				"02.05.17 05:00", "02.05.17 06:00", "02.05.17 07:00", "02.05.17 08:00", "02.05.17 09:00",
				"02.05.17 10:00", "02.05.17 11:00", "02.05.17 12:00", "02.05.17 13:00", "02.05.17 14:00",
				"02.05.17 15:00", "02.05.17 16:00", "02.05.17 17:00", "02.05.17 18:00", "02.05.17 19:00",
				"02.05.17 20:00", "02.05.17 21:00", "02.05.17 22:00", "02.05.17 23:00", "03.05.17 00:00",
				"03.05.17 01:00", "03.05.17 02:00", "03.05.17 03:00", "03.05.17 04:00", "03.05.17 05:00",
				"03.05.17 06:00", "03.05.17 07:00", "03.05.17 08:00", "03.05.17 09:00", "03.05.17 10:00",
				"03.05.17 11:00", "03.05.17 12:00", "03.05.17 13:00", "03.05.17 14:00", "03.05.17 15:00",
				"03.05.17 16:00", "03.05.17 17:00", "03.05.17 18:00", "03.05.17 19:00", "03.05.17 20:00",
				"03.05.17 21:00", "03.05.17 22:00", "03.05.17 23:00" };

		ChartSeries heartRateSeries = new ChartSeries();
		heartRateSeries.setLabel("Heart rate");

		for (int i = 0; i < dates.length; i++) {
			heartRateSeries.set(dates[i], heartRate[i]);
		}

		ChartSeries restingRateSeries = new ChartSeries();
		restingRateSeries.setLabel("Resting heart rate");
		Integer[] restingRates = getRestingRate();
		for (int i = 0; i < dates.length; i++) {
			restingRateSeries.set(dates[i], restingRates[i]);
		}

		Integer[] sleepBool = new Integer[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		BarChartSeries sleep = new BarChartSeries();
		sleep.setLabel("Sleep");
		for (int i = 0; i < dates.length; i++) {
			sleep.set(dates[i], sleepBool[i]);
		}

		Integer[] activeBool = new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 150, 0, 0, 150, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 150, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0,
				0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0,
				0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0,
				1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		BarChartSeries activity = new BarChartSeries();
		activity.setLabel("Activity");
		for (int i = 0; i < dates.length; i++) {
			activity.set(dates[i], activeBool[i]);
		}

		sleep.setXaxis(AxisType.X);
		sleep.setYaxis(AxisType.Y2);

		activity.setXaxis(AxisType.X);
		activity.setYaxis(AxisType.Y3);

		model.getAxes().put(AxisType.Y2, new LinearAxis("Sleep"));
		Axis y2Axis = model.getAxis(AxisType.Y2);
		y2Axis.setMin(0);
		y2Axis.setMax(1);

		model.getAxes().put(AxisType.Y3, new LinearAxis("Activity"));
		Axis y3Axis = model.getAxis(AxisType.Y3);
		y3Axis.setMin(0);
		y3Axis.setMax(1);

		model.addSeries(heartRateSeries);
		model.addSeries(restingRateSeries);
		model.addSeries(sleep);
		model.addSeries(activity);
		model.setZoom(true);

		return model;
	}

}