package Hacker;
import java.io.*;
public class CamelCase {
    static int camelcase(String s) {
        int count = 0;
        for(int i=0;i<s.length();i++){
            if((int)s.charAt(i) < 97)
                count++;
        }
        return count+1;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputHacker.txt"));
        String input = "";
        while((buffer.readLine())!=null){
            input = buffer.readLine();
        }
        System.out.println(camelcase(input));
        buffer.close();
    }  
}
