import java.util.*;
import java.io.*;
abstract class Vehicle{
  void start(){
    System.out.println("Car Started");
  }
  abstract void color(String carColor);
}
class Car extends Vehicle{
  @Override
  void color(String carColor){
    System.out.println("The Color of Car is "+carColor);
  }
}
public class Abstraction{
  public static void main(String[] args) throws FileNotFoundException{
    var file = new File("InputJava.txt");
    var scanner = new Scanner(file);
    var color = scanner.nextLine();
    var obj = new Car();
    obj.start();
    obj.color(color);
    scanner.close();
  }
}
