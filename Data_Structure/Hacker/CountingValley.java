import java.util.*;
import java.io.*;
public class CountingValley {
    static int countingValleys(int n, String s) {
        int currLevel = 0,valleys=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'U'){
                currLevel+=1;
                if(currLevel == 0)
                    valleys+=1;
            }else{
                currLevel-=1;
            }
        }
        return valleys;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputHacker.txt"));
        String input = "";
        while((buffer.readLine())!=null){
            input = buffer.readLine();
        }
        System.out.println(countingValleys(input.length(),input));
        buffer.close();
    }
}
