
public abstract class TrafficController {
	private int speedLimit;
	private int maxTraffic;
	private int trafficCount;
	
	public TrafficController() {
		speedLimit = 0;
		maxTraffic = 0;
		trafficCount = 0;
	}
	
	public void setSpeedLimit(int s) {
		speedLimit = s;
	}
	
	public void setMaxTraffic(int mTraffic) {
		maxTraffic = mTraffic;
	}
	
	public void setTrafficCount(int traffic) {
		trafficCount = traffic;
	}
	
	public int getSpeedLimit() {
		return speedLimit;
	}
	
	public int getMaxTraffic() {
		return maxTraffic;
	}
	
	public int getTrafficCount() {
		return trafficCount;
	}
}
