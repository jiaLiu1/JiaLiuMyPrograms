package math;

public class Term{
	double coefficient;
	String variable;
	int exponent;
	private boolean constant;//this is true if a Term has no variable expression
	//TODO: Write getters for all of the above fields

	public Term(double coefficient, String var, int exp){
		this.coefficient = coefficient;
		variable = var;
		exponent = exp;
		if(!var.equals("")){
			constant = false;
		}
		else{
			constant = true;
			exponent=0;
		}
		if(coefficient==0){
			variable="";
			exponent=0;
		}
		//set the value of all the fields
		//if variable is non-empty, sets constant to 'false'
	}
	/**
	 *a constructor for constant: 
	 */
	Term(double constant){
		coefficient = constant;
		variable = "";
		exponent = 0;
		this.constant = true;
		//sets coefficient to constant, variable to "", exponent to "0" and constant to 'true')
	}
	/**
	 *Write getters for each field
	 *Note that the getter for the boolean should be called 'isConstant'
	 */ 
	
	public boolean isConstant() {
		return constant;
	}
	
	public double getCoefficient() {
		return coefficient;
	}

	public String getVariable() {
		return variable;
	}

	public int getExponent() {
		return exponent;
	}

	public Term getAddInverse(){	
		return new Term(-coefficient, variable, exponent);
		//returns the additive inverse of this Term
	}
	
	public Term getMulInverse(){
		return new Term(1/coefficient, variable, exponent);
		//returns the multiplicative inverse of this Term
	}

	public int getDegree(){
		return exponent;
		//returns the exponent
	}

	public boolean isPositive(){
		if(getCoefficient() >= 0){
			return true;
		}
		else{
			return false;
		}
		//returns true if the coefficient is positive (or zero), false otherwise
	}	
	/**
	* @param s
	* @param t
	* @return 'true' if s and t are like terms (same variable and exponent)
	*/
	public static boolean areLikeTerms(Term s, Term t){
		if(s.isConstant() && t.isConstant() || (s.getVariable().equals(t.getVariable()) && (s.getExponent() == t.getExponent()))){
			return true;
		}
		else{
			return false;
		}
		//returns true if s and t are either both constants or if they both have the same variables and same exponents

	}
	
	/**
	* returns a new Term with same variable and exponent as s and t but combined coefficient
	* @param s
	* @param t
	* @return
	*/
	public static Term combine(Term s, Term t){
		double newCoefficient = s.getCoefficient()+t.getCoefficient();
		return new Term(newCoefficient, s.getVariable(), t.getExponent());
		//returns a new Term representing the sum of s and t
	}
	
	public static Term mulCombine(Term s, Term t){
		double newCoefficient = s.getCoefficient()*t.getCoefficient();
		return new Term(newCoefficient, s.getVariable(), t.getExponent());
		//returns a new Term representing the multiple of s and t
	}
	
	public void setCoefficient(double d) {
		coefficient = d;
	}
	
	public String toString(){
		//Double d = new Double(coefficient);
		//int i = d.intValue();
		String s = "";
//		if (!constant && (coefficient == (int)coefficient|| coefficient == (int)-coefficient)){
//			coefficient = (int)coefficient;
//		}
		
		if(!constant && (coefficient == 1.0|| coefficient == -1.0)){
			if(coefficient == -1.0)s+="-";
		}
		else{
			//s+=i;
			s+=(int)coefficient;
		}
		s+=variable;
		if(exponent!=0 && exponent!=1)s+="^"+exponent;
		return s;
		/**
		 *Some tips to consider:
		 *doubles always print with trailing zeros (i.e. 2.0) This is not desirable
		 *If a term has a coefficient of 1 or -1, the 1 should not be shown. 
		 *If a term has an exponent of 1, the 1 should not be shown
		 *For exponents, use '^'. The GUI will change it into superscript.
		 */
	}

}