import java.util.Random;
import java.util.Arrays;

public class Code{

  public static void Board(int [][] grid){
    for (int i = 0; i < 9; i++){
      for (int j = 0; j < 9; j++){
        System.out.print(" |  ");
        System.out.print(grid[i][j]);
        System.out.print(" ");
      }
      System.out.print(" | ");
      System.out.print("\n");

      for (int w = 0; w < 3; w++){
        System.out.print(" -----------------");
        System.out.print(" ");
      }
      System.out.print("\n");

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
  public static void main(String[] args){
    //code james wrote in class
    Random num = new Random();
    int [][] g = null;
    int [][] x = null;
    int seed = num.nextInt(9);

    g = createBoard(seed);
    Board(g);
    //System.out.print(g);
  }
}
