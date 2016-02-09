package TowersHanoi;

public class Towers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int disc = 1;
		String A = "A";
		String B = "B";
		String C = "C";
		move(disc, A, B, C);

	}
	
	public static void move(int n, String from, String other, String to){
		if(n == 0) System.out.println("Move a disc from " + from + " to " + to);
		else{
			move((n-1), from, to, other);
			System.out.println("Move a disc from " + from + " to " + to);
		}
	}
}
