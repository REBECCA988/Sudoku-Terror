import java.util.Random;
import java.util.Arrays;

public class Code{

  public static void Board(int [][] grid){
    //creates the skeleton of our board
    int index = 0;
    int col  = -1;

    while (index < 3 ){
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
          System.out.print(grid[j][col]);
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
  }
  public static int[][] createBoard(int seed){
    //code james wrote in class
    int [][] grid = new int[9][9];
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
        cnt = (grid[i-1][0] + 3) % 9;
      }

      for (int j = 0; j < 9; j++){
        if (cnt == 0){
          cnt = 9;
        }
        grid[i][j] = cnt;
        cnt = (cnt + 1) % 9;
      }
    }
    return grid;
  }
  public static int [][] swapCol(int [][] board){
    //Code James did in class
    Random num = new Random();
    int [][] grid = new int [9][9];
    for (int i = 0; i < 9; i++){
      for( int j = 0; j < 9; j++){
        grid[i][j] = board[i][j];   // copies board that we made in createBoard
      }
    }
    int col_0 = num.nextInt(3);
    int col_1 = num.nextInt(3);
    int col_2 = (col_1 + num.nextInt(2) + 1) % 3;
    col_1 = 3*col_0 + col_1;
    col_2 = 3*col_0 + col_2;

    int temp = -1;
    for (int i = 0; i < 9; i++){
      temp = grid[i][col_1];
      grid[i][col_1] = grid[i][col_2];
      grid[i][col_2] = temp;
    }
    return grid;
  }

  public static int [][] swapRow(int[][] board){
    //code James did in class
    Random num = new Random();
    int [][] grid = new int [9][9];
    for (int i = 0; i < 9; i++){
      for( int j = 0; j < 9; j++){
        grid[i][j] = board[i][j];   // copies board that we made in createBoard
      }
    }
      int row_0 = num.nextInt(3);
      int row_1 = num.nextInt(3);
      int row_2 = (row_1 + num.nextInt(2) + 1) % 3;
      row_1 = 3* row_0 + row_1;
      row_2 = 3* row_0 + row_2;

      int temp = -1;
      for (int i = 0; i < 9; i++){
        temp = grid[i][row_1];
        grid[i][row_1] = grid[i][row_2];
        grid[i][row_2] = temp;
      }

      return grid;
  }

  public static void main(String[] args){
    //code james wrote in class
    Random num = new Random();
    int [][] g = null;
    int [][] x = null;
    int seed = num.nextInt(9);

    g = createBoard(seed);
    Board(g);
    x = g;
    System.out.print("\n");

    for (int i = 0; i < 1000; i++){
      x = swapCol(x);
      x = swapRow(x);
    }
    Board(x);
  }
}
