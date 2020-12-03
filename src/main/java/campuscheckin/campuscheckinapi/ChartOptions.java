package campuscheckin.campuscheckinapi;

import java.util.Date;

public class ChartOptions {
	private String[] labels;
	private Long[] data;
	private String actions;
	private Datasets dataset;
	private DataPoint[] datapoints;
	
	
	public ChartOptions(String[] labels, Long[] time, String action) {
		this.labels = labels;
		this.data = time;
//		datapoints = new DataPoint[labels.length];
//		
//		for(int i = 0; i<labels.length;i++ ) {
//			datapoints[i] = new DataPoint(labels[i], time[i]);
//		}
		//this.dataset = new Datasets(labels , time);
		this.actions = action;
	}
	
	public Long[] getData() {
		return this.data;
	}
	
//	public Datasets getDataset() {
//		return this.dataset;
//	}
	public String[] getLabels() {
		return this.labels;
	}
	
	public String getActions() {
		return this.actions;
	}
	
//	public DataPoint[] getDataPoints() {
//		return this.datapoints;
//	}
	
	
	
}
