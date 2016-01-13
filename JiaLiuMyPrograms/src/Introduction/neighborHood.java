package Introduction;

public class neighborHood {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean[][] grid = new boolean[3][3];
		grid[1][0] = true;
		Array2D.print2DArrayContent(grid);
//		int r = Array2D.getRandomInt(2);
//		int c = Array2D.getRandomInt(2);
		int r = 0;
		int c = 0;
		int typeOfSpace = checkNeighbors(grid, r , c);
		if(typeOfSpace == 0){
			HelloWorld.print("At row " + r + ", column " + c + ", the mine was found!");
		}
		if(typeOfSpace == 1){
			HelloWorld.print("At row " + r + ", column " + c + ", there is a mine nearby!");
		}
		else{
			HelloWorld.print("At row " + r + ", column " + c + ", there are no mines nearby!");
		}
	}

	public static int checkNeighbors(boolean[][] neighborhood, int r, int c){
		//If neighborhood[r][c] is adjacent (above, below, right, left) of a true value, return 1. 
		//If neighborhood is not adjacent to a true value, return -1.
		//return zero if IS a true value
		if(neighborhood[r][c] == true){
			return 0;
		}
		
		if(r!=0){
			if(neighborhood[r-1][c] == true){
				return 1;
			}
		}
		if(r!=(neighborhood.length-1)){
			if(neighborhood[r+1][c] == true){
				return 1;
			}
		}
		
		if(c!=0){
			if(neighborhood[r][c-1] == true){
				return 1;
			}
		}
		if(c!=(neighborhood[r].length-1)){
			if(neighborhood[r][c+1] == true){
				return 1;
			}
		}
		
		return -1;
		
//		   if(neighborhood[r][c] == true){
//				return 0;
//			}
//			if(r!=0){
//				if(neighborhood[r-1][c] == true){
//					return 1;
//				}
//			}
//			if(r!=(neighborhood.length-1)){
//				if(neighborhood[r+1][c] == true){
//					return 1;
//				}
//			}
//			if(c!=0){
//				if(neighborhood[r][c-1] == true){
//					return 1;
//				}
//			}
//			if(c!=(neighborhood[r].length-1)){
//				if(neighborhood[r][c+1] == true){
//					return 1;
//				}
//			}
//			return -1;
	}
}

