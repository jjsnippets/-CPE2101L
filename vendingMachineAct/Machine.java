package vendingMachineAct;

public class Machine {
	private static int count = 0; // total number of machines
	private Drink[] stock = new Drink[MainExec.MAX_OBJECTS]; // list of drinks in a machine
	private int drinkCount = 0; // number of drinks in a machine
	private String label, owned, password;
	private int credit, profit;

	// Machine constructor
	public Machine(String l, String o, String p) {
		this.setLabel(l);
		this.setOwned(o);
		this.setPassword(p);
		this.setCredit(0);
		this.setProfit(0);
		Machine.incCount();
	}

	// accessors and mutators
	public static int getCount() { return Machine.count; }
	public static void incCount() { Machine.count++; }
	public static void decCount() { Machine.count--; }

	public int getCredit() { return this.credit; }
	public void setCredit(int amount) { this.credit = amount; }
	public void incCredit(int amount) { this.credit += amount; }
	public void decCredit(int amount) { this.credit -= amount; }

	public int getProfit() { return this.profit; }
	public void setProfit(int amount) { this.profit = amount; }
	public void incProfit(int amount) { this.profit += amount; }
	
	public Drink[] getStock() { return stock; }
	public int getDrinkCount() { return drinkCount; }
	public void incDrinkCount() { this.drinkCount++; }

	public String getLabel() { return label; }
	public void setLabel(String label) { this.label = label; }

	public String getOwned() { return owned; }
	public void setOwned(String owned) { this.owned = owned; }

	public String getPassword() { return password; }
	public void setPassword(String password) {
		this.password = password;
	}

	public boolean passwordCheck(String password) {
		// [METHOD] returns TRUE if password matches, FALSE otherwise
		if (this.getPassword().equals(password)) return true;
		return false;
	}

	public static void printMachines(Machine[] machines) {
		// [CLI] prints the list of machines
		System.out.println("@@@ List of Machines @@@");
		System.out.printf("no %-10s%-10s%-10s\n", "Label", "Owned", "Profit");
		for(int i = 0; i < Machine.getCount(); i++) {
			System.out.printf("%02d %-10s%-10s%-10d\n", (i + 1), machines[i].getLabel(), machines[i].getOwned(), machines[i].getProfit());
		}
		System.out.println();
	}

	public static int matchMachine(Machine[] machines, String label) {
		// [METHOD] returns index of machine if found, -1 otherwise
		int idx = -1;
		for(int i = 0; i < Machine.getCount(); i++) {
			if (machines[i].getLabel().equalsIgnoreCase(label)) {
				idx = i;
				break;
			}
		}
		return idx;
	}

	public static int matchMachine(Machine[] machines) {
		// [MENU] user interface for matching machines
		// returns index of machine if successful, -1 otherwise
		int idx;
		String label;

		Machine.printMachines(machines);

		System.out.print("Which machine to choose?");
		System.out.print(" >> ");
		label = MainExec.input.nextLine();
		System.out.println();
		idx = matchMachine(machines, label);

		if (idx == -1) {
			System.out.println("Machine not found!");
		}
		System.out.println();

		return idx;
	}

	public static int newMachineMenu(Machine[] machines, String name){
		// [MENU] user interface for creating a new machine
		// returns 0 if success
		String label, pass;
		char check;
		int idx = Machine.getCount();
		if (idx == MainExec.MAX_OBJECTS) {
			System.out.println("Maximum number of machines reached!");
			return -1;
		}

		System.out.print("Name of new machine >> ");
		label = MainExec.input.nextLine();

		System.out.print("Machine Password >> ");
		pass = MainExec.input.nextLine();
		System.out.println();

		System.out.println("Are you sure with these details?");
		System.out.println("WARNING This action cannot be undone!");
		System.out.println("Machine Name: " + label);
		System.out.println("Machine Password: " + pass);
		System.out.print("(y/n) >> ");

		check = MainExec.input.nextLine().charAt(0);
		System.out.println();

		if (check == 'y') {
			machines[idx] = new Machine(label, name, pass);
			System.out.println("Machine " + label + " created successfully!");
			System.out.println();
			return idx;

		} else {
			System.out.println("Machine creation cancelled!");
			return -1;

		}
	}

