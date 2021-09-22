import java.io.*;
public class CharArrayReaderExample {
    static final PrintWriter pw = new PrintWriter(System.out,true);
    public static void main(String[] args) throws IOException{
        String temp = "abcdefghijklmnopqrstuvwxyz";
        int length = temp.length();
        char c[] = new char[length];

        temp.getChars(0, length, c, 0);
        CharArrayReader input1 = new CharArrayReader(c);
        CharArrayReader input2 = new CharArrayReader(c,0,5);

        int i;
        pw.println("Input1 is : ");
        while((i = input1.read()) != -1){
            pw.print((char)i);
        }

        pw.println();
        pw.println("Input2 is : ");
        while ((i = input2.read()) != -1) {
            pw.print((char)i);
        }
        pw.println();
    }
}
