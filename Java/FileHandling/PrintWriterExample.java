import java.io.*;
public class PrintWriterExample{
  static final PrintWriter pw = new PrintWriter(System.out,true);
  /**
  *The recommended method of writing to the console when using Java is through PrintWrite class
  *it is one of the Character-Based classes.
  * using construtor
  * PrintWriter pw = new PrintWriter(OutStream outputStream, boolean flushOnNewLine)
  * outputStream is an object of OutputStream
  * flushOnNewLine control whether java flush the output stream everytime a println() method is called.
  * PrintWriter support the print() and println() method for all type including Object.
  */
  public static void main(String[] args) {
    var name = "Ali Hasan";
    pw.println(name);
  }
}
