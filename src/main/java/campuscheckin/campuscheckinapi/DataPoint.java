package campuscheckin.campuscheckinapi;

public class DataPoint {
	private String[] x;
	private int[] y;
	
	public DataPoint(String[] labels, int[] averages) {
		this.x = labels;
		this.y = averages;
	}
	
	public String[] getX() {
		return this.x;
	}
	
	public int[] getY() {
		return this.y;
	}
	
}
