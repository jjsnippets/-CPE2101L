// author: sarcol
// classic hangman game
// no lose condition, only keeps track of 

package LE03;
import java.util.Scanner;

public class HangmanGame {
	public static void main(String[] args) {
		// Add any words you wish in this array
		String[] words = {"write", "that", "apple", "chord"};
		
		// declarations
		int noGuesses;
		char guessLetter, repeat = 'y';
		Scanner input = new Scanner(System.in);
		
		// loop for a round
		do {
			// set-up for a (new) round
			noGuesses = 0;
			// selects a random word from the dictionary
			StringBuilder answer = new StringBuilder(words[(int) (Math.random() * words.length)]);
			StringBuilder display = new StringBuilder(answer);
			// sets up the guess field (display) to be empty
			for(int i = 0; i < display.length(); i++)
				display.setCharAt(i, '*');
			
//			debug: prints answer and display
//			System.out.println(answer + " " + display);
			
			// loop for a guess
			do {
				System.out.print("(Guess) Enter a letter in word " + display + " > ");
				guessLetter = input.nextLine().charAt(0);
				
				// if guessLetter has already been inputted before, ie if found in display  
				if(display.indexOf(String.valueOf(guessLetter)) > 0) {
					System.out.println("\t" + guessLetter + " is already in the word");
					continue;
				// if guessLetter is not in answer
				} else if (answer.indexOf(String.valueOf(guessLetter)) < 0) {
					System.out.println("\t" + guessLetter + " is not in the word");
					noGuesses++;
					continue;
				}
				
				// "places" all instances of guessLetter in answer to display
				for(int i = 0; i < answer.length(); i++) {
					if (answer.charAt(i) != guessLetter) continue;
					display.setCharAt(i, guessLetter);
				}

			// end loop only when display == answer
			} while (display.compareTo(answer) != 0);
			
			// statistics and user prompt
			System.out.println("The word is " + answer + ". You missed " + noGuesses + " time(s)");
			System.out.print("Do you  want to guess another word? Enter y or n > ");
			repeat = input.nextLine().charAt(0);
			
		// repeat when input is not n or N
		} while ((repeat != 'n') && (repeat != 'N'));
		
		input.close();
	}
}
