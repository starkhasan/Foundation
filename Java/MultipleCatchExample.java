import java.io.*;
public class MultipleCatchExample {
    private static final PrintWriter pw = new PrintWriter(System.out,true);
    public static void main(String[] args) {
        try {
            int a = args.length;
            pw.println("a = "+a);
            int b = 42/a;
            int[] c = {1};
            c[42] = 99;
        } catch (ArithmeticException e) {
            pw.println("Divide by zero "+e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            pw.println("Array index "+e);
        }
        pw.println("After try/catch block");
    }
}
