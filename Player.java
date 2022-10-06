import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;   //to write into files
import java.util.Scanner ; // Import the Scanner class to read text files
import java.io.IOException;  // Import the IOException class to handle errors


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
	
	public String AddTime(double time, //level) {
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
	
	public String [] TopThreeTime() { //will return list or array , still in progress
	} //topthreetimes for this.username
	
	public String [] ScoreBoard() {
		//best to worst times 
		//10 at a time
	} //scoreboard
	
	/*public String getTimes() {
		try {
				File myObj = new File("times.txt");
				Scanner in = new Scanner(myObj);

				while (in.hasNextLine()) { //returns a boolean value  
				 
				
					String data = in.nextLine() ;
					String[] values = data.split(",");
					
					return values[] ;
				} //while   
				in.close();  //closes the scanner  
			} //try
			catch (FileNotFoundException e) {
						return "An error occurred.";
						//e.printStackTrace();
			} //catch
						
		return "oh no" ;				
	} //getTimes	*/

	private boolean CheckName(String name){
		if (name.length() > 10) {
			return false ;
		} //if
		else { 
			return true ;
		} //else
		
		//to do:
			//check if username already in database
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

}
	
	
