package vendingMachineAct;

import java.util.Scanner;

public class Machine {
	static Scanner input = new Scanner(System.in);
	private static int count = 0;
	private String label, owned, password;
	private Drink[] stock;
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

	public static void printMachines(Machine[] machines) {
		System.out.println("=== List of Machines ===");
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

		System.out.println("=== New Machine ===");
		System.out.print("Machine Name >> ");
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
}
