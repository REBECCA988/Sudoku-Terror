import java.util.Random;
public class Sudoku{
  //variable declaration
  private int [][] grid;

  public Sudoku(){
    //constructor
  this.grid = new int[9][9];
  }

  public int [][] addNumbers(int seed){
    //method to add numbers to grid, making it unshuffled
    int cnt = -1;
    for (int i = 0; i < 9; i++){
      if (i == 0){
        cnt = 9;
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
    return this.grid;
  }

  public int [][] Shuffle(){

    Random num = new Random();

    int row_0 = num.nextInt(3);
    int row_1 = num.nextInt(3);
    int row_2 = (row_1 + num.nextInt(2) + 1) % 3;
    row_1 = 3*row_0 + row_1;
    row_2 = 3*row_0 + row_2;

    int temp = -1;
    for (int i = 0; i < 9; i++){
      temp = this.grid[row_1][i];
      this.grid[row_1][i] = this.grid[row_2][i];
      this.grid[row_2][i] = temp;
    }

    Random num_1 = new Random();
    int col_0 = num_1.nextInt(3);
    int col_1 = num_1.nextInt(3);
    int col_2 = (col_1 + num_1.nextInt(2) + 1) % 3;
    col_1 = 3*col_0 + col_1;
    col_2 = 3*col_0 + col_2;

    int temp_1 = -1;
    for (int i = 0; i < 9; i++){
      temp_1 = this.grid[i][col_1];
      this.grid[i][col_1] = this.grid[i][col_2];
      this.grid[i][col_2] = temp_1;
    }
    return this.grid;
  }


  public int index(int row, int col){
    return this.grid[row][col];
  }
} //Grid class
