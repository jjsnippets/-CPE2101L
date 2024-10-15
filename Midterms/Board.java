package Midterms;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashSet;

public class Board {
	static private ArrayList<Candidate> candidates = new ArrayList<Candidate>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		
		do {
			System.out.println("Choose an action:");
			System.out.println("[1] New candidate");
			System.out.println("[2] Vote for a position");
			System.out.println("[3] Show rankings");
			System.out.println("[4] Leave system");
			System.out.print(" >> ");
			choice = sc.nextInt();
			System.out.println();
			
			switch (choice) {
			case 1:
				candidates.add(Candidate.newCandidate());
				break;
				
			case 2:
				for (Candidate x : candidates) {
					Voter.singleVote(x);
				}
				break;
				
			case 3:
				Board.displayStats(candidates);
				break;
				
			case 4:
				System.out.println("Thank you for using the machine");
				System.out.println("Have a nice day! ");
				break;
				
			default:
				System.out.println("Invalid input!");
				System.out.println();
				break;
			
			}
		} while (choice != 4);
		
	}
	
	private static HashSet<String> allPositions(ArrayList<Candidate> candidates) {
		HashSet<String> res = new HashSet<String>();
		for(Candidate x : candidates) {
			res.add(x.getPosition());
		}
		return res;
	}
	
	public static void displayStats(ArrayList<Candidate> candidates) {
		HashSet<String> allPositions = allPositions(candidates);
		int sumAll;
		
		for(String position : allPositions) {
			ArrayList<Candidate> inPosition = new ArrayList<Candidate>();
			sumAll = 0;
			// ArrayList<Candidate> sorted = new ArrayList<Candidate>();
			
			for(Candidate candidate : candidates) {
				if(candidate.getPosition().equalsIgnoreCase(position)) {
					inPosition.add(candidate);
					sumAll += candidate.getVotes();
				}
			}
			
			System.out.println("=== " + position + " ===");
			System.out.println("Total votes: " + sumAll);
			
			if (sumAll == 0) sumAll = 1;
			
			for(Candidate candidate : inPosition) {
				System.out.println(" # " + candidate.getName() + " [" + candidate.getVotes() + "] (" + ((float) candidate.getVotes()*100)/sumAll + "%)");
			}
			System.out.println();
			
			
//			for(int i = 0; i < candidates.size(); i++) {
//				if (sorted.size() == i) {
//					sorted.add(inPosition.get(i));
//					continue;
//				}
//			}
			
			
			
		}
	}
	
}
