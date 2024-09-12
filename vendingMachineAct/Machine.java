package vendingMachineAct;

public class Machine {
	private Drink[] stock;
	private int coins;

	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}
	
	public Drink[] showDrinks() {
		return stock;
	}
}
