import java.io.*;
public class NestedTryCatchExample {
    private static final PrintWriter pw = new PrintWriter(System.out,true);
    public static void main(String[] args) {
        try {
            int a = args.length;
            int b = 42/a;
            pw.println("a = "+a);
            try {
                if(a == 1){
                    a = a/(a-a);
                }

                if(a == 2){
                    int[] c = {1};
                    c[42] = 99;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                pw.println("Array index out of bound exception = "+e);
            }
        } catch (Exception e) {
            pw.println("Divide by 0 = "+e);
        }
    }
}
