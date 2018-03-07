import java.util.Random;

public class APSpec1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean stop = false;

		// creating CarGenerator object
		CarGenerator c = new CarGenerator();

		// creating Grid object and starting thread to repaint
		final int ROWS = 10, COLUMNS = 20;
		Grid road = new Grid(ROWS, COLUMNS);
		String s = " |";
		road.setCell(s);
		Thread t = new Thread(road);
		t.start();

		// creating arr of threads and CarDriver threads
		Thread[] threads = new Thread[2000];
		CarDriver cDriver = new CarDriver(c, road);

		// creating loop to generate cars to drive on road
		for (int i = 0; i < 5; i++)
		{
			threads[i] = new Thread(cDriver);
			threads[i].start();
		}

		while(!stop)
		{
			for (int i = 0; i < 5; i++)
			{
				try {
					t.join();
					threads[i].join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
