
public class TrafficController {
	private int speedLimit, maxTraffic, traffic;
	boolean trafficCheck;
	Grid grid;
	
	public TrafficController() {
//		grid = g;
		speedLimit = 0;
		maxTraffic = 0;
		traffic = 0;
		trafficCheck = false;
	}
	
	public void setSpeedLimit(int s) {
		speedLimit = s;
	}
	
	public void setMaxTraffic(int mTraffic) {
		maxTraffic = mTraffic;
	}
	
	public void setTraffic(int t) {
		traffic = t;
	}
	
	public int getSpeedLimit() {
		return speedLimit;
	}
	
	public int getMaxTraffic() {
		return maxTraffic;
	}
	
	public int getTraffic() {
		return traffic;
	}
	
	public boolean checkTrafficOK() {
//		traffic = grid.TrafficOnGrid();
		if (traffic>=maxTraffic)
		{
			trafficCheck = false;
		}
		else 
			{
			trafficCheck = true;
			}
		return trafficCheck;
	}
}
