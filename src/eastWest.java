import java.util.Random;

public class eastWest extends Car {
	private String icon;
	private Random rand = new Random();
	private int speed, start, end;
	private final int[] SPEEDS = {200, 500, 1000, 2000};

	public eastWest() {
		rand = new Random();
		speed = 0;
		start = 0;
		end = 0;
		icon = "-|";
	}

	public void setIcon() {
		this.setIcon(icon);
	}

	public String getIcon() {
		return icon;
	}
	
	public void setStart() {
		start = rand.nextInt(9);
	}
	
	public int getStart() {
		return start;
	}
	
	public void setEnd() {
		end = 19;
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
