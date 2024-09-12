package vendingMachineAct;

public abstract class Person {
	private String name;
	private int wallet;
	
	public Person (String n, int w) {
		this.setName(n);
		this.setWallet(w);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getWallet() {
		return wallet;
	}
	public void setWallet(int wallet) {
		this.wallet = wallet;
	}
}
