package Midterms;

import java.util.Scanner;

public class Voter {
	
	static Scanner sc = new Scanner(System.in);
	
	public static boolean singleVote(Candidate person) {
		char choice;
		boolean hasVoted = false, ret = false;
		
		do {
			person.printOut();
			System.out.print("Vote for this person?");
			System.out.print("[Y/N] >> ");
			choice = sc.nextLine().strip().toUpperCase().charAt(0);
			System.out.println();
			
			if (choice == 'Y') {
				hasVoted = true;
				ret = true;
				person.incVotes();
				System.out.println("You voted for " + person.getName());
				
			}  else if (choice == 'N') {
				hasVoted = true;
				ret = false;
				System.out.println("You did not vote for " + person.getName());
				
			} else {
				System.out.println("Invalid selection!");
				
			}
			
			System.out.println();
		} while (!hasVoted);
		
			return ret;
	}

    public static boolean randomVote(Candidate person) {
        if (Math.random() > 0.5){
			System.out.println("Voted for " + person.getName() + " as " + person.getPosition());
			person.incVotes();
			return true;
		} else {
			System.out.println("Did not vote for " + person.getName() + " as " + person.getPosition());
			return false;
		}
    }
}
