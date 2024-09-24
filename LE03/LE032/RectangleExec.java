package LE03.LE032;

public class RectangleExec {
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
