package objects;

import java.util.ArrayList;

import myAbstratEx.Gun;
import myAbstratEx.Guns;
import myAbstratEx.gunStats;

public class Gunss implements Guns{

	/**
	 * @param args
	 */
	public gunStats getGun(gunStats gun){
		return gun;
	}
	
	public void printDamage(gunStats gun) {
		System.out.println(gun.getDamage());
	}
	
	public static void main(String[] args) {
		Guns obj = new Gunss();
		//Pistols.add(gun2);
		//Pistols.add(gun1);
		obj.printDamage(gun1);
		obj.printDamage(gun2);
	}

}
