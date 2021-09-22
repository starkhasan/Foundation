import java.io.*;
public class BUfferedReaderExample {
    static final PrintWriter pw = new PrintWriter(System.out,true);
    public static void main(String[] args) throws IOException{
        //InputStream is the bridge between the byte stream to character stream
        //It reads the byte and decode them into character set using charset
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(inputStreamReader);
        pw.println("Input> ");
        var inputFromKeyBorad = buffer.readLine();
        System.out.println("Input From User = "+inputFromKeyBorad);
        buffer.close();
    }
}
