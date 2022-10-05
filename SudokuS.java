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
	System.out.println(p.toString()) ;
	
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

	//TIMER (not completely finished)
	endTime = System.currentTimeMillis(); 
	time = (endTime-startTime)/1000.0;
	//p.AddTime(time) ;
	System.out.println(time);
	

  } //main
}