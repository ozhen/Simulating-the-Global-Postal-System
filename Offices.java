package cmpt213_hw2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Offices extends Info implements Offices_Info,Name {
	String name = " ";
	int time,postage,capacity,amt,maxLength = 0;
	int numOffices = 0;
	int items = 0;
	
	 public Offices[] OfficeList()throws FileNotFoundException{
			File OfficeFile = new File("offices.txt");
			Scanner scan = new Scanner(OfficeFile);
		
			String str = scan.nextLine();   		//change '2' into string
			numOffices = Integer.parseInt(str); 
			
			//creates an object array to hold each office info//			
			Offices [] abc = new Offices[numOffices];
			
			//for loop to scan and store each command in the array//
			
			for(int i = 0; i < numOffices; i++){
					abc[i] =new Offices();
					str = scan.nextLine();		//read lines 
					String[] data = str.split(" ");		//split the space
					abc[i].setName(data[0]);
					abc[i].setTime(Integer.parseInt(data[1]));
					abc[i].setPostage(Integer.parseInt(data[2]));
					abc[i].setCapacity(Integer.parseInt(data[3]));
					abc[i].setAmt(Integer.parseInt(data[4]));
					abc[i].setmaxLength(Integer.parseInt(data[5]));
			}
			scan.close();
			return abc;
		}
	
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
