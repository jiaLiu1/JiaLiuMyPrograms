package Introduction;
import java.util.Scanner;
public class ChooseYourOwnAdventure {
	static Scanner input = new Scanner(System.in);
	static String start;
	static String message;
	public static void main(String[] args) throws InterruptedException{
        promptStart();
    }

	
	public static void start() throws InterruptedException{
		print("So you said yes. Well then, I hope you would enjoy the ride.\n______________________________________\n\n");
		story();
	}
	
	public static void story() throws InterruptedException{
		print("Narrator: At night outside of your own lodge. You and your \n" +
				"friends, Mike, Jenny and Lewis, are about to leave \n" +
				"the lodge to explore the forest. \n" +
				"Your name is Emily and it is your choice to decide whether who lives or die.\n");
		
	}
	
	private static void print(int i) {
		System.out.println(i);
		//prints integers
	}

	public static void print(String string) throws InterruptedException{
		char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
            Thread.sleep(40);
        }
		//prints strings
	}
	
	public static String waitForInput() throws InterruptedException{
		print(" \"Yes\"\n" +
				" \"No\"\n");
		String entry = input.nextLine();
		return entry;
	}
	
	public static void promptStart() throws InterruptedException{
        print("Hi, this is the Choose Your Own Adventure game. Do you want to begin?\n");
		start=waitForInput();
		if(start.equalsIgnoreCase("Yes")){
			start();
		}else if(start.equalsIgnoreCase("No")){
			print("Well sorry I only have this game soooooooooooooo...");
			promptStart();
		}else{
			promptStart();
		}
       
	
	}
}



