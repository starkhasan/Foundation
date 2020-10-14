package Hacker;
import java.util.*;
public class HackerRankInString {
    static String hackerrankInString(String s) {
        String result = "";
        String str = "hackerrank";
        int pos = 0;
        for(int i=0;i<s.length();i++){
            if(pos < str.length()){
                if(str.charAt(pos) == s.charAt(i)){
                    result = result + String.valueOf(s.charAt(i));
                    pos++;
                }
            }
        }
        if(result.equals(str)){
            return "YES";
        }else{
            return "NO";
        }
    }
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String : ");
        System.out.println(hackerrankInString(sc.nextLine()));
        sc.close();
	}
}
