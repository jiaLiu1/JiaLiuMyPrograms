package myAbstratEx;

public class gunStats extends Gun{
	private int damage;
	
	public gunStats(String nameOfGun, int ammoCapacity, int totalAmmo, int damage) {
		super(nameOfGun, ammoCapacity, totalAmmo);
		this.damage = damage;
		//setDamage(damage);
	}

	public void damageCheck()
	{
		System.out.println("The gun: " + getNameOfGun()
				+ "\n" + "Damage: " + damage);
	}
	
	public int getDamage()
	{
		return damage;
	}
	
//	public void setDamage(int newDamage)
//	{
//		damage = newDamage;
//	}
	
	
	public int computeDamage()
	{
		System.out.println("Setting damage of " + getNameOfGun());
		return damage;
	}
}
