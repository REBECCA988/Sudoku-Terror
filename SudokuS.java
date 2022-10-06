import java.util.Random;
import java.util.Scanner ;


public class SudokuS{

  public static void main(String [] args){
	//WELCOME 
	Scanner in = new Scanner(System.in) ;
	System.out.println("WELCOME TO SUDOKU!") ;
		
	//PLAYER
	System.out.println("Please enter your username: ") ;
	String name = in.nextLine() ;
	Player p = new Player(name) ;
	
	
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
			System.out.println(p.toString()) ;
			//CASE DIAGRAM FOR: 
			//THESES OPTIONS WILL ACCESSED FROM PLAYER CLASS
				//VIEW TIMES
				//TOP THREE TIMES
				//SCOREBOARD
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
	} //switch		
			
	
	
	

  } //main
}