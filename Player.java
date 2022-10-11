import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;   //to write into files
import java.util.Scanner ; // Import the Scanner class to read text files
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Arrays; //arrays


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
			System.out.println("Top three times for: " + this.username) ;
      		while (in.hasNextLine()) {
        			String data = in.nextLine();
					String [] info = data.split(",") ;
					//if ((info[0].toLowerCase()).equals(this.username.toLowerCase())) {
						//i ++ ;
						System.out.println(i + "." + info[0] + " " + info[1])  ;
					//} //if	
						
      		} //while
			in.close();
    		} //try
		catch (FileNotFoundException e) {
      		System.out.println("An error occurred.");
      		e.printStackTrace();
    		} //catch

	} //topthreetimes for this.username
	
	public void ScoreBoard() {
		//best to worst times 
		//10 at a time
	} //scoreboard
	
	public void getTimes() {
		try {
      		File myObj = new File("Times.csv");
      		Scanner in = new Scanner(myObj);
			int i = 0 ;
			System.out.println("All times for " + this.username) ;
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
      		e.printStackTrace();
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
		
		String t = hour + ":"  + minute + ":" + seconds ;
		return t ;
		
	}	
	
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
				for (int j = name.length - 1 ; j > -1 ; j --) {
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
	
	
