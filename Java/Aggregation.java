import java.lang.Math;
import java.util.*;
import java.io.*;
class Operation{
  public int square(double radius){
    return (int)Math.pow(radius,2);
  }
}
public class Aggregation{

  public static int area(double radius){
    var operation = new Operation();
    return (int)(Math.PI * operation.square(radius));
  }

  public static void main(String[] args) throws FileNotFoundException{
    var file = new File("InputJava.txt");
    var scanner = new Scanner(file);
    var radius = Double.parseDouble(scanner.nextLine());
    var result = area(radius);
    System.out.println("Area of Circle = "+result);
    scanner.close();
  }
}
