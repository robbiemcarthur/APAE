import java.util.ArrayList;

public class Car extends Vehicle {

	private int regNum, check; // make so can't duplicate
	private String type, icon;
	private ArrayList<Integer> carList;

	public Car() {
		type = "";
		icon = "";
		check = 0;
		regNum = 0;
	}

	// GETTERS
	public int getReg() {
		return regNum;
	}
	
	public String getType() {
		return type;
	}
	
	public String getIcon() {
		return icon;
	}
	
	// SETTERS
	public void setReg(int n) {
		regNum = n;
	}
	
	public void setType(String t) {
		type = t;
	}
	
	public void setIcon(String i) {
		icon = i;
	}


}
