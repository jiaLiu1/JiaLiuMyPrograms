package myAbstratEx;

import java.util.ArrayList;

public interface Guns{
	gunStats pistolGradeC1 = new gunStats("USP", 10, 20, 42);
	gunStats pistolGradeC2 = new gunStats("KvA", 10, 20, 43);
	
	gunStats[] Pistol = { pistolGradeC1, pistolGradeC2};
	
	final ArrayList<gunStats> Pistols = new ArrayList<gunStats>();
	
	public void printDamage(gunStats gun);
	public void printStats(gunStats gun);
}
