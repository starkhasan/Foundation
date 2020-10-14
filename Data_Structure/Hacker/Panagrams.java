package Hacker;
import java.util.*;
public class Panagrams {
    static String pangrams(String s) {
        List<String> alphabet = new ArrayList<String>();
        s = s.toLowerCase();
        for(int i=0;i<s.length();i++){
            if((int)s.charAt(i) >= 97 && (int)s.charAt(i) <= 123){
                if(!alphabet.contains(String.valueOf(s.charAt(i)))){
                    alphabet.add(String.valueOf(s.charAt(i)));
                }
            }
        }
        if(alphabet.size() == 26){
            return "pangram";
        }else{
            return "not pangram";
        }
    }
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String : ");
        System.out.println(pangrams(sc.nextLine()));
        sc.close();
	}
}
