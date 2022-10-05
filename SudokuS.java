import java.util.Random;
import java.util.Scanner ;

public class SudokuS{


  public static void main(String [] args){
    Board hello = new Board();
    int lev = hello.Level();
	Scanner in = new Scanner(System.in) ;
	hello.MakeGameBoard() ;

	//Input i = new Input(r,c,input, hello, ) ;
	//hello. Input(r,c,input) ;
	while (hello.checkIfEmpty() == false ) {	
		System.out.println("\nWhat would you like to input:") ;
		int input = in.nextInt() ;
		System.out.println("Row:") ;
		int r = in.nextInt() ;
		System.out.println("Column:") ;
		int c = in.nextInt() ;
		
		if (hello.ValidInput(r,c,input) == false ) {
			System.out.println("Input not entered!") ;
		} else {
			hello.DisplayBoard(hello.getBoard()) ;
		}	
		
		
	}	


  }
}