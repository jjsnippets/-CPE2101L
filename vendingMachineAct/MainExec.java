package vendingMachineAct;

import java.util.Scanner;
 

public class MainExec {
	static final int MAX_OBJECTS = 30;
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		Machine[] machines = new Machine[MAX_OBJECTS];
		Owner[] owners = new Owner[MAX_OBJECTS];
		
		// Technician technician = new Technician("techjoe");	
		// Customer johnDoe = new Customer("jhndoe", 100);
		
		char mode;
		
		do {
			mode = screens();
			
			switch (mode) {
				case '1': // customer mode
					Customer.customerScreen(machines);
					break;
					
				case '2': // technician mode
					Technician.technicianScreen(machines);
					break;
				
				case '3': // owner mode
					Owner.ownerScreen(owners, machines);
					break;
					
				case '4':
					break;
					
				default:
					System.out.println("Invalid mode [" + mode + "] selected!");
					System.out.println();
			
			
			} // end switch
			
		} while (mode != '4');
		
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
}
