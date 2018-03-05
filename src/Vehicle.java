
public abstract class Vehicle {
	private String type;
	private int size;

	public Vehicle () {
		type = "";
		size = 0;
	}
	
	public Vehicle(String t, int s) {
		type = t;
		size = s;
	}

	public void setType(String t) {
		type = t;
	}

	public String getType() {
		return type;
	}
	
	public void setSize(int s) {
		size = s;
	}
	
	public int getSize() {
		return size;
	}
}
