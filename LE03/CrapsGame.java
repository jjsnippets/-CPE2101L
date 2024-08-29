package LE03;
import java.util.Scanner;

public class CrapsGame {
	public static void main(String[] args) {
		int random1, random2, sum = 0, prev;
		
		while (true) {
			prev = sum;
			random1 = 1 + (int) (Math.random() * 6);
			random2 = 1 + (int) (Math.random() * 6);
			sum = random1 + random2;
			
			System.out.println("You rolled " + random1 + " + " + random2 + " = " + sum);
			
			if (prev > 0 && sum == 7) {
				System.out.println("You lose");
				break;
			} else if (prev == sum) {
				System.out.println("You win");
				break;
			} else if (sum == 7 || sum == 11) {
				System.out.println("You win");
				break;
			} else if (sum == 2 || sum == 3 || sum == 12) {
				System.out.println("You lose");
				break;
			} else
				System.out.println("Point is " + sum);
		}
	}
}
