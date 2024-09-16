package vendingMachineAct;

public class Machine {
	private String label, owned;
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

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getOwned() {
		return owned;
	}

	public void setOwned(String owned) {
		this.owned = owned;
	}
}