	public static int loginMachineMenu(Machine[] machines){
		// [MENU] user interface for logging in a machine as maintance
		// returns index of machine if successful, -1 if not
		String pass;
		int idx;

		printMachines(machines);

		idx = matchMachine(machines, "Name of machine");
		if (idx == -1) return -1;

		System.out.print("Enter password >> ");
		pass = MainExec.input.nextLine();
		System.out.println();

		if (machines[idx].passwordCheck(pass)) {
			System.out.println("Login successful!");
			System.out.println();
			return idx;
		} else {
			System.out.println("Incorrect password!");
			System.out.println();
			return -1;
		}
	}

	public void maintananceMenu() {
		// [MENU] user interface for machine maintainance
		char selection;
		String label = this.getLabel();
		
		do {
			System.out.println("### Maintainance: " + label + " ###");
			System.out.println("[1] See list of drinks");
			System.out.println("[2] Refill inventory");
			System.out.println("[3] Change price of drink");
			System.out.println("[4] Leave " + label);
			System.out.print(" >> ");
			
			selection = MainExec.input.nextLine().toLowerCase().charAt(0);
			System.out.println();
			
			switch (selection) {
				case '1': // see list of drinks
					Drink.printDrinks(this.getStock(), this.getDrinkCount(), label);
					break;
					
				case '2': // refill inventory
					this.refillInventory();
					break;
				
				case '3': // Change price of drink
					this.changePriceMenu();
					break;
					
				case '4':
					break;
					
				default:
					System.out.println("Invalid selection [" + selection + "]!");
					System.out.println();
					break;
					
			} // end switch
		} while (selection != '4');

		System.out.println("Leaving machine mode...");
		System.out.println();
	}

	public void refillInventory() {
		// [MENU] refill inventory of drinks
		// returns 0 if successful, -1 otherwise

		int idx, drinkCount = this.getDrinkCount();
		String drinkName;
		int amount, price;
		char check;
		Drink[] drinks = this.getStock();

		Drink.printDrinks(drinks, drinkCount, this.getLabel());

		System.out.print("Name of drink >> ");
		drinkName = MainExec.input.nextLine();

		idx = Drink.matchDrinks(drinks, drinkCount, drinkName);

		if (idx == drinkCount){
			System.out.println("Are you sure you want to add a new drink?");
			System.out.print("(y/n) >> ");

			check = MainExec.input.nextLine().charAt(0);
			System.out.println();

			if (check == 'n') {
				System.out.println("Drink creation cancelled!");
				System.out.println();
				return;
			}

			System.out.print("Set price of " + drinkName + " >> ");
			price = MainExec.input.nextInt();
			System.out.print("Number of " + drinkName + " to stock >> ");
			amount = MainExec.input.nextInt();
			MainExec.input.nextLine();
			System.out.println();

			drinks[idx] = new Drink(drinkName, price, amount);
			this.incDrinkCount();

			System.out.println("Added " + drinks[idx].getFullName() + " to " + this.getLabel() + "!");
			System.out.println();

		} else {
			System.out.print("Number of " + drinkName + " to stock >> ");
			amount = MainExec.input.nextInt();
			MainExec.input.nextLine();
			System.out.println();

			drinks[idx].setAmount(drinks[idx].getAmount() + amount);
			System.out.println("Refilled " + drinks[idx].getFullName() + " by " + amount + "!");
			System.out.println();
		}
	}

