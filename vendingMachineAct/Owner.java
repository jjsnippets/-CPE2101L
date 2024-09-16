package vendingMachineAct;

import java.util.Scanner;

public class Owner extends Person {
	static private int count = 0;
	private String password;
	static Scanner input = new Scanner(System.in);
	
	public Owner(String n, String p) {
		super(n, 0);
		this.setPassword(p);
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int passwordCheck(String password) {
		if (this.getPassword().equals(password)) return 1;
		return 0;
	}

	static public int matchOwner(Owner[] owners, String name) {
		int idx = -1;
		for(int i = 0; i < Owner.getCount(); i++) {
			if (owners[i].getName().equalsIgnoreCase(name)) {
				idx = i;
				break;
			}
		}
		return idx;
	}
	
	public void collectProfit() {
		// code
	}

	static public void printOwners(Owner[] owners){
		System.out.println("=== List of Owners ===");
		for(int i = 0; i < Owner.getCount(); i++) {
			System.out.println((i + 1) + ": " + owners[i].getName());
		}

		System.out.println();
	}

	static public int newOwnerMenu(Owner[] owners) {

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
			Owner.incCount();
			System.out.println("New owner created!");
			System.out.println();

			return Owner.getCount();

		} else {
			System.out.println("New owner creation cancelled!");
			System.out.println();

			return -1;
		}
	}

	static public int loginOwnerMenu(Owner[] owners){
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
		System.out.println();

		pass = input.nextLine();
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

	static public int existingOwnerMenu(Owner owner, Machine[] machines) {
		char selection;

		System.out.println("Good day, " + owner.getName() + "!");
		System.out.println();

		do {
			System.out.println("[1] See list of machines");
			System.out.println("[2] Add new machine");
			System.out.println("[3] Remove a machine");
			System.out.println("[4] Collect profit from machine");
			System.out.println("[5] Exit as owner.getName()");
			System.out.print(" >> ");
			System.out.println();

			selection = input.nextLine().charAt(0);

			switch(selection) {
				case '1':
					// Machine.printMachines(machines);
					break;

				case '2':
					// Machine.newMachineMenu(machines);
					break;

				case '3':
					// Machine.removeMachineMenu(machines);
					break;

				case '4':
					owner.collectProfit();
					break;

				default:
					System.out.println("Invalid selection [" + selection + "]!");
					System.out.println();
					break;
			}

		// System.out.println("[5] See logs of machine");
		// System.out.println("[6] Change password");
		
		} while (selection != '5');

		System.out.println("Have a nice day " + owner.getName() + "!");
		System.out.println();


		return -1;
	}
}