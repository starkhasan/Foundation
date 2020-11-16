import java.io.*;
import java.util.*;
public class AlternatingCharacters {
    static int alternatingCharacters(String s) {
        List<String> listString = new ArrayList<String>();
        String temp = "";
        for(int i=0;i<s.length();i++){
            if(i==0){
                temp = String.valueOf(s.charAt(i));
                listString.add(temp);
            }else if(!temp.equals(String.valueOf(s.charAt(i)))){
                temp = String.valueOf(s.charAt(i));
                listString.add(temp);
            }
        }  
        if(listString.size() == 0){
            return 0;
        }else{
            return (s.length() - listString.size());
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputHacker.txt"));
        String input = "";
        while((buffer.readLine())!=null){
            input = buffer.readLine();
            System.out.println(alternatingCharacters(input));
        }
        buffer.close();
    }
}
