package Generic;
import java.io.*;
public class GenericExample1 {
    public static <T> void printInput(T x){
        System.out.println(x);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputDemo.txt"));
        while((buffer.readLine())!=null){
            printInput(buffer.readLine());
        }
        buffer.close();
    }
}
