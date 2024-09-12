package vendingMachineAct;

import java.util.Scanner;
 

public class MainExec {
	static final int MAX_OBJECTS = 30;
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		
		Machine[] machines = new Machine[MAX_OBJECTS];
		Owner[] owners = new Owner[MAX_OBJECTS];
		Technician[] technicians = new Technician[MAX_OBJECTS];
		
		Customer johnDoe = new Customer("jhndoe", 100);
		char mode, selection;
		String username = new String();
		
		do {
			mode = screens();
			
			switch (mode) {
				case 1:
					
					break;
					
				case 2:
					do {
						selection = technicianScreen(technicians.length);
						
						switch (selection) {
							case 1:
								// technician mode
								break;
								
							case 2:
								System.out.println("Leaving technician mode...");
								System.out.println();
								break;
								
							default:
								System.out.println("Invalid selection [" + selection + "]!");
								System.out.println();
								break;
								
						} // end switch
					} while (selection != 2);
					break;
				
				case 3:
					
					break;
					
				case 4:
					break;
					
				default:
					System.out.println("Invalid mode [" + mode + "] selected!");
					System.out.println();
			
			
			} // end switch
			
		} while (mode != 4);
		
		System.out.println("Turning off...");
		System.out.println();
		

	}
	
	// initial screen / change modes screen
	public static char screens() {
		
		System.out.println("Run as:");
		System.out.println("[1] Customer");
		System.out.println("[2] Technician");
		System.out.println("[3] Owner");
		System.out.println("[4] Terminate program");
		System.out.print(" >> ");
		
		char x = input.nextLine().toLowerCase().charAt(0);
		System.out.println();
		
		return x;
	}
	
	public static char technicianScreen(int l) {
		if(l == 0) {
			System.out.println("Warning: No technicians found!");
			System.out.println("To add new technicians, be an owner first");
			System.out.println();
		}
		
		System.out.println("[1] Log in as a technician");
		System.out.println("[2] Exit technician mode");
		System.out.print(" >> ");
		
		char x = input.nextLine().toLowerCase().charAt(0);
		System.out.println();
		
		return x;
	}
	
	public static char ownerScreen(Owner[] owners, Technician[] techs, Machine[] machs) {
		String iName = new String();
		
		System.out.println("[1] Log in as an owner");
		System.out.println("[2] Exit owner mode");
		System.out.print(" >> ");
		
		System.out.println("Enter name: ");
		iName = input.nextLine().strip().toLowerCase();
		
		char x = input.nextLine().toLowerCase().charAt(0);
		System.out.println();
		
		return x;
	}

}
