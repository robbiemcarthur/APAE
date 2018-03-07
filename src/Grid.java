import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Grid implements Runnable {

	private String[][] grid;
	private String cell, vehicle;
	private final String divider = "-";
	private int startPos, endPos, current, rows, columns, traffic;
	private boolean stop, occupied;
	private ReentrantLock trafficLock;
	private Condition notOccupied;

	public Grid(int r, int c) {
		rows = r;
		columns = c;
		grid = new String [rows][columns];
		cell = " |";
		vehicle = "";
		startPos = 0;
		endPos = 0;
		current = 0;
		stop = false;
		occupied = false;
		setGrid(rows, columns);
		trafficLock = new ReentrantLock();
		notOccupied = trafficLock.newCondition();
	}

	// must be called before checkOccupied so cell has correct val assigned
	public void setGrid(int r, int c) {
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < columns; j++)
			{
				grid[i][j] = cell;
			}
		}
	}

	public String[][] getGrid () {
		return grid;
	}

	public void setCell(String s)
	{
		cell = s;
	}
	public String getCell() {;
	return cell;
	}

	public void setVehicleImage(String v) {
		vehicle = v+"|";
	}

	public String getVehicleImage() {
		return vehicle;
	}

	public boolean checkOccupied(int a, int b) {
		synchronized(this) {
			notOccupied.signalAll();;
			occupied = false;
			if (!grid[a][b].equals(cell))
			{
				occupied = true;
				trafficLock.lock();
				try {
					notOccupied.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					trafficLock.unlock();
				}
			}
			return occupied;
		}
	}

	public synchronized void driveEW(eastWest ew) {
		vehicle =ew.getIcon();
		ew.setStart();
		startPos = ew.getStart();
		ew.setEnd();
		endPos = ew.getEnd();

		for(current = 0;current<endPos+1;current++)
		{
			try {
				Thread.sleep(200);
				trafficLock.notifyAll();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(current!=endPos)
				checkOccupied(startPos, current);
			try
			{
				grid[startPos][current] = vehicle;
				if (grid[startPos][current-1].equals(vehicle) || grid[startPos][current-1].equals("-|"))
				{
					grid[startPos][current-1] = this.getCell();
				}
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
			}
		}
		grid[startPos][endPos-1] = this.getCell();
	}




	public synchronized void driveNS(northSouth ns) {
		vehicle = ns.getIcon();
		ns.setStart();
		startPos = ns.getStart();
		current = 0;
		ns.setEnd();
		endPos = ns.getEnd();
		for(current = 0;current<endPos+1;current++)
		{
			try {
				Thread.sleep(200);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (current!=endPos)
				checkOccupied(current, startPos);
			while(occupied)
			{
				checkOccupied(current, startPos);
				trafficLock.lock();
				try {
					notOccupied.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					trafficLock.unlock();
				}
			}
			try
			{
				grid[current][startPos] = vehicle;
				if (grid[current-1][startPos].equals(vehicle) || grid[startPos][current-1].equals("-|"))
				{
					grid[current-1][startPos] = this.getCell();
				}
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				continue;
			}
		}
		grid[endPos-1][startPos] = this.getCell();
	}


	public int TrafficOnGrid () {
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < columns; j++)
			{
				if (grid[i][j].equals(cell))
				{
					traffic++;
				}
			}
		}
		return traffic;
	}

	public void resetTraffic() {
		traffic = 0;
	}


	public void drawDivide() {
		for (int i = 0; i < (columns*2+1); i++)
		{
			System.out.print(divider);
		}
	}


	public void drawGrid(int x) {
		synchronized(this) {
			System.out.print("\n");
			this.drawDivide();
			for (int l = 0; l < rows; l++)
			{
				System.out.print("\n|");
				try
				{
					for (int j = 0; j < columns; j++)
					{
						System.out.print(grid[l][j]);
					}
				}
				catch (IndexOutOfBoundsException e)
				{
					continue;
				}
			}
			System.out.print("\n");
			this.drawDivide();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!stop)
		{
			drawGrid(2000);
			try {
				Thread.currentThread().sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}

