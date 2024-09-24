package LE03.LE033;

public class Grade {
	// class attributes
	private int A, B, C, D, F;
	private int total;
	
	// class constructor
	public Grade(int a, int b, int c, int d, int f) {
		this.A = a;
		this.B = b;
		this.C = c;
		this.D = d;
		this.F = f;
		
		// calculates total grades
		this.total = a + b + c + d + f;
	}
	
	// accessors and mutators
	public int getA() { return this.A; }
	public void setA(int a) { this.A = a; }
	
	public int getB() { return this.B; }
	public void setB(int b) { this.B = b; }
	
	public int getC() { return this.C; }
	public void setC(int c) { this.C = c; }
	
	public int getD() { return this.D; }
	public void setD(int d) { this.D = d; }
	
	public int getF() { return this.F; }
	public void setF(int f) { this.F = f; }
	
	
	// method for printing the data of the object in a bar graph format
	public void printGraph() {
		// declarations
		int As, Bs, Cs, Ds, Fs;
		
		// re-calculates total grades
		this.total = A + B + C + D + F;
		
		// calculates fraction of the 50 a grade gets
		As = (int) Math.round(50.0 * this.A / this.total);
		Bs = (int) Math.round(50.0 * this.B / this.total);
		Cs = (int) Math.round(50.0 * this.C / this.total);
		Ds = (int) Math.round(50.0 * this.D / this.total);
		Fs = (int) Math.round(50.0 * this.F / this.total);
		
		System.out.println("0    10   20   30   40   50   60   70   80   90  100%");
		System.out.println("|    |    |    |    |    |    |    |    |    |   |");
		System.out.println("**************************************************");
		System.out.println(Grade.fillX(As, 'A'));
		System.out.println(Grade.fillX(Bs, 'B'));
		System.out.println(Grade.fillX(Cs, 'C'));
		System.out.println(Grade.fillX(Ds, 'D'));
		System.out.println(Grade.fillX(Fs, 'F'));
	}
	
	// method for making a single bar in the bar graph
	private static StringBuilder fillX(int x, char l) {
		StringBuilder bar = new StringBuilder();
		
		for (int i = 0; i < x; i++) {
			bar.append("*");
		}
		
		bar.append(" ");
		bar.append(l);
		bar.append(" ");
		
		return bar;
	}
}
