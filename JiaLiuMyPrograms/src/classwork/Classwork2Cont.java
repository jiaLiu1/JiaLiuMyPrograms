package classwork;

public class Classwork2Cont {
	private String word; 
	public Classwork2Cont(String word){
		this.word = word;
	}
	//HARPS
	//AAAAA
	public String getHint(String word){
		String newWord = "";
		for(int i = 0; i < word.length(); i++){
			if(word.substring(i, i+1).equals(this.word.substring(i, i+1))){
				newWord += word.substring(i, i+1);
				System.out.println(word.charAt(i) + ": Correct");
			}
			else
			if(this.word.indexOf(word.substring(i, i+1)) != -1){
				System.out.println(word.charAt(i) + ": In hidden word");
				newWord += "+";
			}
			else{
				System.out.println(word.charAt(i) + ": Not hidden word");
				newWord += "*";	
			}
		}
		return newWord;
	}
}
