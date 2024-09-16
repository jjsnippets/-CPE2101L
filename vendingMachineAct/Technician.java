package vendingMachineAct;

public class Technician extends Person{
	static private int count = 0;
	private int id;
	private Drink[] pallete;

	public Technician(String n) {
		super(n, 0);
	}
	
	public Drink[] getPallete() {
		return pallete;
	}

	public void setPallete(Drink[] pallete) {
		this.pallete = pallete;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	static public int getCount() {
		return count;
	}

	static public void incCount() {
		Technician.count++;
	}

	static public void decCount() {
		Technician.count--;
	}
	
	public void refillInventory() {
		// code
	}
	
	public void collectCoins() {
		// code
	}
	
	public int matchTechnician(Technician[] names, String name) {
		
		int idx = -1;
		for(int i = 0; i < names.length; i++) {
			if (names[i].getName().equalsIgnoreCase(name)) {
				idx = i;
				break;
			}
		}
		
		return idx;
		
		
	}



}
