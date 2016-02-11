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
	
	public void printStats(gunStats gun){
		System.out.print(gun.getNameOfGun() + " [Ammo:" + gun.getAmmoCapacity() + "/" + gun.getTotalAmmo() + "]");
	}
	
	public static void main(String[] args) {
		Guns obj = new Gunss();
		//Pistols.add(gun2);
		//Pistols.add(gun1);
		obj.printDamage(Pistol[0]);
		obj.printDamage(pistolGradeC2);
		obj.printStats(pistolGradeC2);
	}

}
