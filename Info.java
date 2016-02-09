package cmpt213_hw2;

public abstract class Info {
	
	String srcOff, dstOff;
	
	public abstract String getName();
	public abstract void setName(String n);
	
	
	public String getSrcOffice(){return srcOff;}
	public  void setSrcOffice(String src){srcOff = src;}
	
	public String getDstOffice(){return dstOff;}
	public  void setDstOffice(String dst){dstOff = dst;}
	
	
	
	/*
	public abstract String getRecipient();
	public abstract void setRecipient(String rec);
	
	public abstract int getMoney();
	public abstract void setMoney(int m);
	
	public abstract int getPackageLength();
	public abstract void setPackageLength(int l);
	
	*/
}
