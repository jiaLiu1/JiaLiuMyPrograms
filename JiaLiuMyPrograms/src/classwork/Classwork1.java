package classwork;

public class Classwork1 {

	public static void main(String[] args) {
		System.out.println(reverse("Hi"));
	}

	private static String reverse(String string) {
		String newString = "";
		if(string.length() == 1){
			return string;
		}
		
		else{
			string.substring(string.length()-1);
			return string;
		}
		
	}
	

}
