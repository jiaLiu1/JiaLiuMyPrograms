package TowersHanoi;

public class Classwork1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(mystery(0));
		System.out.println(mystery2(0));
		System.out.println(mystery3(0));
		System.out.println(mystery4(0));
	}
	
	public static int mystery(int x)
	{
	 int sum = 0;
	 while( x >= 0)
	 {
	  sum += x;
	  x--;
	 }
	 return sum;
	}
	
	public static int mystery2(int x)
	 {
	  if (x == 0)
	  {
	   return 0;
	  }
	  return (x + mystery2(x - 1));
	 }
	
	public static int mystery3(int x)
	 {
	  if (x == 0)
	   return 0;
	  else
	   return mystery3(x - 1);
	 }
	
	public static int mystery4(int x)
	 {
	  if (x == 1)
	  {
	   return 1;
	  }
	  return (x + mystery4(x - 1));
	 }
}
