package Introduction;

public class permutations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] stringOne = {"cat", "dog", "mouse", "cat"};
		printPermutations(stringOne);
	}
	//	  Write a method called: public static String[] printPermutations(String[] s1) 
	//	  The method should print every permutation of two strings from s1 with NO duplicates (DO NOT separate with a space!). 
	//	  This assignment is scaffolded: In the first test, the s1 will have distinct items In a later test, 
	//	  the s1 will have some duplicate entries Example: Suppose the String[] s1 = {"cat", "dog", "mouse", "cat"} 
	//	  Then "every permutation of two strings from s1 with NO duplicates" 
	//	  would be: {"catdog", "catmouse", "catcat", "dogcat","dogdog", dogmouse", "mousecat", mousedog", "mousemouse"} 
	//	  Notice that even though "cat" is listed twice in the original array, there are no duplicates in the returned array.

	public static String[] printPermutations(String[] s1){

		int counter = 0;
		
		String[] stringTwo = new String[s1.length* s1.length];
		for(int index = 0; index < s1.length; index++){
			for(int index2 = 0; index2< s1.length;index2++){
				String thePermutation = s1[index]+s1[index2];
				stringTwo[counter] = thePermutation; 
				counter++;
			}
		}
		//printArray(stringTwo);
		removeDoubles(stringTwo);
		return null;
	}

	public static String[] removeDoubles(String[] s2){
		int duplicates = 0;
		for(int index = 0; index < s2.length; index++){
			for(int index2 = 0; index2< s2.length;index2++){
				if(index != index2){
					if(s2[index].equals(s2[index2])){
						duplicates++;
					}
				}
			}
		}
		String [] s3 = new String[s2.length - duplicates];
		for(int index = 0; index < s2.length; index++){
			for(int index2 = 0; index2< s2.length;index2++){
				if(index != index2){
					if(s2[index].equals(s2[index2])){
						s3[index] = null;
					}
				}
			}
		}
		printArray(s3);
		return s3;
	}

	public static void printArray(String[] s){
		String all = "[";
		for(int i=0; i<s.length-1; i++){
			all+=s[i]+", ";
		}
		all+=s[s.length-1]+"]";
		System.out.println(all);
	}
}