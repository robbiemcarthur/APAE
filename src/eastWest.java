import java.util.Random;

public class eastWest extends Car {
	private Random rand = new Random();
	private int speed, start, end;
	private final int DEFAULT_SPEED = 2;
	private String icon;

	public eastWest() {
		rand = new Random();
		speed = DEFAULT_SPEED;
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
		end = 20;
	}
	public int getEnd() {
		return end;
	}
	
	public void setRandomSpeed() {
		speed = rand.nextInt(4);
	}
	
	public int getSpeed() {
		return speed;
	}
}
