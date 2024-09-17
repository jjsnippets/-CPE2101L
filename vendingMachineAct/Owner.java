package vendingMachineAct;

import java.util.Scanner;

public class Owner extends Person {
	static private int count = 0;
	private String password;
	static Scanner input = new Scanner(System.in);
	
	public Owner(String n, String p) {
		super(n, 0);
		this.setPassword(p);
		Owner.incCount();
	}

	static public int getCount() {
		return count;
	}

	static public void incCount() {
		Owner.count++;
	}

	static public void decCount() {
		Owner.count--;
	}

	public int getCoins() {
		return super.getWallet();
	}

	public void setCoins(int coins) {
		super.setWallet(coins);
	}

	public void incCoins(int coins) {
		super.incWallet(coins);
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

	static public int matchOwner(Owner[] owners, String name) {
		// returns index of owner if found, -1 if not
		int idx = -1;
		for(int i = 0; i < Owner.getCount(); i++) {
			if (owners[i].getName().equalsIgnoreCase(name)) {
				idx = i;
				break;
			}
		}
		return idx;
	}
	
	public int collectProfit(Machine[] machines) {
		String pass;
		int verified, idx, profit;

		idx = Machine.machineMatchMenu(machines, "Name of machine");
		if (idx == -1) return -1;

		System.out.print("Enter password >> ");
		pass = input.nextLine();
		System.out.println();

		verified = machines[idx].passwordCheck(pass);

		if (verified == 1) {
			profit = machines[idx].getProfit();
			this.incCoins(profit);
			System.out.println("Profit of " + profit + " collected!");
			machines[idx].setProfit(0);
			System.out.println();
			return 1;

		} else {
			System.out.println("Incorrect password!");
			System.out.println();
			return -1;
		}
	}

	static public void printOwners(Owner[] owners){
		System.out.println("=== List of Owners ===");
		for(int i = 0; i < Owner.getCount(); i++) {
			System.out.println((i + 1) + ": " + owners[i].getName());
		}

		System.out.println();
	}

	static public void ownerScreen(Owner[] owners, Machine[] machines) {
		int idx;
		char selection;
		
		do {
			System.out.println("### Owner Mode ###");
			System.out.println("[1] Create new owner");
			System.out.println("[2] Log in as an existing owner");
			System.out.println("[3] Exit owner mode");
			System.out.print(" >> ");
			
			selection = input.nextLine().toLowerCase().charAt(0);
			System.out.println();
			
			switch (selection) {
				case '1': // create new owner
					idx = Owner.newOwnerMenu(owners);
					if (idx == -1) break;

					owners[idx].existingOwnerMenu(machines);
					break;

				case '2': // owner mode
					idx = Owner.loginOwnerMenu(owners);
					if (idx == -1) break;

					owners[idx].existingOwnerMenu(machines);
					break;
				
				case '3': // exit owner mode
					break;
					
				default:
					System.out.println("Invalid selection [" + selection + "]!");
					System.out.println();
					break;
					
			} // end switch
		} while (selection != '3');

		System.out.println("Exiting owner mode...");
		System.out.println();

	}

	static public int newOwnerMenu(Owner[] owners) {
		// returns index of new owner if successful, -1 if not

		String name, pass;
		char check;

		System.out.print("Name of new owner >> ");
		name = input.nextLine();

		System.out.print("Set password >> ");
		pass = input.nextLine();
		System.out.println();

		System.out.println("Are you sure with these details?");
		System.out.println("WARNING This action cannot be undone!");
		System.out.println("Name: " + name);
		System.out.println("Password: " + pass);
		System.out.print("(y/n) >> ");

		check = input.nextLine().toLowerCase().charAt(0);
		System.out.println();

		if (check == 'y') {
			owners[Owner.count] = new Owner(name, pass);
			System.out.println("New owner created!");
			System.out.println();

			return Owner.getCount() - 1;

		} else {
			System.out.println("New owner creation cancelled!");
			System.out.println();

			return -1;
		}
	}

	static public int loginOwnerMenu(Owner[] owners){
		// returns index of owner if successful, -1 if not

		String name, pass;
		int idx, verified;
		printOwners(owners);

		System.out.print("Name of owner >> ");
		name = input.nextLine();

		idx = matchOwner(owners, name);

		if (idx == -1) {
			System.out.println("Owner not found!");
			System.out.println();
			return -1;
		}

		System.out.print("Enter password >> ");
		pass = input.nextLine();
		System.out.println();

		verified = owners[idx].passwordCheck(pass);

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

	public int existingOwnerMenu(Machine[] machines) {
		char selection;
		String name = this.getName();
		int idx;
		
		System.out.println("Good day, " + name + "!");
		System.out.println();

		do {
			System.out.println("=== Owner Mode: " + name + " ===");
			System.out.println("You currently have " + this.getCoins() + " as profit.");
			System.out.println("[1] See list of machines");
			System.out.println("[2] Add new machine");
			System.out.println("[3] Enter machine maintenance mode");
			System.out.println("[4] Collect profit from machine");
			System.out.println("[5] Exit as " + name);
			// System.out.println("[x] Remove a machine");
			// System.out.println("[x] See logs of machine");
			// System.out.println("[x] Change password");

			System.out.print(" >> ");

			selection = input.nextLine().charAt(0);
			System.out.println();

			switch(selection) {
				case '1': // see list of machines
					Machine.printMachines(machines);
					break;

				case '2': // create new machine
					idx = Machine.newMachineMenu(machines, new String(name));
					if (idx == -1) break;

					machines[idx].existingMachineMaintainanceMenu();
					break;

				case '3':
					idx = Machine.loginMachineMenu(machines);
					if (idx == -1) break;

					machines[idx].existingMachineMaintainanceMenu();
					break;

				case '4':
					this.collectProfit(machines);
					break;

				case '5':
					break;

				default:
					System.out.println("Invalid selection [" + selection + "]!");
					System.out.println();
					break;
			}
		} while (selection != '5');

		System.out.println("Have a nice day " + name + "!");
		System.out.println();


		return -1;
	}
}