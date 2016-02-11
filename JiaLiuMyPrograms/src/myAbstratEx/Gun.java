package myAbstratEx;

public abstract class Gun {
	private String nameOfGun;
	private int ammoCapacity;
	private int totalAmmo;
	
	public Gun(String nameOfGun, int ammoCapacity, int totalAmmo)
	{
		this.nameOfGun = nameOfGun;
		this.ammoCapacity = ammoCapacity;
		this.totalAmmo = totalAmmo;
	}
	
//	public int computeDamage()
//	{
//		System.out.println("Inside Gun computeDamage");
//		return 0;
//	}
	
	public void damageCheck()
	{
		System.out.println("Checking damage of " + this.nameOfGun);
	}
	   
	public String getNameOfGun() {
		return nameOfGun;
	}
	
//	public void setNameOfGun(String nameOfGun) {
//		this.nameOfGun = nameOfGun;
//	}
//	
	public int getAmmoCapacity() {
		return ammoCapacity;
	}
//	
//	public void setAmmoCapacity(int ammoCapacity) {
//		this.ammoCapacity = ammoCapacity;
//	}
//	
	public int getTotalAmmo() {
		return totalAmmo;
	}
//	
//	public void setTotalAmmo(int totalAmmo) {
//		this.totalAmmo = totalAmmo;
//	}
	
	public abstract int computeDamage();
	
	public String toString(){
		return nameOfGun + " [Ammo:" + ammoCapacity + "/" + totalAmmo + "]";
	}
}
