package vendingMachineAct;

import java.util.Scanner;

public class Technician extends Person{
	static Scanner input = new Scanner(System.in);
	static private int count = 0;
	private int id;
	private Drink[] pallete;

	public Technician(String n) {
		super(n, 0);
	}
	
	public Drink[] getPallete() {
		return pallete;
	}

	public void setPallete(Drink[] pallete) {
		this.pallete = pallete;
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
	
	public void collectCoins() {
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

	public static void technicianScreen() {
		char selection;

		do {
			System.out.println("[1] Log in as a technician");
			System.out.println("[2] Exit technician mode");
			System.out.print(" >> ");

			selection = input.nextLine().toLowerCase().charAt(0);
			System.out.println();

			switch (selection) {
				case '1':
					// technician mode
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
}
