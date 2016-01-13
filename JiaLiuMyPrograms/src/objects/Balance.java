package objects;

public class Balance {
	private double amount;
	private long lastWorked;
	
	public Balance(){
		amount = 0.0;
		lastWorked = 0;
	}
	public double getAmount() {		
		return (Math.round(amount * 100.0)/100.0);
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public long getLastWorked() {
		return lastWorked;
	}

	public void setLastWorked(long lastWorked) {
		this.lastWorked = lastWorked;
	}

	public void subtractLateFees(int timeOverdue){
		if(timeOverdue > 1){
			amount = amount - timeOverdue;
		}
	}
	
	public Boolean canWork(long time){
		if((time - lastWorked)/1000 > 10 ){
			return true;
		}
		return false;
	}
	
	public String earnMoney(long time){
		if(canWork(time)){
			amount = amount + 5.0;
			lastWorked = time;
			return "did some work at the library and earned $5";
		}
		else{
			return "can not do a double shift! Wait until the first job is done!";
		}
	}
}
