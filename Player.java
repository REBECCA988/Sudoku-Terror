import java.util.*;
import java.lang.*;
import java.io.*; //for try catch exceptions

public class Player {
	private String username ;
	
	public Player(String name) {
		//add checkname method here and try/catch exception
		this.username = name ;
		
    } // constructor
	
	public String toString() {
		return this.username ; 
	} //toString	
	
	public int FileLength()  {
		try {
      		File myObj = new File("Times.csv");
      		Scanner in = new Scanner(myObj);
			int cnt = 0 ;
      		while (in.hasNextLine()) {
				cnt ++ ;
				String data = in.nextLine();
				String [] info = data.split(",") ;
			} 
			in.close();
			return cnt ;

		} //try
		catch (FileNotFoundException e) {
      		System.out.println("An error occurred.");
      		e.printStackTrace();
			return 0 ;
    		} //catch
			
	} //file length	
		
	public String AddTime(double time) {
    	try {
				String newtime = normalise(time) ;
				FileWriter myWriter = new FileWriter("Times.csv", true);
				myWriter.write(this.username + "," + newtime + "\n" ); //add level to input that goes into file
				myWriter.close();
				return newtime ;
				
			} 
			catch (IOException e) {
				return "An error occurred.";
				//e.printStackTrace();
    		}
  	} //addTime
	
	public void TopThreeTimes() { //will return list or array , still in progress
		try {
      		File myObj = new File("Times.csv");
      		Scanner in = new Scanner(myObj);
			String [] TopTimes =  new String [6] ;
			int i = 0 ;
			Sort() ;
			System.out.println("TOP THREE TIMES FOR: " + this.username) ;
      		while (in.hasNextLine() && i < 3) {
        			String data = in.nextLine();
					String [] info = data.split(",") ;
					if ((info[0].toLowerCase()).equals(this.username.toLowerCase())) {
						i ++ ;
						System.out.println(i + "." + info[0] + " " + info[1])  ;
					} //if		
      		} //while
			in.close();
    		} //try
		catch (FileNotFoundException e) {
      		System.out.println("An error occurred.");
			System.out.println("If new player: You do not have player details yet");
      		//e.printStackTrace();
    		} //catch

	} //topthreetimes for this.username
	
	public void ScoreBoard() {
		try {
      		File myObj = new File("Times.csv");
      		Scanner in = new Scanner(myObj);
			int i = 0 ;
			System.out.println("SCOREBOARD") ;
			System.out.println("----------") ;
			Sort() ;
      		while (in.hasNextLine()) {
				i ++ ;
        		String data = in.nextLine();
				String [] info = data.split(",") ;
				System.out.println(i + ". " + info[0] + " " + info[1] ) ;						
      		} //while
						
			in.close();
		} //try
		catch (FileNotFoundException e) {
      		System.out.println("An error occurred.");
			//System.out.println("If new player: You do not have player details yet");
      		//e.printStackTrace();
    		} //catch
	} //scoreboard
	
	public void getTimes() {
		try {
      		File myObj = new File("Times.csv");
      		Scanner in = new Scanner(myObj);
			int i = 0 ;
			System.out.println("ALL GAME TIMES FOR: " + this.username) ;
			Sort() ;
      		while (in.hasNextLine()) {
        			String data = in.nextLine();
					String [] info = data.split(",") ;
					if ((info[0].toLowerCase()).equals(this.username.toLowerCase())) {
						i ++ ;
						System.out.println(i + ". " + info[0] + " " + info[1] ) ;			
					} //if				
      		} //while
						
			in.close();
		} //try
		catch (FileNotFoundException e) {
      		System.out.println("An error occurred.");
			System.out.println("If new player: You do not have player details yet");
      		//e.printStackTrace();
    		} //catch				
	} //getTimes	

	public boolean CheckName(String name){
		if (name.length() > 10) {
			return false ;
		} //if
		
		try {
      		File myObj = new File("Times.csv");
      		Scanner in = new Scanner(myObj);
			int i = 0 ;
      		while (in.hasNextLine()) {
        			String data = in.nextLine();
					String [] info = data.split(",") ;
					if ((info[0].toLowerCase()).equals(name.toLowerCase())) {
						return false ;
					} //if	
						
      		} //while
			in.close();
    		} //try
		catch (FileNotFoundException e) {
      		System.out.println("An error occurred.");
      		e.printStackTrace();
    		} //catch
			
		this.username = name ;	
		return true ;	
	} //CheckName
	
	public boolean CheckExistingName(String name){
		try {
      		File myObj = new File("Times.csv");
      		Scanner in = new Scanner(myObj);
			int i = 0 ;
      		while (in.hasNextLine()) {
        			String data = in.nextLine();
					String [] info = data.split(",") ;
					if ((info[0].toLowerCase()).equals(name.toLowerCase())) {
						this.username = name ;
						return true ;
					} //if				
      		} //while
			in.close();
    		} //try
		catch (FileNotFoundException e) {
      		System.out.println("An error occurred.");
      		e.printStackTrace();
    		} //catch
					
		return false ;		

	} //CheckExistingName
	
	
	public String normalise(double seconds) {
		int minute = 0 ;
		int hour = 0 ;
		
		while (seconds >= 60) {
			seconds -= 60.0 ;
			minute += 1 ;
		}	
		
		while (minute >= 60) {
			minute -= 60 ;
			hour += 1 ;
		}	
		
		double roundDbl = Math.round(seconds*100.0)/100.0;
		String t = "" ;
		if ((minute < 10) && (roundDbl < 10) ){
			t = hour + ":0"  + minute + ":0" + roundDbl ;
		} else if (minute < 10) {
			t = hour + ":0"  + minute + ":" + roundDbl ;
		} else if (roundDbl < 10) {
			t = hour + ":"  + minute + ":0" + roundDbl ;
		}	
		return t ;
		
	}//normalise
	
	public void Sort() { 
		try {
      		File myObj = new File("Times.csv");
      		Scanner in = new Scanner(myObj);
			String [] sort = new String[FileLength()];
			String [] name = new String[FileLength()] ;
			int i = 0 ;
      		while (in.hasNextLine()) {
        			String data = in.nextLine();
					String [] info = data.split(",") ;
					sort[i] = info[1] + "," + info[0]  ;
					i ++ ;			
      		} //while
			
			//sort
			Arrays.sort(sort) ;
			
			for (int r = 0 ; r < sort.length ; r++) {
				String [] s1 = sort[r].split(",") ;
				name[r] = s1[1] +  "," + s1[0]  ;
			}
			
			//overwrite file
			try {
				FileWriter myWriter = new FileWriter("Times.csv", false);
				for (int j = 0; j < name.length ; j ++) {
					myWriter.write(name[j] + "\n");
				} //for
				myWriter.close();
			} //try
			catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
				} //catch	
				
			in.close();
    		} //try
		catch (FileNotFoundException e) {
      		System.out.println("An error occurred.");
      		e.printStackTrace();
    		} //catch
	} //sort		

}
	
	
