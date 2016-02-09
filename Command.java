package cmpt213_hw2;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Command extends Command_Info implements Name{
	String name= " ";
	int day = 1; //begin day
	int numCommands;
	Entries en = new Entries();
	
	 public Command[] CommandList()throws FileNotFoundException{
		 
		File CommandFile = new File("commands.txt");
		Scanner scan = new Scanner(CommandFile);
	
		String str = scan.nextLine();   		
		numCommands = Integer.parseInt(str); 
		
		//creates an array to hold each command//
		
		Command [] cmdlist = new Command[numCommands];
		
		//for loop to scan and store each command in the array//
		
		for(int i = 0; i < numCommands; i++){
			
			cmdlist[i] =new Command();
			str = scan.nextLine();		//read lines 
			String[] data = str.split(" ");		//split the space
			
			//if conditions
			if(data[0].equals("DAY")){
				cmdlist[i].setCommandType(data[0]);
				//call write();
			}
			
			else if(data[0].equals("PICKUP")){
				cmdlist[i].setCommandType(data[0]);
				cmdlist[i].setSrcOffice(data[1]);
				cmdlist[i].setName(data[2]);
			} 
			
			else if(data[0].equals("PACKAGE")){
				cmdlist[i].setCommandType(data[0]);
				cmdlist[i].setSrcOffice(data[1]);
				cmdlist[i].setName(data[2]);
				cmdlist[i].setDstOffice(data[3]);
				cmdlist[i].setMoney(Integer.parseInt(data[4]));
				cmdlist[i].setPackageLength(Integer.parseInt(data[5]));
			}
			
			//Letter
			else{
				cmdlist[i].setCommandType(data[0]);
				cmdlist[i].setSrcOffice(data[1]);
				cmdlist[i].setName(data[2]);
				cmdlist[i].setDstOffice(data[3]);
				cmdlist[i].setReturnTo(data[4]);
			}		
		}
		scan.close();
		return cmdlist;
	}
	 
	public String getName(){return name;}
	public void setName(String n){name = n;}

}