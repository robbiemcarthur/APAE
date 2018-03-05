
public class carController extends TrafficController {
		private int _traffic;
		private final int MAX_TRAFFIC = 50;
		boolean trafficCheck;
		Grid grid;
		
		public carController(Grid g) {
			grid = g;
			this.setMaxTraffic(MAX_TRAFFIC);
			_traffic = 0;
			trafficCheck = false;
		}
		
		public boolean checkTrafficOK() {
			_traffic = grid.TrafficOnGrid();
			if (_traffic>=MAX_TRAFFIC)
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

