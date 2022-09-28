import java.util.Random;

public class Sudoku{


  public static void main(String [] args){
    Board hello = new Board();
    //Level lev = new Level();
    Random num = new Random();
    int seed = num.nextInt(9);
    int lev = hello.Level();
    //System.out.println(hello.Level());
    hello.addNumbers(seed);
    hello.DisplayBoard();
    System.out.print("\n");
    for (int i = 0; i < 1000; i++){
      //hello.SwopRow();
      hello.SwopCol();
      hello.SwopRow();
      //hello.SwopCol();
      //hello.SwopRow();
    }
    hello.DisplayBoard();
    System.out.print("\n");
    hello.empty();
    hello.DisplayBoard();



  }
}
