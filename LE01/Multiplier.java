package LE01;
import java.util.Scanner;

public class Multiplier {
	public static void main(String[] args) {
		// declarations
		int number, result = 1, current;
		int numDigits;
		Scanner input = new Scanner(System.in);
			
		// user prompt and input
		System.out.print("Enter a number between 0 and 1000: ");
		number = input.nextInt();
		System.out.println();
		
		// computes products of digits (procedural code)
		// lesson: do not overcomplicate solutions; sometimes, brute force is quicker than a general solution
			// int thousands = 
		
		numDigits = 1 + (int) Math.log10(number);
		System.out.println(numDigits);

		for (int i = numDigits; i > 0; i--) {
			System.out.println("new:" + number);
			int powMask = (int) Math.pow(10, i - 1);
			current = number % powMask;
			result *= current;
			number -= current * Math.pow(10, i - 1);
			System.out.println(current);
		}
		
		// output
		System.out.println();
		System.out.println(result);
		
		// debug
		// System.out.printf("%d %d %d %d = %d", quarters, dimes, nickels, pennies, quarters * 25 + dimes * 10 + nickels * 5 + pennies);
		
		// closing the Scanner object
		input.close();
	}
}