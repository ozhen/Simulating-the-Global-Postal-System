package cmpt213_hw2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Wanted implements Name{
	String name;
	int numWanted;
	//String[] list;
	
	public String[] WantedList()throws FileNotFoundException{
		File WantedFile = new File("wanted.txt");
		Scanner scan = new Scanner(WantedFile);
	
		String str = scan.nextLine();   		//change '2' into string
		numWanted = Integer.parseInt(str); 
		
		//creates an object array to hold each office info//			
		String[] list = new String[numWanted];
		
		//for loop to scan and store each command in the array//
		
		for(int i = 0; i < numWanted; i++){
				str = scan.nextLine();		//read lines 
				list[i]=str;
				
		}
		scan.close();
		return list;
	}
	
	public String getName(){return name;}
	public void setName(String n){name = n;}
	
}
