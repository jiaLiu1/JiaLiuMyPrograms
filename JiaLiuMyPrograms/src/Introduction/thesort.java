package Introduction;

public class thesort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] order = {78, 79, 3, 5454, 9, 143, 1535};
		printArrayContent(sort(order));
	}

	public static int[] sort(int[] shuffled){
		int temp;
		int[] sort = new int[shuffled.length];
		for(int x = 0; x < shuffled.length; x++){
			for(int y = 1; y < (shuffled.length - x); y++){
				if(shuffled[y-1] > shuffled[y]){
					temp = shuffled[y-1];
					shuffled[y-1]=shuffled[y];
					shuffled[y] = temp;
				}
			}
		}
		for(int i = 0; i <shuffled.length; i++){
			sort[i] = shuffled[i];
		}
		return sort;
		
	}


	public static void printArrayContent(int[] ints){
		String builder ="[";
		for (int i=0; i<ints.length-1; i++){
			builder+=ints[i]+", ";
		}
		builder+=ints[ints.length-1]+"]";
		System.out.println(builder);
	}

}
