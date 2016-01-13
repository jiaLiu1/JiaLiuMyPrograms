package math;

import java.util.ArrayList;

public class Equation{

	ArrayList<Term> leftSide;
	ArrayList<Term> rightSide;
	boolean cancelRight;
	ArrayList<Double> solution;
	//TODO: Make getters for all of the above

	public Equation(ArrayList<Term> leftSide, ArrayList<Term> rightSide){
		this.leftSide = leftSide;
		this.rightSide = rightSide;
		//sets values of leftSide and rightSide only
	}

	public ArrayList<Term> getLeftSide() {
		return leftSide;
	}

	public ArrayList<Term> getRightSide() {
		return rightSide;
	}

	public boolean isCancelRight() {
		return cancelRight;
	}

	public ArrayList<Double> getSolution() {
		return solution;
	}

	public boolean isLinear(){
		return isOfDegree(1);
		//returns 'true' if this equation is linear
		//and every term is either constant or has the same variable
	}

	private boolean isOfDegree(int degree) {
		int maxDegree = 0;
		int minDegree = 0;
		String variable = "";
		for(Term t: leftSide){
			if(t.getDegree()>maxDegree)maxDegree=t.getDegree();
			if(t.getDegree()<minDegree)return false;//Any negative value changes type of equation to rational
			if(!t.isConstant())variable=t.getVariable();
		}
		for(Term t: rightSide){
			if(t.getDegree()>maxDegree)maxDegree=t.getDegree();
			if(t.getDegree()<minDegree)return false;
			if(!t.isConstant())variable=t.getVariable();
		}
		if(maxDegree==degree && variablesMatch(variable))return true;
		else return false;
	}

	private boolean variablesMatch(String s) {
		for(Term t: leftSide){
			if(!t.isConstant() && !t.getVariable().equals(s))return false;
		}
		for(Term t: rightSide){
			if(!t.isConstant() && !t.getVariable().equals(s))return false;
		}
		return true;
	}

	public boolean isQuadratic(){
		return isOfDegree(2);
		//returns 'true' if this equation is quadratic
		//and every term is either constant or has the same variable
	}

	public boolean isSolveable(){
		if(isLinear() || isQuadratic()){
			return true;
		}
		return false;
		//returns 'true' if this equation is linear or quadratic, 'false' otherwise 
		//(because in this project we are not programming a means of solving anything other than linear and quadratic equations)
	}

	public boolean cancelRight(){
		Term highestLeft = getHighestDegreeTerm(leftSide);
		Term highestRight = getHighestDegreeTerm(rightSide);
		if(highestRight.getDegree()>highestLeft.getDegree() && highestRight.isPositive())return false;
		if(highestRight.getDegree()>highestLeft.getDegree() && !highestRight.isPositive())return true;
		if(highestRight.getDegree()<highestLeft.getDegree() && highestRight.isPositive())return true;
		if(highestRight.getDegree()<highestLeft.getDegree() && !highestRight.isPositive())return false;
		if(highestRight.getDegree()==highestLeft.getDegree() && highestRight.getCoefficient()>highestRight.getCoefficient())return true;
		else return false;
		//false highest degree is on the right
		//true if highest degree is on the left
		//sets the value of cancelRight and
		//returns 'true' if the equation should be solved by subtracting terms from the right side, false if it is better to subtract terms on the left side
	}

	public String toString(){
		String s = getSideString(leftSide)+" = "+getSideString(rightSide);
		return s;
		/**
		 *Take your time on this method!
		 *There are many things to consider:
		 *Every terms should be separated by a '+' UNLESS it has a negative coefficient. 
		 *When a term is negative, the negative sign will appear as a minus.
		 */
	}


	private String getSideString(ArrayList<Term> side) {
		String s = "";
		try{
			s=side.get(0).toString();
		}catch(Exception e){
			s = "0";
		}
		for(int i = 1; i < side.size(); i++){
			if(side.get(i).isPositive())s+=" + " + side.get(i);
			else s+= " - " + side.get(i).toString().replaceFirst("-", "");
		}
		return s;
	}

