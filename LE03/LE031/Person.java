package  LE03.LE031;

public class Person{
	// class attributes
	private String name;
	private int age;
	
	// class constructor
	public Person (String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// accessors and mutators
	String getName() { return this.name; }
	void setName(String name) { this.name = name; }
	
	int getAge() { return this.age; }
	void setAge(int age) { this.age = age; }
	
	// exercise-required methods
	boolean isEqual(Person p) {
		return this.sameName(p) && this.sameAge(p);
	}
	
	boolean sameName(Person p) {
		return this.name.equals(p.name);
	}
	
	boolean sameAge(Person p) {
		return this.age == p.age;
	}
	
	boolean isOlder(Person p) {
		return this.age > p.age;
	}
	
	boolean isYounger(Person p) {
		return this.age < p.age;
	}
	
	// support methods
	void printPerson() {
		System.out.println(this.name + ": " + this.age);
	}
}