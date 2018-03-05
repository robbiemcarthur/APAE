import java.util.Random;

public class northSouth extends Car {
	private Random rand = new Random();
	private int speed, start, end;
	private final int[] SPEEDS = {200, 500, 1000, 2000};
	private String icon;

	public northSouth() {
		rand = new Random();
		speed = 0;
		start = 0;
		end = 0;
		icon = "O|";
	}

	public void setIcon() {
		this.setIcon(icon);
	}
	
	public String getIcon() {
		return icon;
	}
	
	public void setStart() {
		start = rand.nextInt(19);
	}
	
	public int getStart() {
		return start;
	}
	
	public void setEnd() {
		end = 9;
	}
	
	public int getEnd() {
		return end;
	}
	
	public void setSpeed() {
		speed = rand.nextInt(3);
		speed = SPEEDS[speed];
	}
	
	public int getSpeed() {
		return speed;
	}
}
