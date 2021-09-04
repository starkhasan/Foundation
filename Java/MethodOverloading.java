import java.util.*;
import java.io.*;
public class MethodOverloading{

  public static int area(int length,int breadth){
    return length*breadth;
  }

  public static int area(int side){
    return (int)Math.pow(side,2);
  }

  public static void main(String[] args) throws FileNotFoundException{
    var file = new File("InputJava.txt");
    var scanner = new Scanner(file);
    var length = Integer.parseInt(scanner.nextLine());
    var breadth = Integer.parseInt(scanner.nextLine());
    var side = Integer.parseInt(scanner.nextLine());
    System.out.println("Area of Rectangle = "+area(length,breadth));
    System.out.println("Area of Square = "+area(side));
    scanner.close();
  }
}
