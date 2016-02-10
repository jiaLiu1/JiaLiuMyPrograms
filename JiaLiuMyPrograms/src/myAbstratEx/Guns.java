package myAbstratEx;

import java.util.ArrayList;

public interface Guns{
	gunStats gun1 = new gunStats("USP", 10, 20, 42);
	gunStats gun2 = new gunStats("KvA", 10, 20, 43);
	
	final ArrayList<gunStats> Pistols = new ArrayList<gunStats>();
	
	public void printDamage(gunStats gun);
}
