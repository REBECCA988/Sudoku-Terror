import java.util.Random;
import java.util.Scanner;

public class Board{
  //variable declaration
  private Integer [][] answers ;
  private Integer [][] grid;
  private int level;
  private Scanner in;

	public Board(){
		this.answers = new Integer[9][9] ; //grid that isnt emptied and used to check user input
		this.grid = new Integer [9][9]; //grid that is emptied , this grid is shown to player
		this.in = new Scanner(System.in);
    }//constructor
	
	public Integer[][] getBoard(){
		return this.grid ; //returns player board
	} //getBoard	
	
	public Integer [][] getAnswers() {
		return this.answers ; //returns answer board
	} //getAnswers	

	public int Level(){
	  //Scanner in = new Scanner(System.in);
	  System.out.println("Which level would you like to play? \n Easy[E] \n Medium[M] \n Hard[H]");  
	  String lev = in.nextLine();
	  //this.level = 0;
	  switch (lev){
		case "E": case "e":
		  this.level = 1*27;
		  break;

		case "M": case "m":
		  this.level = 27 + 9;
		  break;

		case "H": case "h":
		  this.level = 27 + 18;
		  break;
	  }

	  return this.level;
	}

	  public void DisplayBoard(Integer [][] g){
		//creates the skeleton of our board
		
		int index = 0;
		int col  = -1;
		//int row = 0;
		while (index != 3 ){
		  for (int w = 0; w < 3; w++){
			System.out.print(" -------------");
			System.out.print(" ");
		  }
		  System.out.print("\n");

		  for (int i = 0; i < 3; i++){
			System.out.print("| ");
			col += 1;
			for (int j = 0; j < 9; j++){
			  if (j==3){
				System.out.print("|  ");
			  }
			  else if (j==6){
				System.out.print("|  ");
			  }
			  if(g[col][j] == null){
				System.out.print(" ");
			  }
			  else{
				System.out.print(g[col][j]);
			  }

			  System.out.print("   ");
			}

			System.out.print("|");
			System.out.print("\n");
		  }
		  index += 1;

		}
		  for (int w = 0; w < 3; w++){
			System.out.print(" -------------");
			System.out.print(" ");
		  }
	  } //Creates board

	  public void addNumbers(int seed){
		//method to add numbers to grid, making it unshuffled
		int cnt = -1;
		for (int i = 0; i < 9; i++){
		  if (i == 0){
			cnt = seed;
		  }
		  else if (i == 3){
			cnt = (seed + 1) % 9;
		  }
		  else  if (i == 6){
			cnt = (seed + 2) % 9;
		  }
		  else{
			cnt = (this.grid[i-1][0] + 3) % 9;
		  }

		  for (int j = 0; j < 9; j++){
			if (cnt == 0){
			  cnt = 9;
			}
			this.grid[i][j] = cnt;
			cnt = (cnt + 1) % 9;
		  }
		}
	  }//adds numbers to board

	  public void SwopRow(){
		int index = 0;

		//while (index < 9){
		  Random num = new Random();
		  for (int i = 0; i < 9; i++){
			int row_0 = num.nextInt(3);
			int row_1 = num.nextInt(3);
			int row_2 = (row_1 + num.nextInt(2) + 1) % 3;
			while (row_1 == row_0 || row_1 == row_2 || row_2 == row_0){
			  row_1 = num.nextInt(3);
			  row_2 = (row_1 + num.nextInt(2) + 1) % 3;
			}
		  row_1 = 3*row_0 + row_1;
		  row_2 = 3*row_0 + row_2;
		  int temp = -1;
		  for (int j = 0; j < 9; j++){
			temp = this.grid[row_1][j];
			this.grid[row_1][j] = this.grid[row_2][j];
			this.grid[row_2][j] = temp;
		  }
		  }
		index += 1;
		
	  }

