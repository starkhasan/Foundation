package Hacker;
import java.io.*;
public class TwoStrings{
    static String twoStrings(String s1, String s2) {
        String result = "NO";
        if(s1.length() < s2.length()){
            for(int i=0;i<s1.length();i++){
                if(s2.contains(String.valueOf(s1.charAt(i)))){
                    result = "YES";
                    break;
                }
            }
        }else{
            for(int i=0;i<s2.length();i++){
                if(s1.contains(String.valueOf(s2.charAt(i)))){
                    result = "YES";
                    break;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("InputTwoString.txt"));
        String s1 = "",s2 = "";
        boolean isFirst = true;
        while((br.readLine())!=null){
            if(isFirst){
                isFirst=false;
                s1 = br.readLine();
            }else
                s2 = br.readLine();
        }
        System.out.println(twoStrings(s1,s2));
        br.close();
    }
}
