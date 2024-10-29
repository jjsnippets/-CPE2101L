// LE5.3
// Oct 29 2024
// PIN Authentication system with randomized challenge-response system

package LE05;

import java.util.Scanner;

public class PasswordAuth {
	private String password;
	
	private static Scanner sc = new Scanner(System.in);
	
	private void setPassword(String pass) {
		this.password = pass;
	}
	
	private String getPassword() {
		return this.password;
	}
	
	public static void main(String[] args) {
		PasswordAuth pass = new PasswordAuth();
		char choice;
		
		do {
			System.out.println("[A] SET PIN");
			System.out.println("[B] TEST PIN");
			System.out.println("[O] EXIT");
			System.out.print(" >> ");
			
			choice = Character.toUpperCase(sc.nextLine().strip().charAt(0));
			System.out.println();
			
			switch (choice) {
				case 'A':
					pass.setPassMenu();

					break;
				
				case 'B':
					pass.enterPassMenu();
					
					break;
					
				case 'O':
					break;
				
				default:
					System.out.println("INVALID INPUT!");
					System.out.println();
			}
		} while (choice != 'O');
		
		System.out.println("Closing PIN system!");
		System.out.println();

	}
	
	private String challengePass() {
		int[] passNums = new int[5];
		char[] shuffle = new char[10];
		char[] temp = this.getPassword().toCharArray();
		String ans;
		
		for(int i = 0; i < 5; i++) {
			passNums[i] = Integer.valueOf(String.valueOf(temp[i]));
		}
		
		System.out.print("PIN : ");
		
		for(int i = 0; i < 10; i++) {
			System.out.print(i + " ");
			shuffle[i] = Character.forDigit(((int) (Math.random() * 10)), 10);
		}
		
		System.out.println();
		System.out.print("NUM : ");
		
		for(char i : shuffle) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		for(int i = 0; i < 5; i++) {
			temp[i] = shuffle[passNums[i]];
		}
		
		ans = String.valueOf(temp);
		return ans;
	}
	
	public void setPassMenu() {
		System.out.println("SET PIN TO? [5 DIGITS]");
		System.out.print(" >> ");

		this.setPassword(sc.nextLine().strip());
		System.out.println();
		
		System.out.println("PASSWORD SET TO " + this.getPassword());
		System.out.println();
	}
	
	public void enterPassMenu() {
		String attempt;
		String soln = this.challengePass();
		System.out.print("ENTER PASSWORD >> ");
		
		attempt = sc.nextLine().strip();
		System.out.println();
		
		if(attempt.equals(soln)) {
			System.out.println("CORRECT PASSWORD!");
		} else {
			System.out.println("WRONG PASSWORD!");
		}
		System.out.println();
	}
}
