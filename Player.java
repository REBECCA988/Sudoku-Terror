import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;   //to write into files
import java.util.Scanner ; // Import the Scanner class to read text files
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Arrays; 


public class Player {
	private String username ;
	private int [] scores ;
	//private List<String> inventory; 
	
	public Player(String name) {
		//add checkname method here and try/catch exception
		this.username = name ;
    } // constructor
	
	public String toString() {
		return this.username ; 
	} //toString	

	
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
	
	/*public String getTimes() {
		try {
      		File myObj = new File("Times.csv");
      		Scanner in = new Scanner(myObj);
			int i = 0 ;
			System.out.println("All times for " + this.username) ;
      		while (in.hasNextLine()) {
        			String data = in.nextLine();
					String [] info = data.split(",") ;
					if ((info[0].toLowerCase()).equals(this.username.toLowerCase())) {
						i ++ ;
						i + ". " + info[0] + " " + info[1]  ;
					} //if	
						
      		} //while
			in.close();
    		} //try
		catch (FileNotFoundException e) {
      		System.out.println("An error occurred.");
      		e.printStackTrace();
    		} //catch				
	} //getTimes	*/

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
					if ((info[0].toLowerCase()).equals(this.username.toLowerCase())) {
						return false ;
					} //if	
						
      		} //while
			in.close();
    		} //try
		catch (FileNotFoundException e) {
      		System.out.println("An error occurred.");
      		e.printStackTrace();
    		} //catch
			
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
			String [] sort = new String[6] ;
			int i = 0 ;
      		while (in.hasNextLine()) {
        			String data = in.nextLine();
					String [] info = data.split(",") ;
					if ((info[0].toLowerCase()).equals(this.username.toLowerCase())) {
						sort[i] = i + ". " + info[0] + " " + info[1]  ;
						i ++ ;
					} //if	
						
      		} //while
			in.close();
    		} //try
		catch (FileNotFoundException e) {
      		System.out.println("An error occurred.");
      		e.printStackTrace();
    		} //catch
	} //sort		

}
	
	
