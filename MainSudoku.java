import java.util.Random;
import java.util.Scanner ;

public class MainSudoku{

  public static void main(String [] args){
	//WELCOME
	Scanner in = new Scanner(System.in) ;
	System.out.println("WELCOME TO SUDOKU!") ;
	System.out.println("Are you a new player <y> for yes <anything else> for no") ;
	String s = in.nextLine() ;
	System.out.println("Please provide a username:") ;
	String name = in.nextLine() ;
	Player p = new Player(name) ;
	
	//CHECK USERNAME
	if ((s.toLowerCase()).equals("y")) {
		while (p.CheckName(name) == false ) {
			System.out.println("Username already exists");
			System.out.println("Please provide a different username:") ;
			name = in.nextLine() ;
		} //while	
	} //if
	else {
		while (p.CheckExistingName(name) == false ) {
			System.out.println("Username entered incorrectly");
			System.out.println("Please provide correct username:") ;
			name = in.nextLine() ;
		} //while	
	}	
	while (true) {
		//OPTIONS
		System.out.println("What do you wish to do:") ;
		System.out.println("[1] Player Details") ;
		System.out.println("[2] New Game") ;
		System.out.println("[q] Quit") ;
		String opt = in.nextLine() ;
		switch (opt) {
			case "q" : case "Q": //QUIT
				return ;

			case "1" : //PLAYER DETAILS
				System.out.println("What do you wish to do:") ; 
				System.out.println("[1] View Times") ;
				System.out.println("[2] Top Three Times") ;
				System.out.println("[3] Scoreboard") ;
				System.out.println("[4] Return to Main") ;
				System.out.println("[q] Quit") ;
				String opt1 = in.nextLine() ;
				//Player p = new Player(name) ;
				switch (opt1) {
					case "q" : case "Q":
						return;
					case "1" :
						p.getTimes() ;
						break ;
					case "2" :
						p.TopThreeTimes() ;
						break ;
					case "3" :
						p.ScoreBoard() ;
						break ;
					case "4" :
						break ;
					default:
						System.out.printf("Command %s not valid.  Please reenter...", opt1);
						break;
				} //case 1 switch
				break ;

			case "2" : //NEW GAME
				//BOARD
				Board hello = new Board(); //call board class
				int lev = hello.Level();

				//TIMER
				long timeMillis = System.currentTimeMillis();
				long startTime , endTime;
				double time;
				startTime = System.currentTimeMillis();
				endTime = System.currentTimeMillis();
				time = (endTime-startTime)/1000.0;
				//System.out.println(time);


				//MAKE BOARD
				hello.MakeGameBoard() ; //create board and remove numbers

				//INPUT
				int input2 = 0;
				int r2 = 0;
				int c2 = 0;
				String w = "";
				System.out.println("\nEnter [q] anytime to quit the current game.");
				int wrong = 0;
				while (hello.checkIfEmpty() == false) {	//while the board still has open spaces
					//get row, column and input from player

					//input
					System.out.println("\nWhat would you like to input:") ;
					String input = in.nextLine();
					if (input.equals("q") || input.equals("Q")){
					  System.out.println("You have quit the game. COME BACK SOON");
					  w = "q";
					  break;
					} //input if
					else{
						input2 = Integer.parseInt(input);//converts input into integer
					}
					
					//row
					System.out.println("Row:") ;
					String r = in.nextLine() ;
					if(r.equals("q") || r.equals("Q")){
					  System.out.println("You have quit the game. COME BACK SOON");
					  w = "q";
					  break;
					} //row if
					else{
					  r2 = Integer.parseInt(r);//converts input into integer
					}
					
					//column
					System.out.println("Column:") ;
					String c = in.nextLine() ;
					if (c.equals("q") || c.equals("Q") ){
					  System.out.println("You have quit the game. COME BACK SOON");
					  w = "q";
					  break;
					} //column if
					else{
					  c2 = Integer.parseInt(c); //converts input into integer
					}
					
					if (hello.ValidInput(r2,c2,input2) ==false ) { //if invalid row, column or input
						wrong++;
						System.out.println("number of wrong moves lost: " + wrong + "/3");
					} //if
					else {
						hello.DisplayBoard(hello.getBoard()) ;
					} //else
						
					if (wrong == 3){
					  System.out.println("You ran out of moves.");
					  w = "r";
					  break;
					} //if
				} //while

				//TIMER
				endTime = System.currentTimeMillis();
				time = (endTime-startTime)/1000.0;

				//OUTPUT AT END OF GAME
				if (w.equals("q")){
					break;
				}
				else if (w.equals("r") || w.equals("R")){
					System.out.println("GAME OVER. Please try again.");
					break;
				}
				else{
					System.out.println("GAME COMPLETED!") ;
					System.out.println("You completed this game in: " +  p.AddTime(time) ) ;
					break ;
				}

				default:
					System.out.printf("Command %s not valid.  Please reenter...", opt) ;
					break;
		} //switch
		
	} //while
	
  } //main
}
