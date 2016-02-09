package cmpt213_hw2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Entries implements Name{

	String name= " ";
	int day = 1;
	String[] logList;
	
		
	//creates all the text files
	public PrintWriter[] startUp() throws FileNotFoundException{
		
		Offices off = new Offices();
		Offices [] offList = off.OfficeList();
		
		//create PrintWriter[] 
		PrintWriter[] log = new PrintWriter[offList.length +2];
		
		//loglist to track the names of the offices
		logList = new String[offList.length +2];
		
		log[0] = new PrintWriter("log_front.txt");
		logList[0] = "front";
		
		log[1] = new PrintWriter("log_master.txt");
		logList[1] = "master";
			
		for(int i = 2; i < offList.length + 2; i++){
			
			String temp = "log_" + offList[i-2].getName();
			String tempTxt = temp  +  ".txt";
			logList[i] = offList[i-2].getName();
			
			log[i] = new PrintWriter(tempTxt);
			
		}
		
		return log;
	}
	
	public void checkCommand(PrintWriter[] arr) throws FileNotFoundException{
		
		Command cmd = new Command();
		Command [] cmdList = cmd.CommandList();
		
		Offices off = new Offices();
		Offices [] offList = off.OfficeList();
		
		Wanted wt = new Wanted();
		String[] wantedList = wt.WantedList();
		
		for(int i = 0; i < cmdList.length; i++){
			
			if(cmdList[i].getCommandType().equals("DAY")){
				//if arrive
			/*	for(int idx = 2; idx < logList.length; idx++){
					if(this.day == (offList[i].getTime()+1)){
						itemArrived(arr[idx]);
					}
				} */
				endDay(arr,this.day);	//writes in ALL logs except front
			}
			
			else if(cmdList[i].getCommandType().equals("PICKUP")){
				
				/*
				for(int idx = 2; idx < logList.length; idx++){
					//check office name and pick up person's name
					if(logList[idx].equals(cmdList[i].getSrcOffice())   )
				}
				*/
				
				//2.6.1
				
				
				//2.6.3
				for(int idx = 0; idx < wantedList.length; idx++){
					if(cmdList[i].getName().equals(wantedList[idx])){
						criminalApprehended(arr[0]);
					}
				}
				
			}
			
			//if it is letter
			else if(cmdList[i].getCommandType().equals("LETTER")){
				boolean isFoundDst = false;
				boolean isFoundWanted = false;
				
				
				//find criminals
				for(int idx = 0; idx < wantedList.length; idx++){
					if(wantedList[idx].equals(cmdList[i].getName())){
						isFoundWanted = true;
						break;
					}
				}
				
				//find dstOffice
				for(int idx = 2; idx < logList.length; idx++){
					if(logList[idx].contains(cmdList[i].getDstOffice())){
						isFoundDst = true;
						break;
					}
				}
				
				
				
				for(int idx = 2; idx < logList.length; idx++){
					//if file name == source office name from command

					if(logList[idx].equals(cmdList[i].getSrcOffice())){
						//new letter, calls itemNew()
						itemNew(arr[idx],cmdList[i],cmdList[i].getCommandType());
						
						if(isFoundDst == false || isFoundWanted == true){
							itemRejected(arr[idx],cmdList[i].getCommandType(),cmdList[i].getSrcOffice());
							itemRejected(arr[1],cmdList[i].getCommandType(),cmdList[i].getSrcOffice());
							break;
						}
						
						else{	
							itemAcceptance(arr[idx],cmdList[i],offList,cmdList[i].getCommandType());
							//itemSent(arr[idx]);
						}
					}	
				}	
			}
			
			//package
			else{
				int idx=0;
				boolean isFoundDst = false;
				boolean isFoundWanted = false;
				boolean isEnoughMoney = true;
				boolean isOverLength = false;
				boolean isEnoughSpace = true;
				
				//check if dstOffice exists 2.3.1
				for(idx = 2; idx < logList.length; idx++){
					if(logList[idx].contains(cmdList[i].getDstOffice())){
						isFoundDst = true;
						break;
					}
				}
				
				//check if recipient == criminal 2.3.2
				for(idx = 0; idx < wantedList.length; idx++){
					if(cmdList[i].getName().equals(wantedList[idx])){
						isFoundWanted = true;
						break;
					}
				}
				
				//check if enough money  2.3.3
				for(idx = 0; idx < offList.length; idx++){
					
					if(cmdList[i].getMoney() < offList[idx].getPostage()){
						isEnoughMoney = false;
						break;
					}
				}
				
				//2.3.4 check if there's package over length
				for(idx = 0; idx < offList.length; idx++){
					//if srcOffice matches
					if(cmdList[i].getSrcOffice().equals(offList[idx].getSrcOffice())){
						//if package's length over DstOffice's max
						if(offList[idx].getmaxLength() < cmdList[i].getPackageLength()){
							isOverLength = true;
							break;
						}
					}
				}
				
				//2.3.5 check if there's package over length
				for(idx = 0; idx < offList.length; idx++){
					if(cmdList[i].getDstOffice().equals(offList[idx].getDstOffice())){
						//if package's length over DstOffice's max
						if(offList[idx].getmaxLength() < cmdList[i].getPackageLength()){
							isOverLength = true;
							break;
						}
					}	
				}
				
				//2.3.6 check if there's enough Capacity
				for(idx = 0; idx < offList.length; idx++){
					//if srcOffice matches
					if(cmdList[i].getSrcOffice().equals(offList[idx].getSrcOffice())){
						if(offList[idx].getCapacity() < 1){
							isEnoughSpace = false;
							break;
						}
					}		
				}
				
				for(idx = 2; idx < logList.length; idx++){
					
					//if file name == source office name from command
					if(logList[idx].equals(cmdList[i].getSrcOffice())){
						
						//new package
						itemNew(arr[idx],cmdList[i],cmdList[i].getCommandType());
						
						//2.4.3 if over size but able to pay postage and extra cost
						if(cmdList[i].getMoney() >= (offList[idx-2].getPostage()+offList[idx-2].getAmt())){
							briberyDetected(arr[1],offList[idx-2].getName());
							itemNew(arr[idx],cmdList[i],cmdList[i].getCommandType());
							itemAcceptance(arr[idx],cmdList[i],offList,cmdList[i].getCommandType());
							//itemSent(arr[idx]);
							break;
						}	
						
						//call itemRejected if dstOffice is non-existed 
						if(isFoundDst == false || isFoundWanted == true || isEnoughMoney == false || isEnoughSpace == false|| isOverLength == true){			
							itemRejected(arr[idx],cmdList[i].getCommandType(),cmdList[i].getSrcOffice());
							itemRejected(arr[1],cmdList[i].getCommandType(),cmdList[i].getSrcOffice());
							break;	
						}
						
						itemAcceptance(arr[idx],cmdList[i],offList,cmdList[i].getCommandType());
						
						//itemSent(arr[idx]);			 	
					}			
				}
			}
		}// for loop for cmdList
		
	} // end checkCommands
	
	//2.1
	public void endDay(PrintWriter[] arr, int n){
		for(int k = 1; k < arr.length; k++)
			arr[k].println("- - DAY "+  n  + " OVER - -");
		this.day++;
	}
	
	//2.2
	public void itemNew(PrintWriter arr, Command cmd, String item){
		
		if(item.equals("LETTER")){
			arr.println("- New LETTER -");
			arr.println("Source: " + cmd.getSrcOffice());
			arr.println("Destination: " + cmd.getDstOffice());
		}
		
		else{
			arr.println("- New PACKAGE -");
			arr.println("Source: " + cmd.getSrcOffice());
			arr.println("Destination: " + cmd.getDstOffice());
		}
	}
	
	//2.4
	public void itemAcceptance(PrintWriter arr, Command cmd, Offices[] off, String item){
		
		//2.4.1
		if(item.equals("LETTER")){
			for(int i = 0; i < off.length; i++){
				if(cmd.getDstOffice().equals( off[i].getName())){
					arr.println("- Accepted LETTER -");
					arr.println("Destination: " + cmd.getDstOffice());
					break;
				}
				
			}
		}
		//2.4.2 and 2.4.3 unfinished
		else{
			for(int i = 0; i < off.length; i++){
				if(cmd.getDstOffice().equals( off[i].getName())){
					arr.println("- Accepted PACKAGE -");
					arr.println("Destination: " + cmd.getDstOffice());
					break;
				}
				
			}
		}
	}
	
	public void itemRejected(PrintWriter arr, String item, String src){
		
		if(item.equals("LETTER")){
			arr.println("- Rejected Letter -");
			arr.println("Source: " + src);
		}
		else{
			arr.println("- Rejected package -");
			arr.println("Source: " + src);
		}
		
	}
	
	//Test 2.4.3 Completed (3.10)
		public void briberyDetected(PrintWriter arr, String s){
			arr.println("- Something funny going on...");
			arr.println("Where did that extra money at " + s + " come from?");
		}
	
	//3.12
	public void itemSent(PrintWriter arr){
		arr.println("- Standard transit departure -");
	}
	
	public void packageDestroyed(PrintWriter arr, String dst){
		arr.println("- Incinerated package -");
		arr.println("Destroyed at: " + dst);
	}
	
	//2.6.3
	public void criminalApprehended(PrintWriter arr){
		arr.println("- Nice Try Mr.Criminal. Please Try again after you take CMPT 213 -");
	}
	
	//
	public void itemArrived(PrintWriter arr){
		arr.println("- Standard transit arrival -");
	}
	
	public void itemCompleted(PrintWriter arr, int n){
		arr.println("- Delivery process complete -");
		arr.println("Delivery took " + n + " days.");
	}
	
	public void close(PrintWriter[] arr){
		for(int idx = 0; idx < arr.length; idx++)
		arr[idx].close();
		} 	
	public String getName(){return name;}
	public void setName(String n){name = n;}
}
