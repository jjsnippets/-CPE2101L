package LE02;

public class HeadOrTails {
	public static void main(String[] args) {
		final int FLIPS = 2000000;
		int heads = 0, tails = 0;
		
		
		for(int i = 0; i < FLIPS; i++) {
			int coin = (int) (Math.random() * 2);
			if (coin == 0)
				heads++;
			else
				tails++;
		}
		
		System.out.println("For " + FLIPS + " flips of the coin:");
		System.out.println(heads + " were  heads");
		System.out.println(tails + " were  tails");

	}
}