		public void SwopCol(){
		  int index = 0;

		  //while (index < 9){
			Random num_1 = new Random();
			for (int i = 0; i < 9; i++){
			  int col_0 = num_1.nextInt(3);
			  int col_1 = num_1.nextInt(3);
			  int col_2 = (col_1 + num_1.nextInt(2) + 1) % 3;
			  while (col_1 == col_0 || col_1 == col_2 || col_2 == col_1){
				col_1 = num_1.nextInt(3);
				col_2 = (col_1 + num_1.nextInt(2) + 1) % 3;
			  } //while 

			  col_1 =  3*col_0 + col_1;
			  col_2 = 3*col_0 + col_2;

			  int temp_1 = -1;
			  for (int r = 0; r < 9; r++){
				 temp_1 = this.grid[r][col_1];
				this.grid[r][col_1] = this.grid[r][col_2];
				this.grid[r][col_2] = temp_1;
				} //for
		  index += 1;

			} //for
		} //Swop Columns

	 //randomizes the numbers added to board

	public void empty(){
		//System.out.println(this.level);
		for (int i = 0; i < this.level; i++){
		  Random num = new Random();
		  int row_0 = num.nextInt(3);
		  int row_1 = num.nextInt(3);
		  int row_2 = (row_1 + num.nextInt(2) + 1) % 3;
		  row_1 = 3*row_0 + row_1;
		  row_2 = 3*row_0 + row_2;

		  Random num_1 = new Random();
		  int col_0 = num_1.nextInt(3);
		  int col_1 = num_1.nextInt(3);
		  int col_2 = (col_1 + num_1.nextInt(2) + 1) % 3;
		  col_1 = 3*col_0 + col_1;
		  col_2 = 3*col_0 + col_2;

		  this.grid[row_1][col_1] = null;
		  this.grid[row_2][col_2] = null;
		}
	  }//randomly takes out numbers and replaces them with spaces
	  
	
	
	public void MakeGameBoard() {
		//creates baord, addsnumbers, removes numbers and displays board
		Random num = new Random();
		int seed = num.nextInt(9);
		
		addNumbers(seed);
		//DisplayBoard(grid);
		SwopCol() ;
		SwopRow() ;
		for (int i = 0 ; i < 9 ; i++) {
			for (int j = 0 ; j < 9 ; j++) {
				this.answers[i][j] = this.grid[i][j] ;
			} //j for
		} //i for
		//System.out.println("Answer grid") ;
		//DisplayBoard(this.answers) ;
		//System.out.print("\n");
		//DisplayBoard(this.grid) ;
		//System.out.println("Empty grid") ;
		empty() ;
		//System.out.print("\n");
		DisplayBoard(this.grid) ;
	} //MakeGameBoard	
		
	private void Input(int r,int  c,int input) { //adds the number to the grid if correct
		//Integer [][] grid = this.b.getBoard() ; //gets grid from board class
		this.grid[r][c] = input ; //inputs values into grid
	}  //add input
	
	public boolean ValidInput(int r , int c , int input) {  //checks if user input is valid before adding
		boolean br = true ;
		boolean bc = true ;
		boolean bi = true ;
		boolean b = true ;
		if ( ( r >= 0 ) && (r <= 8)  ){ //check that row is valid
			br = true ;
		} else {
			br = false ;
			System.out.println("Invalid Row") ;
		}
		
		if ( c >= 0 && c <= 8) { //check that column is valid
			bc = true ;
		} else {
			bc = false ;
			System.out.println("Invalid Column") ;
		}
		
		if (input >= 1 && input <= 9) { //check if input is valid 
			bi = true ;
		}	
		else { 
			bi = false ;
			System.out.println("Invalid Input") ;
		}	
		
		if (this.answers[r][c] == input) { //check if input is in correct place
			b = true ;
		} else {
			b = false ;
			System.out.println("Input in wrong place") ;
		} 	

		if ( br && bc && bi && b ) {
			Input(r,c,input) ;
			return true;
		}
		else {
			return false ;
		}	
		
	} //validInput	
	
	public boolean checkIfEmpty() { //checks if there are any empty spaces left in the grid
		for (int i = 0 ; i < 9 ; i ++) {
			for (int j = 0 ; j < 9 ; j++) {
				if (this.grid[i][j] == null) {
					return false ;
				} //if
			} //j for
		} //i for
		
		return true ;
		
	}//checkIfEmpty	
} //Grid class
