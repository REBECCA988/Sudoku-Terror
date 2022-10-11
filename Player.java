import java.util.*;
import java.lang.*;
import java.io.*; //for try catch exceptions

public class Player {
	private String username ;

	public Player(String name) {
		this.username = name ;
    } // constructor

	public String toString() {
		return this.username ;
	} //toString

	public int FileLength()  {
		try {
      		File myObj = new File("Times.csv"); //file to be associated with each new username
      		Scanner in = new Scanner(myObj);
			int cnt = 0 ;
      		while (in.hasNextLine()) { //prevents never ending iterations by only iterating so long as input is present
				cnt ++ ;
				String data = in.nextLine();
				String [] info = data.split(",") ; // user input gets split along comments to allow for data retrevial to be easier
			}
			in.close();
			return cnt ;

		} //try
		catch (FileNotFoundException e) {
      		System.out.println("An error occurred, the file you are trying to access does not exist");
      		e.printStackTrace();
			return 0 ; // method must return int regardless of code, hence a placeholder value is returned to allow code to work
    		} //catch

	} //file length

	public String AddTime(double time) {
    	try {
				String newtime = normalise(time) ;
				FileWriter myWriter = new FileWriter("Times.csv", true);
				myWriter.write(this.username + "," + newtime + "\n" ); 
				return newtime ;

			}
			catch (IOException e) {
				return "An error occurred while trying to add your play times";
				//e.printStackTrace();
    		}
  	} //addTime, writes each play time into file created in FileLength method

	public void TopThreeTimes() {
		try {
      		File myObj = new File("Times.csv");
      		Scanner in = new Scanner(myObj);
			String [] TopTimes =  new String [6] ; // the fist six times will be considered when ranking times
			int i = 0 ;
			Sort() ; // times are sorted in ascending order
			System.out.println("TOP THREE TIMES FOR: " + this.username) ;
      		while (in.hasNextLine() && i < 3) { // interations will stop when there is no more input data and when the lowest three times have been retrieved
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
      		System.out.println("An error occurred, we can't seem to find the file youre looking for..");
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
			Sort() ; //times are displayed in ascending order instead of being displayed in the order of games played
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
					if ((info[0].toLowerCase()).equals(this.username.toLowerCase())) { // makes sure that the times being retrieved belong to the the specified user. this line is why usernames cannot be duplicates
						i ++ ;
						System.out.println(i + ". " + info[0] + " " + info[1] ) ;
					}
      		}

			in.close();
		} //try
		catch (FileNotFoundException e) {
      		System.out.println("An error occurred.");
			System.out.println("If new player: You do not have player details yet");
    		} //catch
	} //getTimes

	public boolean CheckName(String name){
		if (name.length() > 10) {
			return false ;
		} // first check is checking that the proposed username is not greater than 10 characters

		try {
      		File myObj = new File("Times.csv");
      		Scanner in = new Scanner(myObj);
			int i = 0 ;
      		while (in.hasNextLine()) {
        			String data = in.nextLine();
					String [] info = data.split(",") ;
					if ((info[0].toLowerCase()).equals(name.toLowerCase())) {
						return false ; // duplicated names triggers a false boolean that will inform user that they cannot use their proposed name. this will appen in the main method
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


	public String normalise(double seconds) {  // this will be the mathod that trackers the user time
		int minute = 0 ;
		int hour = 0 ;

		while (seconds >= 60) {
			seconds -= 60.0 ;
			minute += 1 ;
		}	//decrements seconds & increments minutes

		while (minute >= 60) { // while loop is used because it is not known how many times this block will need to iterate
			minute -= 60 ;
			hour += 1 ;
		}	// decrements minutes that exceed 60 & increments hours

		double roundDbl = Math.round(seconds*100.0)/100.0; // rounds off seconds into a conventianl format for user experience
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

	public void Sort() { //sort function
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
