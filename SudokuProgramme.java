import java.util.Random;

public class SudokuProgramme{
  public static void Board(Sudoku grid){
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
          System.out.print(grid.index(j,col));
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

  public static void main(String [] args){
    Sudoku hello = new Sudoku();
    Random num = new Random();
    int seed = num.nextInt(9);
    //int cnt = -1;
    hello.addNumbers(seed);
    hello.Shuffle();
    Board(hello);
  }
}
