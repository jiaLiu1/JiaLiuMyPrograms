package Introduction;

public class Array2D {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int[][] grid3X3 = new int[3][3];
//		Arrays.printArrayContent(grid3X3[0]);//prints the first row
//		Arrays.printArrayContent(grid3X3[1]);//prints 2nd row
//		Arrays.printArrayContent(grid3X3[2]);//prints 3rd row
//		if(true) Executed if(false) Skipped
//		HelloWorld.print("");
//		print2DArrayContent(grid3X3);
//		________________________________________________________________Question 12
//		boolean[] booray = new boolean[8];
//		booray[2]= true;
//		booray[6]=true;
//		for(int index=0; index<booray.length; index++){
//		    if(booray[index]){
//		        if(index>0)booray[index-1]=!booray[index-1]; <------- so it doesn't go out of bounds!
//		        if(index<booray.length-1)booray[index+1]=!booray[index+1];
//		        booray[index]=!booray[index];
//		    }	    
//		}
//		_________________________________________________________________
		checkAdjacentValues();
	}
	
	public static void checkAdjacentValues() {
		boolean[][] mines = new boolean[3][3];
		HelloWorld.print(mines[1].length);
		mines[2][1] = true;
		int row = getRandomInt(2);
		int column = getRandomInt(2);
		HelloWorld.print(row + "," + column);
		print2DArrayContent(mines);
		int typeOfSpace = checkSpace(mines, row, column);
		if(typeOfSpace == 0){
			HelloWorld.print("At row " + row + ", column " + column + ", the mine was found!");
		}
		if(typeOfSpace == 1){
			HelloWorld.print("At row " + row + ", column " + column + ", there is a mine nearby!");
		}
		else{
			HelloWorld.print("At row " + row + ", column " + column + ", there are no mines nearby!");
		}
	}

	public static int checkSpace(boolean[][] mines, int row, int column) {
		if(mines[row][column] == true)
		{
			return 0;
		}
		else{
			return 2;
		}
	}

	public static int getRandomInt(int max) {
		int random = (int)(Math.random()*max)+1;
		return random;
	}

	public static double getRandomdouble(double max) {
		double random = (double)(Math.random()*max)+1;
		return random;
	}
	
	public static void print2DArrayContent(int[][] array){
		for(int[] x: array){
			Arrayspractice.printArrayContent(x);
		}
	}
	
	public static void print2DArrayContent(boolean[][] array){
		for(boolean[] x: array){
			Arrayspractice.printArrayContent(x);
		}
	}

	public static void print2DArrayContent(double[][] grid) {
		for(double[] x: array){
			Arrayspractice.printArrayContent(x);
		}
	}

}
