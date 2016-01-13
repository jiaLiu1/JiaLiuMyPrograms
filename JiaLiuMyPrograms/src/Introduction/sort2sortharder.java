package Introduction;

public class sort2sortharder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	      int[] array = {20,40,60,80,10,30};
	      int theNumber = 15;
	      int theKey;
	      theKey = searchUnsorted(array, theNumber);
	      System.out.println(theKey);
	}
	public static int searchUnsorted(int[] arrayToSearch, int key){
	        for(int index = 0; index < arrayToSearch.length; index++)
	        {
	            if(arrayToSearch[index] == key){
	                return arrayToSearch[index];
	            }
	        }
	        return -1;
	}
}
