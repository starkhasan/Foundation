import java.io.*;
public class Demo{
  private final static PrintWriter pw = new PrintWriter(System.out,true);
  public static void main(String[] args) {
    String name = "Ali Hasan";
    String name2 = name;
    pw.println(name);
    pw.println(name2);
    name = "New Ali Hasan";
    pw.println(name);
    pw.println(name2);
    pw.println();
  }
}