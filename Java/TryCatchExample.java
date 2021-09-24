import java.io.*;
public class TryCatchExample {
   private static final PrintWriter pw = new PrintWriter(System.out,true);
   public static void main(String[] args) {
      int a,d;
      try {
          d = 0;
          a = 42/0;
          pw.println("This will not be printed");
      } catch (ArithmeticException e) {
          pw.println("Divisible by zero");
      } 
      pw.println("After catch statement");
   } 
}
