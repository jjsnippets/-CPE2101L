package vendingMachineAct;

import java.util.Scanner;
 

public class MainExec {

	public static void main(String[] args) {
		final int MAX_OBJECTS = 30;
		
		Machine machines[] = new Machine[MAX_OBJECTS];
		Owner owners[]= new Owner[MAX_OBJECTS];
		Technician technicians[] = new Technician[MAX_OBJECTS];
		
		Customer johnDoe = new Customer();
		int mode;
		
		do {
			mode = screens();
			
			switch (mode) {
				case 1:
					
					break;
					
				case 2:
					
					break;
				
				case 3:
					
					break;
					
				case 4:
					
					break;
			
			
			}
			
			
			
		} while (mode != 4);
		
		

	}
	
	// initial screen / change modes screen
	public static int screens() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Run as:");
		System.out.println("[1] Customer");
		System.out.println("[2] Technician");
		System.out.println("[3] Owner");
		System.out.println("[4] Terminate program");
		System.out.print(" >> ");
		
		int x = input.nextInt();
		input.close();
		
		return x;
	}

}
