import java.io.*;
import java.util.*;
public class FirstLetterofWord {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputDemo.txt"));
        String input = "";
        while((buffer.readLine())!=null){
            input = buffer.readLine();
        }  
        String[] str = input.split(" ");
        String result = "";
        for(String temp:str){
            result = result + String.valueOf(temp.charAt(0));
        }
        System.out.println(result);
        buffer.close();
     }   
}
