import java.util.Random;
import java.util.Arrays;

public class Board{
  public static void main(String[] args){
    int index = 0;
    int t = 0;
  while (index < 3){
    for (int w = 0; w < 3; w++){
      System.out.print(" -------------");
      System.out.print(" ");
    }
    System.out.print("\n");

    for (int i = 0; i < 3; i++){
      System.out.print("| ");
      t += 1;
      for (int j = 0; j < 9; j++){
        if (j==3){
          System.out.print("|  ");
        }
        else if (j==6){
          System.out.print("|  ");
        }
        System.out.print(t);
        System.out.print("   ");
      }
      System.out.print("|");
      System.out.print("\n");
    }
    index +=1;

}
    for (int w = 0; w < 3; w++){
      System.out.print(" -------------");
      System.out.print(" ");
    }


  }
}
