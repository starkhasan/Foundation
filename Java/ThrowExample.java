import java.io.*;
public class ThrowExample {
    private static final PrintWriter pw = new PrintWriter(System.out,true);

    public static void demoThrow(){
        try {
            throw new NullPointerException("demo");
        } catch (NullPointerException e) {
            pw.println("Caught inside demo");
            throw e;
        }
    }
    public static void main(String[] args) {
        try {
            demoThrow();
        } catch (NullPointerException e) {
            pw.println("Recaught : "+e);
        }    
    }
}
