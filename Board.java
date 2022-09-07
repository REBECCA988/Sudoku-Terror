import java.util.Random;
import java.util.Arrays;

public class Board{
  public static void main(String[] args){
    //int index = 0;
    for (int w = 0; w < 3; w++){
      System.out.print(" -------------");
      System.out.print(" ");
    }
    System.out.print("\n");

    for (int i = 0; i < 9; i++){
      System.out.print("| ");

      for (int j = 0; j < 9; j++){
        if (j==3){
          System.out.print("|  ");
        }
        else if (j==6){
          System.out.print("|  ");
        }
        System.out.print(j);
        System.out.print("   ");
        }

      System.out.print("|");
      System.out.print("\n");


        for (int w = 0; w < 3; w++){
          System.out.print(" -------------");
          System.out.print(" ");

      }

      System.out.print("\n");
    }



  }
}
