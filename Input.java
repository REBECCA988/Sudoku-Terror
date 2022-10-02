public class Input {
	private int r ;
	private int c ;
	private int input ;
	private Board b = new Board() ; //board attribute

	public Input(int r , int c, int input , Board b) {
		this.r = r ;
		this.c = c  ;
		this.input = input ;
		this.b = b  ;
	} //constructor 
	
	public void Add() {
		Integer [][] grid = this.b.getBoard() ; //gets grid from board class
		grid[this.r][this.c] = this.input ; //inputs values into grid
	}  //add input 
	
}		