package LE03.LE033;

import java.util.Scanner;

public class GradeExec {
	public static void main(String[] args) {
		// declarations
		Grade g1;
		int a, b, c, d, f;
		Scanner input = new Scanner(System.in);
		
		// user prompt and input
		System.out.print("Enter value for A >> ");
		a = input.nextInt();
		System.out.print("Enter value for B >> ");
		b = input.nextInt();
		System.out.print("Enter value for C >> ");
		c = input.nextInt();
		System.out.print("Enter value for D >> ");
		d = input.nextInt();
		System.out.print("Enter value for F >> ");
		f = input.nextInt();
		input.nextLine();
		System.out.println();
		
		// using Grade constructor
		g1 = new Grade(a, b, c, d, f);
		
		// calls method for printing bar graph
		g1.printGraph();
		
		// closing the Scanner object
		input.close();
	}
}