	public static Term getHighestDegreeTerm(ArrayList<Term> side){
		Term highest = new Term(0);
		for(Term a: side){
			if(a.getDegree()>highest.getDegree()){
				highest = a;
			}
		}
		return highest;
		//returns the term in the ArrayList that is the highest degree.
		//example
		//3x^2 + 4x^3 - 12x + x^2
		//will return 4x^3 
	}
	
	/**
	* NEW STUFF FOR 4.1
	*/
	/**
	* adds the additiveInverse of everything on the sideBeingCancelled
	* to both sides of the Equation
	* @param sideBeingCanceled
	*/

	public void toZeroOnOneSide(ArrayList<Term> sideBeingCanceled){
		ArrayList<Term> addIn = new ArrayList<Term>();
		for(Term t:sideBeingCanceled){
			addIn.add(t.getAddInverse());
		}
		for(Term t: addIn){
			leftSide.add(t);
			rightSide.add(t);
		}
	}



	/**
	* 
	* @param side - simplifies the specified side of the equation
	* Notes: This method should check every Term on the specified side of the equation 
	* with every other Term to check if they are like terms (use Term.areLikeTerms(Term s, Term t)
	* If they are, it should reassign the current Term to the combined result (use Term.combine(Term s, Term t)
	* and remove the one with which it combined.
	* Finally, if the resulting term has a coefficient of zero should be removed.
	* 
	* For example, Suppose side contains 5x + 3 -5x. Call the three terms a, b and c, respectively
	* 1. It checks to see if 5x and 3 (a and b) are like terms, they are not
	* 2. It checks to see if 5x and -5x (a and c) are like terms, they are
	* 3. Since 5x and -5x are like terms, a = Term.cobine(a, c) then leftSide.remove(c)
	* 4. Now side contains 0x + 3. Since term a has a coefficient of zero, remove it.
	* 5. Now side contains 3. 
	* 
	* ONE MORE NOTE: Since you will be removing items from side, use a standard for loop
	* and remember that when something is moved, everything "slides over"
	 * @return 
	*/

	public void simplify(ArrayList<Term> side){
	//Test with 4x+3=3x+2
		//3x-4=20-5x
		for(int i = 0; i < side.size(); i++){
			for(int k = 0; k < side.size(); k++){
				if(i < side.size()){
					if(i!=k){
						if(Term.areLikeTerms(side.get(i), side.get(k))){
							Term result = Term.combine(side.get(i), side.get(k));
							System.out.println("this is the result of " + side.get(i) + " and " + side.get(k) + ": " +  result);	
							side.add(1 + i, result);
							side.remove(i);
							side.remove(k);
							if(i != 0)i--;
							if(k != 0)k--;
						}
							
					}
				}
			}
		}
		for(int s = side.size() - 1; s > 0; s--){
				if(side.get(s).getCoefficient() == 0){
					side.remove(s);
				}
		}
		
		
//		for(Term t : side){
//			for(Term s: side){
//				if(t!=s && t.getCoefficient()!=0){
//					if(Term.areLikeTerms(s, t)){
//						Term result = Term.combine(s, t);
//						t.setCoefficient(result.getCoefficient());
//						s.setCoefficient(0);
//						removeThese.add(s);
//					}
//				}
//			}
//		side.removeAll(removeThese);
//		}
	}

