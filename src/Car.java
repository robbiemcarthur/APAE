import java.util.ArrayList;

public class Car extends Vehicle {

	private int regNum; // make so can't duplicate
	private String type, icon;

	public Car() {
		type = "";
		icon = "";
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
