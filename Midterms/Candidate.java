package Midterms;

import java.util.Scanner;

public class Candidate implements Comparable<Candidate>  {
	private String name;
	private String position;
	private int votes;
	
	static Scanner sc = new Scanner(System.in);
	
	public Candidate(String name, String position) {
		setName(name);
		setPosition(position);
		this.votes = 0;
	}
	
	public void setName(String name) { this.name = name; }
	public String getName() { return this.name; }
	
	public void setPosition(String position) { this.position = position; }
	public String getPosition() { return this.position; }
	
	public int getVotes() { return this.votes; }
	public void resetVotes() { this.votes = 0; }
	public void incVotes() { this.votes++; }
	
	public static Candidate newCandidate() {
		Candidate person;
		String name, position;
		
		System.out.print("Name of candidate >> ");
		name = sc.nextLine().strip().toUpperCase();
		System.out.print("Position of candidate >> ");
		position = sc.nextLine().strip().toUpperCase();
		System.out.println();
		
		person = new Candidate(name, position);
		person.printOut();
		System.out.println("Number of votes: " + person.getVotes());
		System.out.println();
		
		System.out.println("Successfully added!");
		System.out.println();
		
		return person;
	}
	
	public void printOut() {
		System.out.println("Name: " + this.getName());
		System.out.println("Position: " + this.getPosition());
		
	}

	public int compareTo(Candidate y){
		return y.getVotes() - this.getVotes();
	}

}
