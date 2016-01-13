package Introduction;
import java.util.Scanner;

public class confirmEntry {
	static Scanner input = new Scanner(System.in);
	static String color;
	static String console;
	static String username;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		promptName();
		theEntry();
	}
	
	public static void promptName(){
		print("Please enter your name.");
		username = waitForInputProvideChoices();
	}
	
	public static void theEntry(){
		print("What is your favorite color " + username + "?\n" +
				" Black\n" +
				" White");
		color = waitForInputProvideChoices();
		if(color.equalsIgnoreCase("Black")){
			checkColor();
		}else if(color.equalsIgnoreCase("White")){
			checkColor();
		}else{
			theEntry();
		}
	}
	
	public static void checkColor(){
		print("So you like " + color + "\n" +
				" No\n" +
				" Yes");
		String decide = waitForInputProvideChoices();
		if(decide.equalsIgnoreCase("No")){
			theEntry();
		}else if(decide.equalsIgnoreCase("Yes")){
			theEntryPartTwo();
		}else{
			checkColor();
		}
	}
	
	public static void theEntryPartTwo(){
		print("What video game console do you like most? \n" +
				" PS4\n" +
				" XBoxOne");
		console = waitForInputProvideChoices();
		if(console.equalsIgnoreCase("PS4")){
			checkConsole();
		}else if(console.equalsIgnoreCase("XBoxOne")){
			checkConsole();
		}else{
			theEntryPartTwo();
		}
	}
	
	public static void checkConsole(){
		print("So you like " + console + "\n" +
				" No\n" +
				" Yes");
		String decide = waitForInputProvideChoices();
		if(decide.equalsIgnoreCase("No")){
			theEntryPartTwo();
		}else if(decide.equalsIgnoreCase("Yes")){
			theEnd();
		}else{
			checkConsole();
		}
	}
	
	public static void theEnd(){
		print("So your name is " + username + ", you like the color " + color + " and like the game console, " + console + ".");
	}
	
	public static String waitForInputProvideChoices(){
		String theEntry = input.nextLine();
		return theEntry;
	}
	
	public static void print(String string){
		System.out.println(string);
	}
}


