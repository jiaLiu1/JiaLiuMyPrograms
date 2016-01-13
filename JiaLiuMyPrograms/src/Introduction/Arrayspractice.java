package Introduction;
import java.util.Scanner;

public class Arrayspractice {

	Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
//		int[] someDigitsOfPi = {3,1,4,1,5,9,2,6,5,3,};
//		int[] someDigitsOfe = new int[4];
//		someDigitsOfe[0] = 2;
//		someDigitsOfe[1] = 7;
//		someDigitsOfe[2] = 1;
//		someDigitsOfe[3] = 8;
//		HelloWorld.print("The number " +
//				"of digits of pi we have is " + someDigitsOfPi.length);
//		HelloWorld.print("The number " +
//				"of digits of e we have is " + someDigitsOfe.length);
//		printArrayContent(someDigitsOfPi);
//		printArrayContent(someDigitsOfe);
		long startTime = System.currentTimeMillis();
//		int[] randomArray1 = generateARandomArray(1000);
//		printArrayContent(randomArray1);
//		checkSimilar();
		countPrimes(99999999);
		long endTime = System.currentTimeMillis();
		HelloWorld.print("The method took " + (endTime-startTime) + "ms");
	}

	public static void countPrimes(int max) {
		boolean[] theNumbers = new boolean[max + 1];
		for(int index = 2; index < theNumbers.length; index++){
			theNumbers[index]=true;//start by assuming every number is prime (except 0 and 1)
		}
		for(int index = 2; index < theNumbers.length; index++)
			//for(boolean b: theNumbers){shortcut to do something with every boolean
			//if(b) is the same as if(b==true), if(theNumbers[index]) is the same as if(theNumbers[index]==true), 
			if(theNumbers[index]){
				for(int multipleIndex = index + index; 
						multipleIndex < theNumbers.length; 
						multipleIndex += index){
					theNumbers[multipleIndex]=false;
			}
		}
		String statement = "";
		int count = 0;
		for(int index = 0; index < theNumbers.length; index++){
			if(theNumbers[index]){
				count++;
				statement += " " + index +",";
			}
		}
		statement += "\nThere are " + count + " primes between 1 and " + max + ".";
		HelloWorld.print(statement);
	}

	public static void checkSimilar() {
		String[] deck = makeCards();
		String[] deck2 = makeCards();
//		swap(deck,0,51);
		shuffle(deck);
		shuffle(deck2);
		printArrayContent(deck);
		printArrayContent(deck2);
		checkForSimilar(deck, deck2);
	}

	public static void checkForSimilar(String[] deck, String[] deck2) {
		int counter = 0;
		for(int index = 0; index < deck.length; index++){
			if(deck[index].equals(deck2[index])){
				counter++;
			}
		}
		HelloWorld.print("There are " + counter + " similarities in the two decks.");
	}

	public static void shuffle(String[] deck) {
		for(int index = 0; index < deck.length; index++){
			int swapCard = (int)(Math.random()*deck.length);
			swap(deck,index,swapCard);
		}
	}
	
	public static void swap(String[] deck, int a, int b) {
		String placeholder = deck[a];
		deck[a] = deck[b];
		deck[b] = placeholder;
	}

	public static String[] makeCards() {
		String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
		String[] cards = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", 
				"Jack", "Queen", "King"};
		String[] allCards = new String[52];
		int cardNum = 0;
		for(int suit = 0; suit < cards.length; suit++){
			for(int card = 0; card < suits.length; card++){
				String tempString = cards[suit] + " of " + suits[card];
				allCards[cardNum] = tempString;
				cardNum++;
			}		
		}
		//printArrayContent(allCards);
		return allCards;
	}

	public static int[] generateARandomArray(int arrayLength) {
		int[] array = new int[arrayLength];
		for(int index = 0; index < arrayLength; index++){
			//array[index]=index+1;
			array[index]=arrayLength-index;
		}
		return array;
	}

	public static void printArrayContent(int[] array) {
		String arrayContent = "[";
		for(int index = 0; index < array.length; index++){
			if(index < array.length - 1) {
				arrayContent = arrayContent + array[index] + ", ";
			}
			else {
				arrayContent = arrayContent + array[index] + "";
			}
				
		}
		arrayContent = arrayContent + "]";
		HelloWorld.print(arrayContent);
	}

	
//	public static void printArrayContent(String[] array) {
//		String arrayContent = "[";
//		for(int index = 0; index < array.length; index++){
//			if(index < array.length - 1) {
//				arrayContent = arrayContent + array[index] + ", ";
//			}
//			else {
//				arrayContent = arrayContent + array[index] + "";
//			}
//				
//		}
//		arrayContent = arrayContent + "]";
//		HelloWorld.print(arrayContent);
//	}
//	
//	public static void printArrayContent(boolean[] array) {
//		String arrayContent = "[";
//		for(int index = 0; index < array.length; index++){
//			if(index < array.length - 1) {
//				arrayContent = arrayContent + array[index] + ", ";
//			}
//			else {
//				arrayContent = arrayContent + array[index] + "";
//			}
//				
//		}
//		arrayContent = arrayContent + "]";
//		HelloWorld.print(arrayContent);
//	}
//
//	public static void printArrayContent(double[] array) {
//		String arrayContent = "[";
//		for(int index = 0; index < array.length; index++){
//			if(index < array.length - 1) {
//				arrayContent = arrayContent + array[index] + ", ";
//			}
//			else {
//				arrayContent = arrayContent + array[index] + "";
//			}
//				
//		}
//		arrayContent = arrayContent + "]";
//		HelloWorld.print(arrayContent);
//	}

}
