
public class CarDriver implements Runnable {
	private CarGenerator cGen;
	private Grid grid;
	private Car car;
	private northSouth ns;
	private eastWest ew;
	boolean stop;

	public CarDriver(CarGenerator c, Grid g) {
		cGen = c;
		grid = g;
		stop = false;
	}


	public void drive() {
//		synchronized (this) {
			if (cGen.generateCar()==true)
			{
				ns = new northSouth();
				grid.driveNS(ns);
			}
			else 
			{
				ew = new eastWest();
				grid.driveEW(ew);
			}
		}
//	}

	@Override
	public void run() {
//		synchronized(this) {
			while(!stop)
			{
			drive();
			try {
				Thread.currentThread().sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
//}
