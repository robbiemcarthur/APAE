import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Grid implements Runnable {

	private String[][] grid;
	private String cell, vehicle;
	private final String divider = "-";
	private int startPos, endPos, current, r, c, traffic;
	private boolean stop, occupied;

	public Grid(int rows, int columns) {
		grid = new String [rows][columns];
		r = rows;
		c = columns;
		cell = "";
		vehicle = "";
		startPos = 0;
		endPos = 0;
		current = 0;
		stop = false;
		occupied = false;
	}

	// must be called before checkOccupied so cell has correct val assigned
	public void setGrid() {
		cell = " |";
		for (int i = 0; i < r; i++)
		{
			for (int j = 0; j < c; j++)
			{
				grid[i][j] = cell;
			}
		}
	}

	public String[][] getGrid () {
		return grid;
	}

	public String resetCell() {
		cell = " |";
		return cell;
	}

	public boolean checkOccupied(int a, int b) {
		occupied = false;
		if (!grid[a][b].equals(cell))
		{
			occupied = true;
		}
		return occupied;
	}



	public void addEW(eastWest ew) {
		vehicle =ew.getIcon();
		ew.setStart();
		startPos = ew.getStart();
		current = 0;
		endPos = ew.getEnd();
		if (current==endPos)
		{
			grid[startPos][current] = this.resetCell();
		}
		else
		{
			if (current<endPos)
			{
				checkOccupied(startPos, current);
				try
				{
					grid[startPos][current] = vehicle;
					if (grid[startPos][current-1].equals(vehicle) || grid[startPos][current-1].equals("-|"))
					{
						grid[startPos][current-1] = this.resetCell();
					}
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
				}
			}
		}
	}

	public void addNS(northSouth ns) {
		vehicle = ns.getIcon();
		startPos = ns.getStart();
		current = 0;
		endPos = ns.getEnd();
		if (current==endPos)
		{
			grid[current][startPos] = this.resetCell();
		}
		else
		{
			if (current<endPos)
			{
				checkOccupied(current, startPos);
				try
				{
					grid[current][startPos] = vehicle;
					if (grid[current-1][startPos].equals(vehicle) || grid[startPos][current-1].equals("-|"))
					{
						grid[current-1][startPos] = this.resetCell();
					}
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
				}
			}
		}
	}

	public int TrafficOnGrid () {
		for (int i = 0; i < r; i++)
		{
			for (int j = 0; j < c; j++)
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
		for (int i = 0; i < (c*2+1); i++)
		{
			System.out.print(divider);
		}
	}


	public void drawGrid(int x) {
		synchronized(this) {
			System.out.print("\n");
			this.drawDivide();
			for (int l = 0; l < r; l++)
			{
				System.out.print("\n|");
				try
				{
					for (int j = 0; j < c; j++)
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

	public void run() {
		// TODO Auto-generated method stub
		while(!stop)
		{
			try {
				drawGrid(2000);
				Thread.currentThread().sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}

