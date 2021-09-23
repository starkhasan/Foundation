import java.io.*;
public class StaticExample {
    private static final PrintWriter pw = new PrintWriter(System.out,true);

    public static int number = 10;
    int num = 20;

    public void printNumber(){
        pw.println("This is Non-Static Method");
    }

    //static block
    static{
      pw.println("This will print First Before main method is called");
    }
    public static void main(String[] args) {
        pw.println("This will called after the execution of the static init block");
        pw.println("Accessing Static Variable = "+number);
        pw.println("Accessing Non Static Variable = "+new StaticExample().num);
        new StaticExample().printNumber();//A Non-Static method can't be called from static method
    }
}
