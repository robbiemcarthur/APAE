import java.util.Random;

public class CarGenerator {
	private boolean carSwitch;
	private Random rand;
	private int _switch;

	public CarGenerator() {
		carSwitch = false;
		rand = new Random();
		_switch = 0;
	}

	public boolean generateCar() {
		_switch = rand.nextInt(2);
		if(_switch==1)
		{
			carSwitch = true;
		}
		else 
		{
			carSwitch = false;
		}
		return carSwitch;
	}
}
