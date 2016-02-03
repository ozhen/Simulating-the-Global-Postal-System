package cmpt213_hw2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class A2 {
	
	public static void main(String[] args) throws FileNotFoundException
	{
		PrintWriter log_master = new PrintWriter("log_master.txt");
		//PrintWriter log_front = new PrintWriter("log_front.txt");
		
		
		/* read offices.txt to get the offices info */
		File OfficesFile = new File("offices.txt");
		Scanner scanOffices = new Scanner(OfficesFile);
		
		//store # of offices into txt file
		
		String str = scanOffices.nextLine();   		//change '2' into string
		int numOffices = Integer.parseInt(str);
		System.out.println("# of offices: " + Integer.toString(numOffices) );
		
		
		//Objects array to store each office's information
		Offices [] off = new Offices[numOffices];
		PrintWriter[] log = new PrintWriter[numOffices];
		/*
		PrintWriter log_Burnaby = new PrintWriter("log_Burnaby.txt");
		PrintWriter log_Vancouver = new PrintWriter("log_Vancouver.txt");
		*/
		
		for(int i = 0; i < numOffices; i++){
			off[i] =new Offices();
			str = scanOffices.nextLine();		//read lines 
			String[] data = str.split(" ");		//split the space
			off[i].setName(data[0]);
			off[i].setTime(Integer.parseInt(data[1]));
			off[i].setPostage(Integer.parseInt(data[1]));
			off[i].setCapacity(Integer.parseInt(data[1]));
			off[i].setAmt(Integer.parseInt(data[1]));
			off[i].setmaxLength(Integer.parseInt(data[1]));	
			
			//needs to find a way to create log_X where X is the name of the office
			String tempTxt = "log_" + off[i].getName() +  ".txt";
			log[i] = new PrintWriter(tempTxt);
			//PrintWriter log = new PrintWriter(tempTxt);
		}
			
		/*Scanner for commands.txt*/	
		File CommandsFile = new File("commands.txt");
		Scanner scanCommands = new Scanner(CommandsFile);
		
		str = scanCommands.nextLine();   		//change '2' into string
		int numCommands = Integer.parseInt(str);
		System.out.println("# of commands: " + Integer.toString(numCommands) );
		int day = 1; //First day
		
		
		/*For loop to check all the commands*/
		for(int k = 0; k < numCommands; k ++){
			str = scanCommands.nextLine();
			
			if(str.equals("DAY")){	
				log[0].println("- - DAY " + day + " OVER - -");
				log[1].println("- - DAY " + day + " OVER - -");
				log_master.println("- - DAY " + day + " OVER - -");
				day++;	
			}
			
		}
		//check Command class // 
		Command cmd = new Command();
		String [] abc = cmd.CommandList();
		
		System.out.println(Arrays.toString(abc));
		
		scanOffices.close();
		scanCommands.close();
		log[0].close();
		log[1].close();
		log_master.close();

	}
}
