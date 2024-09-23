package LE02;
import java.util.Scanner;

public class DecToHex {
	public static void main(String[] args) {
		// declarations
		int number;
		Scanner input = new Scanner(System.in);
		
		// user prompt and input
		System.out.print("Enter a decimal number: ");
		number = input.nextInt();
		
		// output: using available 
		System.out.print("Hexadecimal number    : " + Integer.toHexString(number).toUpperCase());
		input.close();
	}
}
