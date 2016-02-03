package cmpt213_hw2;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Command extends Command_Info implements Entries {
	
	int day = 1; //begin day
	
	String[] CommandList()throws FileNotFoundException{
		File CommandFile = new File("commands.txt");
		Scanner scan = new Scanner(CommandFile);
	
		String str = scan.nextLine();   		//change '2' into string
		int numCommands = Integer.parseInt(str); 
		
		//creates an array to hold each command//
		
		String [] cmdlist = new String[numCommands];
		
		//for loop to scan and store each command in the array//
		
		for(int i = 0; i < numCommands; i++){
			cmdlist[i] = scan.nextLine();
		}
		
		//System.out.println(Arrays.toString(cmdlist));
		scan.close();
		
		return cmdlist;
	}
	
	public void end_of_day(int n ){
		
		
	}

	

}