import java.util.*;
import java.io.*;
public class ExceptionIndexOutofBound{
  public static void printArray(int[] ar){
    //Here We are accessing the index array which are not actually exit so it will throw an ArrayIndexOutOfBoundException
    try{
      for(var i = 0; i <= ar.length; i++){
        System.out.print(ar[i]+" ");
      }
    }catch(ArrayIndexOutOfBoundsException e){
      System.out.println(e.getMessage());//Here getting message using e.getMessage() of exception
    }
  }
  public static void main(String[] args) throws FileNotFoundException{
      var file = new File("InputJava.txt");
      var scanner = new Scanner(file);
      var input = scanner.nextLine().split(" ");
      var ar = new int[input.length];
      for(var i = 0; i < input.length; i++){
        ar[i] = Integer.parseInt(input[i]);
      }
      printArray(ar);
      scanner.close();
  }
}