	/**
	* 
	* @param sideWithVariable - we can assume the side with a variable is of the form ax + b
	* @return the solution
	* 
	* Example: 3x + 21 = 0
	* 1. Identify the constant term in the sideWithVariable (21)
	* 2. Identify the variable term in the sideWithVariable (3x)
	* 3. Add the additive inverse of the constant Term to both sides of the equation (3x = -21)
	* 4. Multiply both sides by the additive inverse of the coefficient of the variable term (.33333333)
	* search arraylist set.
	* set(int index, E element)
	* Replaces the element at the specified position in this list with the specified element.
	*/
	public void solveLinear(ArrayList<Term> sideWithVariable){
		//3x+4=0
		int num = sideWithVariable.size();
		for(int i = 0; i < num; i++){
			if(sideWithVariable.get(i).isConstant()){
				Term a = sideWithVariable.get(i).getAddInverse();
				rightSide.add(a);
				simplify(rightSide);
				leftSide.add(a);
				simplify(leftSide);
			}
		}
		num = sideWithVariable.size();
		for(int i = 0; i < num; i++){
			if(!sideWithVariable.get(i).isConstant()){
					Term a = leftSide.get(i).getMulInverse();
					Term b = Term.mulCombine(leftSide.get(i), a);
					Term c = Term.mulCombine(rightSide.get(i), a);
					System.out.println("this is the result of " + leftSide.get(i) + ": " +  b);
					leftSide.set(i, b);
					rightSide.set(i, c);
			}
		}
	}

	/**
	* 
	* @param side
	* @param scalar
	* multiplies all Terms on the given side by the given scalar
	* (Hint: use setCoefficient(double))
	*/
	public void multiplyScalar(ArrayList<Term> side, double scalar){
		for(Term t : side){
			t.setCoefficient(scalar * t.getCoefficient());
		}
	}	
	
