package cmpt213_hw2;

public abstract class Command_Info {
	
	int money,length;
	String returnTo;
	String srcOff, dstOff;
	String type;
	
	public String getCommandType(){return type;}
	public void setCommandType(String t){type = t;}
	
	public String getSrcOffice(){return srcOff;}
	public  void setSrcOffice(String src){srcOff = src;}
	
	public String getDstOffice(){return dstOff;}
	public  void setDstOffice(String dst){dstOff = dst;}
	
	public String getReturnTo(){return returnTo;}
	public void setReturnTo(String r){ returnTo = r;}
	
	public int getMoney(){return money;}
	public void setMoney(int m){ money = m;}
	
	public int getPackageLength(){return length;}
	public void setPackageLength(int l){length = l;}
	
	
	
}