	private void changePriceMenu() {
		// [MENU] user interface for changing price of a drink
		// returns index of drink if successful, -1 if not
		
		int idx, drinkCount = this.getDrinkCount();
		String drinkName;
		int price;
		Drink[] drinks = this.getStock();

		Drink.printDrinks(drinks, drinkCount, this.getLabel());

		System.out.print("Name of drink to change price of >> ");
		drinkName = MainExec.input.nextLine();

		idx = Drink.matchDrinks(drinks, drinkCount, drinkName);

		if (idx == drinkCount){
			System.out.println("Drink not found!");
			System.out.println();
			return;
		}

		System.out.print("Set price of " + drinkName + " >> ");
		price = MainExec.input.nextInt();
		MainExec.input.nextLine();
		System.out.println();

		drinks[idx].setPrice(price);
		System.out.println("Changed price of " + drinks[idx].getFullName() + " to " + price + "!");
		System.out.println();
	}

	public void customerMenu(Customer customer) {
		// [MENU] customer facing vending machine menu
		char selection;
		String label = this.getLabel();
		
		do {
			System.out.println("### Vending Machine: " + label + " ###");
			System.out.println("Credits: " + this.getCredit());
			System.out.println("[1] Insert coins");
			System.out.println("[2] View and purchase drinks");
			System.out.println("[3] Withdraw and leave " + label);
			System.out.print(" >> ");
			
			selection = MainExec.input.nextLine().toLowerCase().charAt(0);
			System.out.println();
			
			switch (selection) {
				case '1': // insert coins
					this.insertCoinsMenu(customer);
					break;
					
				case '2': // view and purchase drinks
					this.purchaseDrinksMenu(customer);
					break;
					
				case '3':
					break;
					
				default:
					System.out.println("Invalid selection [" + selection + "]!");
					System.out.println();
					break;
					
			} // end switch
		} while (selection != '3');

		if (this.getCredit() > 0) {
			System.out.println("You withdrew " + this.getCredit() + " and left " + label);
		} else {
			System.out.println("You left " + label);
		}
		System.out.println();

		customer.incWallet(this.getCredit());
		this.decCredit(this.getCredit());
	}

	private void insertCoinsMenu(Customer customer) {
		// [MENU] user interface for inserting coins
		int amount, eCode;
		
		System.out.println("How much coins to insert?");
		System.out.print(" >> ");
		
		amount = MainExec.input.nextInt();
		MainExec.input.nextLine();
		System.out.println();
		
		eCode = customer.insertCoins(this, amount);
		
		if (eCode < 0) {
			System.out.println("You do not have enough money (of " + customer.getWallet() + ")!");
		}
		System.out.println();
	}
	
	private void purchaseDrinksMenu(Customer customer) {
		// [MENU] user interface for purchasing drinks
		int idx, drinkCount = this.getDrinkCount();
		String drinkName;
		int price, credit;
		Drink[] drinks;
		drinkCount = this.getDrinkCount();
		drinks = this.getStock();

		do {
			credit = this.getCredit();

			Drink.printDrinks(drinks, drinkCount, this.getLabel());

			System.out.println("Name of drink to purchase");
			System.out.println("or type \"exit\" to stop purchasing drinks");
			System.out.print(" >> ");
			drinkName = MainExec.input.nextLine();
			System.out.println();
			
			if (drinkName.strip().equalsIgnoreCase("exit")) return; // exit condition

			idx = Drink.matchDrinks(drinks, drinkCount, drinkName);

			if (idx == drinkCount){
				System.out.println("No drinks match your selection!");
				System.out.println();

			} else {
				int stock = drinks[idx].getAmount();
				price = drinks[idx].getPrice();
				
				if (stock == 0) {
					System.out.println("Sorry but " + drinkName + " is out of stock!");
					System.out.println();
					
				} else if (credit < price) {
					System.out.println("Not enough credits (of " + credit + ")!");
					System.out.println();
					
				} else {
					this.dispenseDrink(drinks[idx], customer);
					System.out.println("You took " + drinks[idx].getFullName() + " out of " + this.getLabel() + "!");
					System.out.println();
					this.incProfit(price);
					this.decCredit(price);
					// increment coins
				}
			}

		} while (true); // if (drinkName.strip().equalsIgnoreCase("exit")) return;
	}

	private void dispenseDrink(Drink drink, Customer customer) {
		// [METHOD] dispenses a drink
		drink.decAmount();
	}

}
