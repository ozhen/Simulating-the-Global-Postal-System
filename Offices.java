package cmpt213_hw2;

public class Offices implements Offices_Info {
	String name = " ";
	int time,postage,capacity,amt,maxLength = 0;
	
	public String getName(){return name;}
	public void setName(String n){name = n;}
	
	public int getTime(){return time;}
	public void setTime(int t){time = t;}
	
	public int getPostage(){return postage;}
	public void setPostage(int p){postage = p;}
	
	public int getCapacity(){return capacity;}
	public void setCapacity(int c){capacity = c;}
	
	public int getAmt(){return amt;}
	public void setAmt(int a){amt = a;}
	
	public int getmaxLength(){return maxLength ;}
	public void setmaxLength(int m){maxLength = m;}
}
