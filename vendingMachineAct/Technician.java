package vendingMachineAct;

import java.util.Scanner;

public class Technician extends Person{
	static Scanner input = new Scanner(System.in);
	static private int count = 0;
	private int id;

	public Technician(String n) {
		super(n, 0);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	static public int getCount() {
		return count;
	}

	static public void incCount() {
		Technician.count++;
	}

	static public void decCount() {
		Technician.count--;
	}
	
	public void refillInventory() {
		// code
	}
	
	public int matchTechnician(Technician[] names, String name) {
		
		int idx = -1;
		for(int i = 0; i < names.length; i++) {
			if (names[i].getName().equalsIgnoreCase(name)) {
				idx = i;
				break;
			}
		}
		
		return idx;
	}

	public static void technicianScreen(Machine[] machines) {
		char selection;

		do {
			System.out.println("### Technician Mode ###");
			System.out.println("[1] Log in as a technician");
			System.out.println("[2] Exit technician mode");
			System.out.print(" >> ");

			selection = input.nextLine().toLowerCase().charAt(0);
			System.out.println();

			switch (selection) {
				case '1':
					System.out.print("Enter name >> ");
					String name = input.nextLine();
					System.out.println();
					existingTechnicianMenu(name, machines);
					break;
					
				case '2':
					System.out.println("Leaving technician mode...");
					System.out.println();
					break;
					
				default:
					System.out.println("Invalid selection [" + selection + "]!");
					System.out.println();
					break;
					
			} // end switch
		} while (selection != '2');
	}

	public static int existingTechnicianMenu(String name, Machine[] machines) {
		System.out.println("Welcome " + name + "!");
		System.out.println();

		char selection;
		int idx;
		
		do {
			System.out.println("=== Technician Mode: " + name + " ===");
			System.out.println("[1] See list of machines");
			System.out.println("[2] Refill inventory of machine");
			System.out.println("[3] Exit as " + name);
			System.out.print(" >> ");
			
			selection = input.nextLine().toLowerCase().charAt(0);
			System.out.println();
			
			switch (selection) {
				case '1': // see list of machines
					Machine.printMachines(machines);
					break;
					
				case '2': // refill inventory
					idx = Machine.loginMachineMenu(machines);
					if (idx == -1) break;

					machines[idx].existingMachineMaintainanceMenu();
					break;
					
				case '3': // exit technician mode
					break;
					
				default:
					System.out.println("Invalid selection [" + selection + "]!");
					System.out.println();
					break;
					
			} // end switch
		} while (selection != '3');

		return -1;
	}


}
