package myAbstratEx;

import java.util.ArrayList;

public class GunRack implements Guns{
	
	public static void main(String[] args){
		Gun gun1 = new gunStats("M1911", 7, 14, 45);
//		Gun gun2 = new Gun("USP", 10, 20, 42);
//		Gun gun3 = new Gun("M4A1", 31, 93, 39);
		
//		gunStats gun1 = new gunStats("M1911", 7, 14, 45);
		final gunStats gun2 = new gunStats("USP", 10, 20, 42);
//		gunStats gun3 = new gunStats("M4A1", 31, 93, 39);
		
		final ArrayList<gunStats> Pistols = new ArrayList<gunStats>();
		
		Pistols.add(gun2);
		
		System.out.println("Gun 1");
		//gun1.computeDamage();
		gun1.damageCheck();

	    System.out.println("\n" + "Gun 2");
	    gun2.computeDamage();
	    gun2.damageCheck();
	}

	public void printDamage(gunStats gun) {
		// TODO Auto-generated method stub
		
	}
	
}
