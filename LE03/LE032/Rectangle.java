package LE03.LE032;

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
}
