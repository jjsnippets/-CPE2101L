package LE03;

public class Rectangle {
	// class attributes
	private double width, height;
	
	// no-arg default constructor
	public Rectangle() {
		this.width = 1;
		this.height = 1;
	}
	
	// constructor for user-defined width and height
	public Rectangle(double w, double h) {
		this.width = w;
		this.height = h;
	}

	// accessors and mutators
	double getWidth() { return this.width; }
	void setWidth(double w) { this.width = w; }

	double getHeight() { return this.height; }
	void setHeight(double h) { this.height = h; }
	
	// exercise-required methods
	double getArea() {
		return this.height * this.height * this.width * this.width;
	}
	
	double getPerimeter() {
		return (2.0 * this.height) + (2.0 * this.width);
	}
	
	// support methods
	void printRectangle() {
		System.out.println("width: " + this.width);
		System.out.println("height: " + this.height);
		System.out.println("area: " + this.getArea());
		System.out.println("perimeter: " + this.getPerimeter());
		System.out.println();
	}

	// main method
	public static void main(String[] args) {
		// declarations
		Rectangle r1 = new Rectangle(4.0, 20.0);
		Rectangle r2 = new Rectangle(3.5, 39.5);
		
		// display of object instances
		System.out.println("=== r1: Rectangle ===");
		r1.printRectangle();

		System.out.println("=== r2: Rectangle ===");
		r2.printRectangle();
	}
}
