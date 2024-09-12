package vendingMachineAct;

public class Technician extends Person{
	private int id;
	private Drink[] pallete;
	
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
	
	public void refillInventory() {
		// code
	}
	
	public void collectCoins() {
		// code
	}



}
