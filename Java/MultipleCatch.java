import java.util.*;
import java.io.*;
public class MultipleCatch{
  public static void multipleCatch(int value){
    try{
      var b = 42/value;
      int c[] = {1};
      c[42] = 42;
    }catch(ArithmeticException e){
      System.out.println(e.getMessage());
    }catch(ArrayIndexOutOfBoundsException e){
      System.out.println(e.getMessage());
    }finally{
      System.out.println("Finally! will always execute");
    }
  }
  public static void main(String[] args) throws FileNotFoundException{
    var file = new File("InputJava.txt");
    var scanner = new Scanner(file);
    var value = scanner.nextInt();
    multipleCatch(value);
    scanner.close();
  }
}
