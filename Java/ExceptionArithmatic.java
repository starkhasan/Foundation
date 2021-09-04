import java.util.*;
import java.io.*;
public class ExceptionArithmatic{

  public static void arithmeticException(int a,int b){
    try{
      System.out.print(a/b);
    }catch(ArithmeticException e){
      System.out.print(e.getMessage());
    }
  }

  public static void main(String[] args) throws FileNotFoundException{
    var file = new File("InputJava.txt");
    var scanner = new Scanner(file);
    var a = Integer.parseInt(scanner.nextLine());
    var b = scanner.nextInt();
    arithmeticException(a,b);
    scanner.close();
  }
}
