import java.util.*;
import java.io.*;
public class GenerateBinaryNumber {
    static String binaryNumber(int n){
        StringBuffer str = new StringBuffer();
        while(n>0){
            int temp = n%2;
            str.append(String.valueOf(temp));
            n = n/2;
        }
        str.reverse();
        return str.toString();
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputDemo.txt"));
        int N = 0;
        while((buffer.readLine())!=null){
            N = Integer.parseInt(buffer.readLine());
        }
        for(int i=1;i<=N;i++){
            System.out.print(binaryNumber(i)+" ");
        }
        buffer.close();
    }
}
