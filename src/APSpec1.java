import java.util.Random;

public class APSpec1 {
	private static class carDriver extends Thread {
		private Grid grid;
		private carController c;
		private Random rand;
		private int nsStart, ewStart, speed,
		carSwitch, drive, nsCurrent, ewCurrent;
		private String nsIcon, ewIcon;
		private boolean stop, traffic, spaceForCar;
		private northSouth _ns;
		private eastWest _ew;

		public carDriver(Grid g, carController _c) {
			this.grid = g;
			this.c = _c;
			rand = new Random();
			speed = 0;
			carSwitch = 0;
			drive = 0;
			nsCurrent = 0;
			ewCurrent = 0;
			nsStart = 0;
			ewStart = 0;
			nsIcon = "";
			ewIcon = "";
			stop = false;
			traffic = false;
			spaceForCar = false;
		}

		public boolean controlTraffic() {
			traffic = c.checkTrafficOK();
			return traffic;
		}

		public void generateCar() {
			carSwitch = rand.nextInt(2);
			if (carSwitch == 1) {
				_ns = new northSouth();
				nsIcon = _ns.getIcon();
			}
			else
			{
				_ew = new eastWest();
				ewIcon = _ew.getIcon();
			}
		}

		// make car drive until off grid but implement speeds
		public void drive() {

		}

		public void run() {
			synchronized(this) {
				while(traffic)
				{
					try 
					{
						generateCar();
						drive();
						Thread.currentThread().sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int ROWS = 10, COLUMNS = 20;
		Grid g = new Grid(ROWS, COLUMNS);
		g.setGrid();
		Thread t = new Thread(g);
		t.start();
	}

}
