package vendingMachineAct;

import java.util.Scanner;

public class Machine {
	static Scanner input = new Scanner(System.in);
	private static int count = 0;
	private int drinkCount = 0;
	private String label, owned, password;
	private Drink[] stock = new Drink[MainExec.MAX_OBJECTS];
	private int coins;

	public Machine(String l, String o, String p) {
		this.setLabel(l);
		this.setOwned(o);
		this.setPassword(p);
		this.setCoins(0);
		Machine.incCount();
	}

	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}

	public static int getCount() {
		return Machine.count;
	}

	public static void incCount() {
		Machine.count++;
	}

	public static void decCount() {
		Machine.count--;
	}
	
	public Drink[] getDrinks() {
		return stock;
	}

	public int getDrinkCount() {
		return drinkCount;
	}

	public void incDrinkCount() {
		this.drinkCount++;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int passwordCheck(String password) {
		// returns 1 if password matches, 0 if not
		if (this.getPassword().equals(password)) return 1;
		return 0;
	}

	public static int matchMachine(Machine[] machines, String label) {
		// returns index of machine if found, -1 if not
		int idx = -1;
		for(int i = 0; i < Machine.getCount(); i++) {
			if (machines[i].getLabel().equalsIgnoreCase(label)) {
				idx = i;
				break;
			}
		}
		return idx;
	}

	public static void printMachines(Machine[] machines) {
		System.out.println("@@@ List of Machines @@@");
		System.out.printf("no %-10s%-10s%-10s\n", "Label", "Owned", "Coins");
		for(int i = 0; i < Machine.getCount(); i++) {
			System.out.printf("%02d %-10s%-10s%-10d\n", (i + 1), machines[i].getLabel(), machines[i].getOwned(), machines[i].getCoins());
		}
		System.out.println();
	}

	public static int newMachineMenu(Machine[] machines, String name){
		String label, pass;
		char check;
		int idx = Machine.getCount();
		if (idx == MainExec.MAX_OBJECTS) {
			System.out.println("Maximum number of machines reached!");
			return -1;
		}

		// System.out.println("=== New Machine ===");
		System.out.print("Name of new machine >> ");
		label = input.nextLine();

		System.out.print("Machine Password >> ");
		pass = input.nextLine();
		System.out.println();

		System.out.println("Are you sure with these details?");
		System.out.println("WARNING This action cannot be undone!");
		System.out.println("Machine Name: " + label);
		System.out.println("Machine Password: " + pass);
		System.out.print("(y/n) >> ");

		check = input.nextLine().charAt(0);
		System.out.println();

		if (check == 'y') {
			machines[idx] = new Machine(label, name, pass);
			System.out.println("Machine created successfully!");
			System.out.println();

			printMachines(machines);
			return idx;

		} else {
			System.out.println("Machine creation cancelled!");
			return -1;

		}
	}

	public static int loginMachineMenu(Machine[] machines){
		// returns index of machine if successful, -1 if not

		String label, pass;
		int idx, verified;
		printMachines(machines);

		System.out.print("Name of machine >> ");
		label = input.nextLine();

		idx = matchMachine(machines, label);

		if (idx == -1) {
			System.out.println("Machine not found!");
			System.out.println();
			return -1;
		}

		System.out.print("Enter password >> ");
		pass = input.nextLine();
		System.out.println();

		verified = machines[idx].passwordCheck(pass);

		if (verified == 1) {
			System.out.println("Login successful!");
			System.out.println();
			return idx;
		} else {
			System.out.println("Incorrect password!");
			System.out.println();
			return -1;
		}
	}

	public void existingMachineMaintainanceMenu() {
		char selection;
		int idx;
		String label = this.getLabel();
		
		do {
			System.out.println("### Maintainance: " + label + " ###");
			System.out.println("[1] See list of drinks");
			System.out.println("[2] Refill inventory of drink");
			System.out.println("[3] Leave " + label);
			System.out.print(" >> ");
			
			selection = input.nextLine().toLowerCase().charAt(0);
			System.out.println();
			
			switch (selection) {
				case '1': // see list of drinks
					Drink.printDrinks(this.getDrinks(), this.getDrinkCount(), label);
					break;
					
				case '2': // refill inventory
					idx = this.refillInventory();
					


					if (idx == -1) break;
					
					// Drink.existingDrinkMenu(machine.showDrinks()[idx]);
					break;
					
				case '3':
					System.out.println("Leaving machine mode...");
					System.out.println();
					break;
					
				default:
					System.out.println("Invalid selection [" + selection + "]!");
					System.out.println();
					break;
					
			} // end switch
		} while (selection != '3');
	}

	public int refillInventory() {
		// refill inventory of drinks

		int idx, drinkCount = this.getDrinkCount();
		String drinkName;
		int amount, price;
		char check;
		Drink[] drinks = this.getDrinks();

		Drink.printDrinks(drinks, drinkCount, this.getLabel());

		System.out.print("Name of drink >> ");
		drinkName = input.nextLine();

		idx = Drink.matchDrinks(drinks, drinkCount, drinkName);

		if (idx == drinkCount){
			System.out.println("Are you sure you want to add a new drink?");
			System.out.print("(y/n) >> ");

			check = input.nextLine().charAt(0);
			System.out.println();

			if (check == 'n') {
				System.out.println("Drink creation cancelled!");
				System.out.println();
				return -1;
			}

			System.out.print("Set price of " + drinkName + " >> ");
			price = input.nextInt();
			System.out.print("Number of " + drinkName + " to stock >> ");
			amount = input.nextInt();
			input.nextLine();
			System.out.println();

			drinks[idx] = new Drink(drinkName, price, amount);
			this.incDrinkCount();

			System.out.println("Added " + drinks[idx].getFullName() + " to " + this.getLabel() + "!");
			System.out.println();

		} else {
			System.out.print("Number of " + drinkName + " to stock >> ");
			amount = input.nextInt();
			input.nextLine();
			System.out.println();

			drinks[idx].setAmount(drinks[idx].getAmount() + amount);
			System.out.println("Refilled " + drinks[idx].getFullName() + " by " + amount + "!");
			System.out.println();
		}
		
		return 1;
	}
}
