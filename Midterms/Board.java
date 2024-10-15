package Midterms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.HashSet;

public class Board {
	static private ArrayList<Candidate> candidates = new ArrayList<Candidate>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		char erase;
		
		do {
			System.out.println("Choose an action:");
			System.out.println("[1] New candidate");
			System.out.println("[2] Vote for a position");
			System.out.println("[3] Show rankings");
			System.out.println("[4] Leave system");
			System.out.println();
			System.out.println("[0] Or simulate a random election period");
			System.out.print(" >> ");
			choice = sc.nextInt();
			sc.nextLine();
			System.out.println();
			
			switch (choice) {
			case 0:
				do {
					System.out.println("Simulate with current candidates?");
					System.out.println("[Y] Yes, keep the candidate list as is");
					System.out.println("[N] No, create new ones");
					System.out.println("[C] Cancel operation");
					erase = sc.nextLine().strip().toUpperCase().charAt(0);

					switch(erase){
						case 'N':
							System.out.println("Erasing data...");
							candidates = new ArrayList<Candidate>();

							candidates.add(new Candidate("JOHN", "PRESIDENT"));
							candidates.add(new Candidate("JAKE", "PRESIDENT"));

							candidates.add(new Candidate("CHERRY", "VICE PRESIDENT"));
							candidates.add(new Candidate("CHARLIE", "VICE PRESIDENT"));

							candidates.add(new Candidate("ALEX", "SECRETARY"));
							candidates.add(new Candidate("ALICE", "SECRETARY"));
							candidates.add(new Candidate("AMY", "SECRETARY"));

						case 'Y':
							for (Candidate x : candidates) x.resetVotes();

							int pop = (int) (Math.random() * 50);
							System.out.println("Voter's population size: " + pop);
							System.out.println();

							for (int i = 0; i < pop; i++){
								System.out.println("Contents of ballot " + (i + 1) + ": ");
								for (Candidate x : candidates) {
									Voter.randomVote(x);
								}
								System.out.println();
							}

							System.out.println();
							Board.displayStats(candidates);

						case 'C':
							erase = 'C';
							break;

						default:
							System.out.println("Invalid input!");
							System.out.println();
							break;
					}
				} while (erase != 'C');

				break;

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
		
		sc.close();
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

		System.out.println("$$$ ELECTION RESULTS $$$");
		
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

			Collections.sort(inPosition);
			
			System.out.println("=== " + position + " ===");
			System.out.println("Total votes: " + sumAll);
			
			if (sumAll == 0) sumAll = 1;
			
			for(int i = 0; i < inPosition.size(); i++){
				Candidate candidate = inPosition.get(i);
				System.out.println((i + 1) + ") " + candidate.getName() + " [" + candidate.getVotes() + "] (" + ((float) candidate.getVotes()*100)/sumAll + "%)");
			}

			System.out.println();
		}
	}
}
