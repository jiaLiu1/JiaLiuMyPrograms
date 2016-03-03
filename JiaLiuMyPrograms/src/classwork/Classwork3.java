package classwork;

import Introduction.Arrayspractice;

public class Classwork3 {

	public static void main(String[] args) {
		int[][] theArray = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//		printArray(theArray);
//		printDiag(theArray);
//		printNegs(theArray);
//		System.out.println("The Mat");
//		print2DArrayContent(theArray);
//		System.out.println("\n" + "The Mat With Element");
//		int[][] negArray = posToNeg2D(theArray, 0, 1);
//		print2DArrayContent(negArray);
		int[] newRowArray = rowMajorOrder(theArray);
		Arrayspractice.printArrayContent(newRowArray);
	}
	
	//Example 7
	private static int[][] posToNeg2D(int[][] theArray, int r, int c) {
		//Above
		if(r > 0){
			theArray[r-1][c] = -theArray[r-1][c]; 
		}
		//Below
		if(r < theArray.length-1){
			theArray[r+1][c] = -theArray[r+1][c]; 
		}
		 //Left
		if(c > 0){
			theArray[r][c-1] = -theArray[r][c-1];
		}
		 //Right
		if(c < theArray.length-1){
			theArray[r][c+1] = -theArray[r][c+1];
		}		
		//Adjacent
		if(r != 0 && r != theArray.length-1 && c != 0 && c != theArray.length-1){
			theArray[r-1][c-1] = -theArray[r-1][c-1]; //Adjacent Top Left
			theArray[r+1][c-1] = -theArray[r+1][c-1]; //Adjacent Bottom Left
			theArray[r+1][c+1] = -theArray[r+1][c+1]; //Adjacent Bottom Right
			theArray[r-1][c+1] = -theArray[r-1][c+1]; //Adjacent Top Right
		} 
		//Adjacent When c = 0
		if(c == 0 && r != 0 && r != theArray.length-1){
			theArray[r+1][c+1] = -theArray[r+1][c+1]; //Adjacent Bottom Right
			theArray[r-1][c+1] = -theArray[r-1][c+1]; //Adjacent Top Right
		}
		else
			if(c == 0 && r == 0) theArray[r+1][c+1] = -theArray[r+1][c+1]; //Adjacent Bottom Right
			else
				if(c == 0 && r == theArray.length-1) theArray[r-1][c+1] = -theArray[r-1][c+1]; //Adjacent Top Right
		//Adjacent When c = theArray.length-1
		if(c == theArray.length-1 && r != 0 && r != theArray.length-1){
			theArray[r+1][c-1] = -theArray[r+1][c-1]; //Adjacent Bottom Left
			theArray[r-1][c-1] = -theArray[r-1][c-1]; //Adjacent Top Left
		}
		else
			if(c == theArray.length-1 && r == 0) theArray[r+1][c-1] = -theArray[r+1][c-1]; //Adjacent Bottom Left
			else
				if(c == theArray.length-1 && r == theArray.length-1) theArray[r-1][c-1] = -theArray[r-1][c-1]; //Adjacent Top Left
		//Adjacent When r = 0
		if(r == 0 && c != 0 && c != theArray.length-1){
			theArray[r+1][c-1] = -theArray[r+1][c-1]; //Adjacent Bottom Left
			theArray[r+1][c+1] = -theArray[r+1][c+1]; //Adjacent Bottom Right
		}
		if(r == theArray.length-1 && c != 0 && c != theArray.length-1){
			theArray[r-1][c-1] = -theArray[r-1][c-1]; //Adjacent Top Left
			theArray[r-1][c+1] = -theArray[r-1][c+1]; //Adjacent Top Right
		}
		return theArray;
	}

	//Example 8
	public static int[] rowMajorOrder(int[][] theArray){
		int total = findTotal(theArray);
		int[] Array = new int[total];
		for(int x = theArray.length-1; x >= 0; x--){
			for(int y = theArray[x].length-1; y >= 0; y--){
				Array[total-1] = theArray[x][y];
				total--;
			}
		}
		return Array;
	}
	
	private static int findTotal(int[][] theArray) {
		int num = 0;
		for(int x = 0; x < theArray.length; x++){
			for(int y = 0; y < theArray[x].length; y++){
				if(theArray[x][y] == theArray[x][y]){
					num++;
				}		
			}
		}
		return num;
	}

	private static void printNegs(int[][] A) {
		int num = 0;
		for(int x = 0; x < A.length; x++){
			for(int y = 0; y < A[x].length; y++){
				if(A[x][y] < 0){
					num++;
				}		
			}
		}
		System.out.println(num);
	}

	private static void printDiag(int[][] A) {
		for(int x = 0; x < A.length; x++){
			System.out.println(A[x][x]);
		}
	}

	private static void printArray(int[][] A) {
		for(int x = A.length-1; x >= 0; x--){
			System.out.println(A[x][x]);
		}
	}

	public static void print2DArrayContent(int[][] array){
		for(int[] x: array){
			Arrayspractice.printArrayContent(x);
		}
	}
}
