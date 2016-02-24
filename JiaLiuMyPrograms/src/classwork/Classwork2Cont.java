package classwork;

public class Classwork2Cont {
	private String word; 
	public Classwork2Cont(String word){
		this.word = word;
	}
	
	public String getHint(String word){
		String newWord = "";
		for(int i = 0; i < word.length(); i++){
			if(word.substring(i, i+1).equals(this.word.substring(i, i+1))){
				newWord += word.substring(i, i+1);
			}
		}
		for(int k = 0; k < word.length(); k++){
			for(int z = k+1; z < word.length()-1; z++){
				if(word.substring(word.charAt(k), word.charAt(k)+1).equals
						(word.substring(this.word.charAt(z), this.word.charAt(z)+1))){
					newWord += "+";
				}
				else{
					newWord += "*";
				}
			}
		}
		return newWord;
	}
}
