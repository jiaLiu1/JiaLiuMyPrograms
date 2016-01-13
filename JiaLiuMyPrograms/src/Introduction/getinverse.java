package Introduction;

public class getinverse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] newArray = {1.0,2.0,3.0};
		double[] thething = getInverses(newArray);
		System.out.println(thething);
	}

	public static double[] getInverses(double[] values){
		double[] theArray = new double[values.length];
        for(int index = 0; index < values.length; index++)
        {
           theArray[index] = 1/values[index];
           if(theArray[index] != 0){
               return theArray;
           }
           else{
                       
           }
        }
        return null;
	}
}