	public void solveQuadratic(ArrayList<Term> side, Equation eq){
		//getHighestTerm
		//x^2 - x - 6 = 0;
		//4x^2 - 11x + 6 = 0
		//x^2 + 5x - 6=0

		//Find Discriminate

		double d = findDiscriminate(side);

		//Find a b c

		ArrayList<Term> theValues = new ArrayList<Term>();
		for(int i = 0; i < side.size(); i++){
			theValues.add(i, side.get(i));
		}

		//Term a = getHighestDegreeTerm(theValues);
		System.out.print("The size is " + theValues.size() + "\n");
		//x^2 - 4 =0
		if(theValues.size() == 3){
			Term a = getHighestDegreeTerm(theValues);
			theValues.remove(a);
			Term b = getHighestDegreeTerm(theValues);
			theValues.remove(b);
			Term c = theValues.get(0);
			//Find the factors

			double ac = a.getCoefficient()*c.getCoefficient();
			double[] Factors = factor(side, ac);
			int middle = Factors.length/2;
			double dupFactor;
			//using mod makes it so if its odd it always have a remainder of one when modding 2
			if (Factors.length%2 == 1){
				dupFactor = Factors[middle];
				System.out.print("Amount of factors are odd so there is a duplicative number, the duplicative number is " + dupFactor + " | ");
			}
			System.out.print("Discriminate is " + d);

			//Factor
			double root = Math.sqrt(d);
			if(root == (int) root && a.getCoefficient() == 1.0){
				Solver.gui.addStep("Discriminate: " + d + " is a perfect square.");
				if(d > 0.0){
					double factPairs1;
					double factPairs2;
					double[] theFactors = new double[2];
					for(int i = 0; i < Factors.length; i++){
						for(int o = i+1; o < Factors.length; o++){
							if(Factors[i]+Factors[o] == b.getCoefficient()){
								theFactors[0] = Factors[i];
								theFactors[1] = Factors[o];
							}
						} 
					}
					factPairs1 = theFactors[0];
					factPairs2 = theFactors[1];
					System.out.print("\n" + "The factor pairs are " + factPairs1 + " " +  factPairs2);
					String j = "";
					if(a.getCoefficient() == 1.0){
						if(factPairs1 > 0){
							j += "("+a.getVariable() +"+" + factPairs1 + ")";
						}
						else j += "("+a.getVariable() + factPairs1 + ")";
						if(factPairs2 > 0){
							j += "("+a.getVariable() +"+"  + factPairs2 + ")";
						}
						else j += "("+a.getVariable() + factPairs2 + ")";
						System.out.print("\n" + j);
						Solver.gui.addStep(j + " Factored");
						factPairs1 = factPairs1*-1;
						factPairs2 = factPairs2*-1;
						Solver.gui.addStep(a.getVariable() + "=" + factPairs1 + " and " + factPairs2);
					}
				}
				if(d == 0.0){
					double factPairs1;
					double factPairs2;
					double[] theFactors = new double[2];
					for(int i = 0; i < Factors.length; i++){
						for(int o = 0; o < Factors.length; o++){
							if(Factors[i]+Factors[o] == b.getCoefficient()){
								theFactors[0] = Factors[i];
								theFactors[1] = Factors[o];
							}
						} 
					}
					factPairs1 = theFactors[0];
					factPairs2 = theFactors[1];
					System.out.print("\n" + "The factor pairs are " + factPairs1 + " " +  factPairs2);
					String j = "";
					if(a.getCoefficient() == 1.0){
						if(factPairs1 > 0){
							j += "("+a.getVariable() +"+"  + factPairs1 + ")";
						}
						else j += "("+a.getVariable() + factPairs1 + ")";
						if(factPairs2 > 0){
							j += "("+a.getVariable() +"+" + factPairs2 + ")";
						}
						else j += "("+a.getVariable() + factPairs2 + ")";
						System.out.print("\n" + j);
						Solver.gui.addStep(j + " Factored");
						factPairs1 = factPairs1*-1;
						Solver.gui.addStep(a.getVariable() + "=" + factPairs1);
					}
				}		
			}
			if(root != (int) root && a.getCoefficient() == 1.0){
				//x^2-2=0
				Solver.gui.addStep("Discriminate: " + d + " is not a perfect square.");
				double root1 = (-b.getCoefficient() + Math.sqrt(Math.pow(b.getCoefficient(), 2) - 4*a.getCoefficient()*c.getCoefficient())) / (2*a.getCoefficient());
				double root2 = (-b.getCoefficient() - Math.sqrt(Math.pow(b.getCoefficient(), 2) - 4*a.getCoefficient()*c.getCoefficient())) / (2*a.getCoefficient());
				root1 = -1*root1;
				double root1S = root1*root1;
				root2 = -1*root2;
				double root2S = root2*root2;
				QuadraticForm qf = new QuadraticForm(-b.getCoefficient()+"", (b.getCoefficient()*b.getCoefficient() - 4 *(a.getCoefficient()*c.getCoefficient()))+"", 2*a.getCoefficient()+ "");
				Solver.gui.addStep(qf, "Plug in to the quadratic formula.");
				System.out.print("root squared are " + root1S + " and " + root2S);
				if((root1*root1) == (int)root1S && (root2*root2) == (int)root2S && root2*root2 == root1*root1){
					System.out.print(a + " " + b + " " + c + " and the roots are, " + root1 + " and " + root2);
					Solver.gui.addStep("x = " + " ± \u221A" + root1);
				}
				else{
					System.out.print(a + " " + b + " " + c + " and the roots are, " + root1 + " and " + root2);
					Solver.gui.addStep("x = " + root1 + " and " + root2);
				}

			}

			if(root == (int) root && a.getCoefficient() != 1.0){
				//4x^2 - 11x + 6 = 0
				int theMiddle = Factors.length/2;

				Solver.gui.addStep("This one is hard but I can try. :]");
				double factPairs1;
				double factPairs2;
				double[] theFactors = new double[2];
				for(int i = 0; i < Factors.length; i++){
					for(int o = 0; o < Factors.length; o++){
						if(c.getCoefficient() > 0){
							if(Factors[i]+Factors[o] == b.getCoefficient() && Factors[i]*Factors[o] > 0){
								theFactors[0] = Factors[i];
								theFactors[1] = Factors[o];
								System.out.print("\n" + "The factor pairs are " + theFactors[0] + " " +  theFactors[1]);
							}
						}
						if(c.getCoefficient() < 0){
							if(Factors[i]+Factors[o] == b.getCoefficient() && Factors[i]*Factors[o] < 0){
								theFactors[0] = Factors[i];
								theFactors[1] = Factors[o];
								System.out.print("\n" + "The factor pairs are " + theFactors[0] + " " +  theFactors[1]);
							}
						}
					} 
				}

				printArrayContent(theFactors);
				factPairs1 = theFactors[0];
				factPairs2 = theFactors[1];
				System.out.print("\n" + "The factor pairs are " + factPairs1 + " " +  factPairs2);
				Term theB1 = new Term (factPairs1, b.getVariable(), b.getExponent());
				Term theB2 = new Term (factPairs2, b.getVariable(), b.getExponent());
				side.add(3, c);
				side.set(1, theB1);
				side.set(2, theB2);
				Solver.gui.addStep(eq, "Split bx term.");
				System.out.print(("\n" +"Check" + theB1.getCoefficient() + "/" + a.getCoefficient() + " | " + theB1.getCoefficient()/a.getCoefficient()));
				if((theB1.getCoefficient()/a.getCoefficient()) == (int) (theB1.getCoefficient()/a.getCoefficient()) && 
						a.getExponent() > 1){
					if(theB1.getCoefficient()/a.getCoefficient() > 0){
						Term a1 = new Term (a.getCoefficient(), b.getVariable() + "(" + b.getVariable() + "+" + theB1.getCoefficient()/a.getCoefficient() + ")", b.getExponent());
						side.set(0, a1);
						side.remove(1);
					}
					else{
						Term a1 = new Term (a.getCoefficient(), b.getVariable() + "(" + b.getVariable() + theB1.getCoefficient()/a.getCoefficient() + ")", b.getExponent());
						side.set(0, a1);
						side.remove(1);
					}
				}
				else{
					if(theB1.getCoefficient()/a.getCoefficient() > 0){
						Term a1 = new Term (0 , b.getVariable() + "(" + b.getVariable() + "+" + theB1.getCoefficient()/a.getCoefficient() + ")", b.getExponent());
						side.set(0, a1);
						side.remove(1);
					}
					else{
						Term a1 = new Term (a.getCoefficient(), b.getVariable() + "(" + b.getVariable() + theB1.getCoefficient()/a.getCoefficient() + ")", b.getExponent());
						side.set(0, a1);
						side.remove(1);
					}
				}
				//			if((a.getCoefficient()/theB1.getCoefficient()) == (int) (a.getCoefficient()/theB1.getCoefficient()) && 
				//			a.getExponent() > 1){
				//				if(a.getCoefficient()/theB1.getCoefficient() > 0){
				//					Term a1 = new Term (a.getCoefficient(), b.getVariable() + "(" + b.getVariable() + "+" + a.getCoefficient()/theB1.getCoefficient() + ")", b.getExponent());
				//					side.set(0, a1);
				//					side.remove(1);
				//				}
				//				else{
				//					Term a1 = new Term (a.getCoefficient(), b.getVariable() + "(" + b.getVariable() + a.getCoefficient()/theB1.getCoefficient() + ")", b.getExponent());
				//					side.set(0, a1);
				//					side.remove(1);
				//				}
				//			}
				Solver.gui.addStep(eq, "Check");
			}
		}
		
		if(theValues.size() == 2){
			Term a = getHighestDegreeTerm(theValues);
			theValues.remove(a);
			Term c = theValues.get(0);
			Term b = new Term (0, c.getVariable(), c.getExponent());
			//Find the factors

			double ac = a.getCoefficient()*c.getCoefficient();
			double[] Factors = factor(side, ac);
			int middle = Factors.length/2;
			double dupFactor;
			//using mod makes it so if its odd it always have a remainder of one when modding 2
			if (Factors.length%2 == 1){
				dupFactor = Factors[middle];
				System.out.print("Amount of factors are odd so there is a duplicative number, the duplicative number is " + dupFactor + " | ");
			}
			System.out.print("Discriminate is " + d);

			//Factor
			double root = Math.sqrt(d);
			if(root == (int) root && a.getCoefficient() == 1.0){
				Solver.gui.addStep("Discriminate: " + d + " is a perfect square.");
				if(d > 0.0){
					double factPairs1;
					double factPairs2;
					double[] theFactors = new double[2];
					for(int i = 0; i < Factors.length; i++){
						for(int o = i+1; o < Factors.length; o++){
							if(Factors[i]+Factors[o] == b.getCoefficient() && Factors[i]*Factors[o] == c.getCoefficient()){
								theFactors[0] = Factors[i];
								theFactors[1] = Factors[o];
							}
						} 
					}
					factPairs1 = theFactors[0];
					factPairs2 = theFactors[1];
					System.out.print("\n" + "The factor pairs are " + factPairs1 + " " +  factPairs2);
					String j = "";
					if(a.getCoefficient() == 1.0){
						if(factPairs1 > 0){
							j += "("+a.getVariable() +"+" + factPairs1 + ")";
						}
						else j += "("+a.getVariable() + factPairs1 + ")";
						if(factPairs2 > 0){
							j += "("+a.getVariable() +"+"  + factPairs2 + ")";
						}
						else j += "("+a.getVariable() + factPairs2 + ")";
						System.out.print("\n" + j);
						Solver.gui.addStep(j + " Factored");
						factPairs1 = factPairs1*-1;
						factPairs2 = factPairs2*-1;
						Solver.gui.addStep(a.getVariable() + "=" + factPairs1 + " and " + factPairs2);
					}
				}
				if(d == 0.0){
					double factPairs1;
					double factPairs2;
					double[] theFactors = new double[2];
					for(int i = 0; i < Factors.length; i++){
						for(int o = 0; o < Factors.length; o++){
							if(Factors[i]+Factors[o] == b.getCoefficient()){
								theFactors[0] = Factors[i];
								theFactors[1] = Factors[o];
							}
						} 
					}
					factPairs1 = theFactors[0];
					factPairs2 = theFactors[1];
					System.out.print("\n" + "The factor pairs are " + factPairs1 + " " +  factPairs2);
					String j = "";
					if(a.getCoefficient() == 1.0){
						if(factPairs1 > 0){
							j += "("+a.getVariable() +"+"  + factPairs1 + ")";
						}
						else j += "("+a.getVariable() + factPairs1 + ")";
						if(factPairs2 > 0){
							j += "("+a.getVariable() +"+" + factPairs2 + ")";
						}
						else j += "("+a.getVariable() + factPairs2 + ")";
						System.out.print("\n" + j);
						Solver.gui.addStep(j + " Factored");
						factPairs1 = factPairs1*-1;
						Solver.gui.addStep(a.getVariable() + "=" + factPairs1);
					}
				}		
			}
			if(root != (int) root && a.getCoefficient() == 1.0){
				//x^2-2=0
				Solver.gui.addStep("Discriminate: " + d + " is not a perfect square.");
				double root1 = (-b.getCoefficient() + Math.sqrt(Math.pow(b.getCoefficient(), 2) - 4*a.getCoefficient()*c.getCoefficient())) / (2*a.getCoefficient());
				double root2 = (-b.getCoefficient() - Math.sqrt(Math.pow(b.getCoefficient(), 2) - 4*a.getCoefficient()*c.getCoefficient())) / (2*a.getCoefficient());
				root1 = -1*root1;
				double root1S = root1*root1;
				root2 = -1*root2;
				double root2S = root2*root2;
				QuadraticForm qf = new QuadraticForm(-b.getCoefficient()+"", (b.getCoefficient()*b.getCoefficient() - 4 *(a.getCoefficient()*c.getCoefficient()))+"", 2*a.getCoefficient()+ "");
				Solver.gui.addStep(qf, "Plug in to the quadratic formula.");
				System.out.print("root squared are " + root1S + " and " + root2S);
				if((root1*root1) == (int)root1S && (root2*root2) == (int)root2S && root2*root2 == root1*root1){
					System.out.print(a + " " + b + " " + c + " and the roots are, " + root1 + " and " + root2);
					Solver.gui.addStep("x = " + " ± \u221A" + root1);
				}
				else{
					System.out.print(a + " " + b + " " + c + " and the roots are, " + root1 + " and " + root2);
					Solver.gui.addStep("x = " + root1 + " and " + root2);
				}

			}

			if(root == (int) root && a.getCoefficient() != 1.0){
				//4x^2 - 11x + 6 = 0
				int theMiddle = Factors.length/2;

				Solver.gui.addStep("This one is hard but I can try. :]");
				double factPairs1;
				double factPairs2;
				double[] theFactors = new double[2];
				for(int i = 0; i < Factors.length; i++){
					for(int o = 0; o < Factors.length; o++){
						if(c.getCoefficient() > 0){
							if(Factors[i]+Factors[o] == b.getCoefficient() && Factors[i]*Factors[o] > 0){
								theFactors[0] = Factors[i];
								theFactors[1] = Factors[o];
								System.out.print("\n" + "The factor pairs are " + theFactors[0] + " " +  theFactors[1]);
							}
						}
						if(c.getCoefficient() < 0){
							if(Factors[i]+Factors[o] == b.getCoefficient() && Factors[i]*Factors[o] < 0){
								theFactors[0] = Factors[i];
								theFactors[1] = Factors[o];
								System.out.print("\n" + "The factor pairs are " + theFactors[0] + " " +  theFactors[1]);
							}
						}
					} 
				}

				printArrayContent(theFactors);
				factPairs1 = theFactors[0];
				factPairs2 = theFactors[1];
				System.out.print("\n" + "The factor pairs are " + factPairs1 + " " +  factPairs2);
				Term theB1 = new Term (factPairs1, b.getVariable(), b.getExponent());
				Term theB2 = new Term (factPairs2, b.getVariable(), b.getExponent());
				side.add(3, c);
				side.set(1, theB1);
				side.set(2, theB2);
				Solver.gui.addStep(eq, "Split bx term.");
				System.out.print(("\n" +"Check" + theB1.getCoefficient() + "/" + a.getCoefficient() + " | " + theB1.getCoefficient()/a.getCoefficient()));
				if((theB1.getCoefficient()/a.getCoefficient()) == (int) (theB1.getCoefficient()/a.getCoefficient()) && 
						a.getExponent() > 1){
					if(theB1.getCoefficient()/a.getCoefficient() > 0){
						Term a1 = new Term (a.getCoefficient(), b.getVariable() + "(" + b.getVariable() + "+" + theB1.getCoefficient()/a.getCoefficient() + ")", b.getExponent());
						side.set(0, a1);
						side.remove(1);
					}
					else{
						Term a1 = new Term (a.getCoefficient(), b.getVariable() + "(" + b.getVariable() + theB1.getCoefficient()/a.getCoefficient() + ")", b.getExponent());
						side.set(0, a1);
						side.remove(1);
					}
				}
				else{
					if(theB1.getCoefficient()/a.getCoefficient() > 0){
						Term a1 = new Term (0 , b.getVariable() + "(" + b.getVariable() + "+" + theB1.getCoefficient()/a.getCoefficient() + ")", b.getExponent());
						side.set(0, a1);
						side.remove(1);
					}
					else{
						Term a1 = new Term (a.getCoefficient(), b.getVariable() + "(" + b.getVariable() + theB1.getCoefficient()/a.getCoefficient() + ")", b.getExponent());
						side.set(0, a1);
						side.remove(1);
					}
				}
				//			if((a.getCoefficient()/theB1.getCoefficient()) == (int) (a.getCoefficient()/theB1.getCoefficient()) && 
				//			a.getExponent() > 1){
				//				if(a.getCoefficient()/theB1.getCoefficient() > 0){
				//					Term a1 = new Term (a.getCoefficient(), b.getVariable() + "(" + b.getVariable() + "+" + a.getCoefficient()/theB1.getCoefficient() + ")", b.getExponent());
				//					side.set(0, a1);
				//					side.remove(1);
				//				}
				//				else{
				//					Term a1 = new Term (a.getCoefficient(), b.getVariable() + "(" + b.getVariable() + a.getCoefficient()/theB1.getCoefficient() + ")", b.getExponent());
				//					side.set(0, a1);
				//					side.remove(1);
				//				}
				//			}
				Solver.gui.addStep(eq, "Check");
			}
		}
//		double root1 = (-b.getCoefficient() + Math.sqrt(Math.pow(b.getCoefficient(), 2) - 4*a.getCoefficient()*c.getCoefficient())) / (2*a.getCoefficient());
//		double root2 = (-b.getCoefficient() - Math.sqrt(Math.pow(b.getCoefficient(), 2) - 4*a.getCoefficient()*c.getCoefficient())) / (2*a.getCoefficient());
//		root1 = -1*root1;
//		root2 = -1*root2;
//		QuadraticForm qf = new QuadraticForm(-b.getCoefficient()+"", (b.getCoefficient()*b.getCoefficient() - 4 *(a.getCoefficient()*c.getCoefficient()))+"", 2*a.getCoefficient()+ "");
//		Solver.gui.addStep(qf, "Plug in to the quadratic formula.");
//		System.out.print(a + " " + b + " " + c + " and the roots are, " + root1 + " and " + root2);
//		Solver.gui.addStep("x = " + root1 + " and " + root2);
	}
	public static void printArrayContent(double[] array) {
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
		System.out.println(arrayContent);
	}
	public double findDiscriminate(ArrayList<Term> side){
//		a = 4, b = -11, c = 6
//		d = b^2 - 4ac;
//      d = -11^2 - 4(4)(6)
//		d = 25
//		d = + 2 sol | d = 0 1 sol | d = - no sol
		ArrayList<Term> theValues = new ArrayList<Term>();
		for(int i = 0; i < side.size(); i++){
			theValues.add(i, side.get(i));
		}
		Term a = getHighestDegreeTerm(theValues);
		theValues.remove(a);
		Term b = getHighestDegreeTerm(theValues);
		theValues.remove(b);
		Term c = theValues.get(0);
		double d = ((b.getCoefficient()*b.getCoefficient()) - (4*(a.getCoefficient()*c.getCoefficient())));
		return d;
		
	}
	
	public double[] factor(ArrayList<Term> side, double ac){
		//factor, again passing the eq.leftSide
		//factor%i == 0
		//if mod num and 0 its the zero.
		//4x^2 - 11x + 6 = 0
		double[] factor = new double[100];
		int counter = 99;
		for(int i = 1; i < 100; i++){
			if(ac % i == 0){
				System.out.print(i + " is a factor of " + ac + " | ");
				factor[i] = i;
			}
			else{
				counter--;
				factor[i] = 0;
			}
		}
		System.out.print("The counter is " + counter + " | ");
		int newCounter = 0;
		double[] newFactor = new double[(counter*2)];
		for(int k = 1; k < 100; k++){
			if(factor[k] != 0){
				newFactor[newCounter] = factor[k];
				System.out.print(newFactor[newCounter] + " | ");
				newCounter++;
			}
		}
		System.out.print("New Counter is " + newCounter + " | ");
		int negCounter = 0;
		for(int y = newCounter; y < counter*2; y++){
			newFactor[y] = newFactor[negCounter] * -1;
			System.out.print(newFactor[y] + " | ");
			negCounter++;
		}
		return newFactor;
	}
	
}
