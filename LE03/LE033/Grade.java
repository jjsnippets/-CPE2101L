package LE03.LE033;

public class Grade {
	@SuppressWarnings("unused")
	// class attributes
	private int A, B, C, D, F;
	private int total;
	private StringBuilder Ax, Bx, Cx, Dx, Fx;
	
	// class constructor
	public Grade(int A, int B, int C, int D, int F) {
		// declarations
		int As, Bs, Cs, Ds, Fs;
		
		this.A = A;
		this.B = B;
		this.C = C;
		this.D = D;
		this.F = F;
		
		// calculates total grades
		this.total = A + B + C + D + F;
		
		// calculates fraction of the 50 a grade gets
		As = (int) Math.round(50.0 * A / this.total);
		Bs = (int) Math.round(50.0 * B / this.total);
		Cs = (int) Math.round(50.0 * C / this.total);
		Ds = (int) Math.round(50.0 * D / this.total);
		Fs = (int) Math.round(50.0 * F / this.total);
		
		// equivalent bar graph of a grade as StringBuilder
		this.Ax = Grade.fillX(As, 'A');
		this.Bx = Grade.fillX(Bs, 'B');
		this.Cx = Grade.fillX(Cs, 'C');
		this.Dx = Grade.fillX(Ds, 'D');
		this.Fx = Grade.fillX(Fs, 'F');
	}
	
	// method for making a single bar in the bar graph
	public static StringBuilder fillX(int x, char l) {
		StringBuilder bar = new StringBuilder();
		
		for (int i = 0; i < x; i++) {
			bar.append("*");
		}
		
		bar.append(" ");
		bar.append(l);
		bar.append(" ");
		
		return bar;
	}
	
	// method for printing the data of the object in a bar graph format
	public void printGraph() {
		System.out.println("0    10   20   30   40   50   60   70   80   90  100%");
		System.out.println("|    |    |    |    |    |    |    |    |    |   |");
		System.out.println("**************************************************");
		System.out.println(this.Ax);
		System.out.println(this.Bx);
		System.out.println(this.Cx);
		System.out.println(this.Dx);
		System.out.println(this.Fx);
	}
	
}
