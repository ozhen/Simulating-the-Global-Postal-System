package cmpt213_hw2;

public abstract class Command_Info {
	
	String 
	
	
	public abstract String getSrcOffice();
	public abstract void setSrcOffice(String n);
	
	public abstract String getDstOffice();
	public abstract void setDstOffice(String n);
	
	public abstract String getRecipient();
	public abstract void setRecipient(String n);
	
	public abstract int getMoney();
	public abstract void setMoney(int m);
	
	public abstract int getPackageLength();
	public abstract void setPackageLength(int l);
	
}
