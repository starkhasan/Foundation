import java.util.*;
class Demo{
  public static void main(String[] args) {
    int number = 1534236469;
    int temp = 123;
    int y = 0;
    while(number>0){
      int x = number%10;
      y = x + y*10;
      number = number/10;
    }
    if(y > Integer.MAX_VALUE/10) {
      System.out.println(Integer.MAX_VALUE);
      System.out.println("Overlow");
    }
    System.out.println(y);
  }
}