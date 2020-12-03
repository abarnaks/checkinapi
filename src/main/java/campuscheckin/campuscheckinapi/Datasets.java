package campuscheckin.campuscheckinapi;

import java.util.Map;

public class Datasets {
	private String[] labels;
	private Long[] data;
	private Map<String,Long> datapoint;
	
	public Datasets(String[] labels, Long[] time) {
		this.labels = labels;
		this.data = time;
		for(int i = 0; i<labels.length; i++) {
			this.datapoint.put(labels[i], time[i]);
		}
	}
	
	public Long[] getData() {
		return this.data;
	}
	
	public String[] getLabels() {
		return this.labels;
	}
	
	public Map<String,Long> getdata() {
		return this.datapoint;
	}
	
	
}
