import java.util.Random;
import java.util.Scanner ;


public class SudokuS{

  public static void main(String [] args){
	//WELCOME 
	Scanner in = new Scanner(System.in) ;
	System.out.println("WELCOME TO SUDOKU!") ;
	System.out.println("Are you a new player <y> for yes  <anything else> for no") ;
	String s = in.nextLine() ;
	System.out.println("Please provide a username:") ;
	String name = in.nextLine() ;
	Player p = new Player(name) ;
	
	if ((s.toLowerCase()).equals("y")) {
		p.CheckName(name) ; 
	} 
	
	//OPTIONS
	System.out.println("What do you wish to do:") ; 
	System.out.println("[1] Player Details") ;
	System.out.println("[2] New Game") ;
	System.out.println("[q] Quit") ;
	String opt = in.nextLine() ;
	//Player p = new Player(name) ;
	switch (opt) {
		case "q" : case "Q": //QUIT
			return ;
			
		case "1" : //PLAYER DETAILS
			System.out.println("What do you wish to do:") ; 
			System.out.println("[1] View Times") ;
			System.out.println("[2] Top Three Times") ;
			System.out.println("[3] Scoreboard") ;
			System.out.println("[q] Quit") ;
			String opt1 = in.nextLine() ;
			//Player p = new Player(name) ;
			switch (opt1) {	
				case "1" :
					//p.getTimes() ;
					break ;
				case "2" :
					p.TopThreeTimes() ;
					break ;
				case "3" :
					//p.Scoreboard() ;
					break ;
				default:
                    System.out.printf("Command %s not valid.  Please reenter...", opt1);
                    break;	
			} //case 1 switch		
					
			//System.out.println(p.toString()) ;

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
			while (hello.checkIfEmpty() == false ) {	//while the board still has open spaces
				//get row, column and input from player
				System.out.println("\nWhat would you like to input:") ;
				int input = in.nextInt() ;
				System.out.println("Row:") ;
				int r = in.nextInt() ;
				System.out.println("Column:") ;
				int c = in.nextInt() ;

				if (hello.ValidInput(r,c,input) == false ) { //if invalid row, column or input
					System.out.println("Input not entered!") ; 
				} //if
				else {
					hello.DisplayBoard(hello.getBoard()) ;
				} //else
				
			} //while

			//TIMER
			endTime = System.currentTimeMillis(); 
			time = (endTime-startTime)/1000.0;

			//OUTPUT AT END OF GAME
			System.out.println("GAME COMPLETED!") ;
			System.out.println("You completed this game in: " +  p.AddTime(time) ) ;
			break ;
			
		default:
			System.out.printf("Command %s not valid.  Please reenter...", opt) ;
			break;	
	} //switch		

  } //main
}