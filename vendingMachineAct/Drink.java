package vendingMachineAct;

public class Drink {
	private String fullName;
	private int price;
	private int amount;
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public static void printDrinks(Drink[] drinks, int count){
		System.out.printf("%20s %10s %10s\n", "Drink", "Price", "Avaialable");
		for(int i = 0; i < count; i++) {
			System.out.printf("%20s %10d %10d\n", drinks[i].getFullName(), drinks[i].getPrice(), drinks[i].getAmount());
		}
	}

	public static int matchDrinks(Drink[] drinks, int count, String name) {
		// returns index of drink if found, provides the next available slot if not
		int idx = 0;
		for(int i = 0; i < count; i++) {
			if (drinks[i].getFullName().equalsIgnoreCase(name)) {
				idx = i;
				break;
			}
		}
		return idx;
	}
}
