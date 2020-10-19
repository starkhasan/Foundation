package Hacker;
import java.io.*;
public class StringIntroduction {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String A = buffer.readLine();
        String B = buffer.readLine();
        System.out.println((A.length()+B.length()));
        if(A.compareTo(B) > 1)
            System.out.println("Yes");
        else
            System.out.println("No");
        System.out.println(A.substring(0,1).toUpperCase()+A.substring(1)+" "+B.substring(0,1).toLowerCase()+B.substring(1));
        buffer.close();
    }
}
