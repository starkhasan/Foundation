package Hacker;
import java.io.*;
public class IsAnagrams {
    static String sortString(String str){
        char[] chr = str.toCharArray();
        int[] ar = new int[chr.length];
        for(int i=0;i<chr.length;i++){
            ar[i] = chr[i];
        }
        for(int j=1;j<ar.length;j++){
            int key = ar[j];
            int i = j-1;
            while(i>=0 && key < ar[i]){
                ar[i+1] = ar[i];
                i-=1;
            }
            ar[i+1] = key;
        }
        for(int i=0;i<chr.length;i++){
            chr[i] = (char)ar[i];
        }
        String temp = new String(chr);
        return temp;
     }
     static boolean isAnagram(String a, String b) {
         a = sortString(a.toLowerCase());
         b = sortString(b.toLowerCase());
         if(a.equals(b))
             return true;
         else
             return false;
     }
     public static void main(String[] args) throws IOException{
         BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
         String a = buffer.readLine();
         String b = buffer.readLine();
         if(isAnagram(a,b))
             System.out.println("Anagrams");
         else
             System.out.println("Not Anagrmas");
         buffer.close();
     }    
}
