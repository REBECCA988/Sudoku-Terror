import java.util.Random;
import java.util.Scanner ;

public class SudokuS{


  public static void main(String [] args){
    Board hello = new Board();
    int lev = hello.Level();

	hello.MakeGameBoard() ;

	Scanner in = new Scanner(System.in) ;
	System.out.println("\nWhat would you like to input:") ;
	int input = in.nextInt() ;
	System.out.println("Row:") ;
	int r = in.nextInt() ;
	System.out.println("Column:") ;
	int c = in.nextInt() ;
	
	Input i = new Input(r,c,input, hello) ;
	i.Add() ;
	hello.DisplayBoard() ;

  }
}