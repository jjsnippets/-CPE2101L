package LE01;
import java.util.Scanner;

public class ChocoBars {
	public static void main(String[] args) {
		// declarations
		double weight, height;
		int age;
		double man, woman; 
		double manBars, womanBars;
		Scanner input = new Scanner(System.in);
		
		// user prompt and input
		System.out.print("Enter weight (in pounds): ");
		weight = input.nextDouble();
		
		System.out.print("Enter height (in inches): ");
		height = input.nextDouble();
		
		System.out.print("Enter age: ");
		age = input.nextInt();
		System.out.println();
		
		// calculations
		man = 66 + (6.3 * weight) + (12.9 * height) - (6.8 * age);
		woman = 655 + (4.3 * weight) + (4.7 * height) - (4.7 * age);
		
		manBars = man / 230;
		womanBars = woman / 230;
		
		// output
		System.out.printf("BMR for man: %.2f calories\n", man);
		System.out.printf("Equivalent to about %.2f chocolate bars\n", manBars);
		System.out.printf("A %.0f\" %.0flb %d year old man needs at most %d chocolate bars to maintain weight\n\n", weight, height, age, 1 + (int) manBars);
		
		System.out.printf("BMR for woman: %.2f calories\n", woman);
		System.out.printf("Equivalent to about %.2f chocolate bars\n", womanBars);
		System.out.printf("A %.0f\" %.0flb %d year old woman needs at most %d chocolate bars to maintain weight\n\n", weight, height, age, 1 + (int) womanBars);
		
		// closing the Scanner object
		input.close();
	}

}