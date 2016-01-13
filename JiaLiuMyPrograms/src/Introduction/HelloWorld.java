package Introduction;
import java.util.Scanner;
public class HelloWorld {
	static int numberOfMessages = 0; //Can look for local variable first.
	static Scanner input = new Scanner(System.in);
	static String username;
	static boolean running;
	/**
	 * @param args
	 * Hello this is a block comment for taking notes.
	 * System.out.println() is a method called OVERLOADED.
	 * OVERLOADED -> Same method with different arguments.
	 * int rounds down
	 * other files to use this just HelloWorld.print or etc.
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		String message = "This is a message assigned to a variable named message.";
//		int number1 = 50;
//		int number2 = 10;
//		int i = 0;
//
//		
//		String sentence = "The numbers are " + number1 + " " + "and " + number2
//				+ ". " + "Their sum is " + (number1 + number2) + "."; 
//		print("Hello World!" + message);
//		print((number1+number2)/7);
//		print(message);
//		print(sentence);
//		//for(i=0; i>=0; i++)
//			//{
//		 		//System.out.println(sentence);
//			//}
//		  //int a;
//	     String s;
//	 
//	     Scanner input = new Scanner(System.in);
//	 
//	     print("Enter your name please.");
//	     s = input.nextLine();
//	     print("Good Morning "+s+ "!");
//	 	
//	     /**System.out.println("Enter an integer");
//	     *a = input.nextInt();
//	     *System.out.println("You entered integer "+a);
//	     */	 
//		 print("What is your favorite animal?");
//		 String favoriteAnimal = waitForInput();
//		 print("Wow, that sure is great, " + username+ " I love " + favoriteAnimal + " also!");
//		 print("Do you like video games?");
//		 String game = waitForInput();
//		 print("Wow, I like " + game+ " too!");
//		 print("Did enjoy this program?");
//		 String enjoy = waitForInput();
//		 print("Your response is: " + enjoy + "if you liked it thank you " + username);
		 promptName();
		 endlessConversation();

			 
	}//End of main method
	
	public static void endlessConversation(){
		running = true;
		while(running){
			print("What school do you go to" + username + "?");
			String school = waitForInputProvideChoices();
			if(school.equals("S")){
				talkAboutBread();
//				running=false;
//				print("You typed S");
			}else if(school.equals("Q")){
//				print("You typed Q");
				running=false;
			}else{
				print("Oh, so you go to "+school+"?");
			}
		
//			print("Oh, so you go to "+waitForInput()+"?");
			
		}
	}
	
	public static void talkAboutBread(){
		print("I like bread. Yum!");
	}
	
	public static String waitForInputProvideChoices(){
		print("You may type the following commands:\n" +
				" \"Q\" - to quit\n" +
				" \"S\" - start over");
		String entry = input.nextLine();
		return entry;
	}
	
	static void print(int i) {
		System.out.println(numberOfMessages + " message: " +i);
		//prints integers
	}

	public static void print(String string){
		numberOfMessages++;
		System.out.println(numberOfMessages + " : " +string);
	//	System.out.println(string);
		//prints strings
	}
	
	public static String waitForInput(){
		String entry = input.nextLine();
		return entry;
	}
	
	
	public static void promptName(){
		print("Please enter your name.");
		username=waitForInput();
		print("Okay, I will call you " + username + ".");
	}

	public static void print(double[] string) {
		numberOfMessages++;
		System.out.println(numberOfMessages + " : " +string);
	}

}

