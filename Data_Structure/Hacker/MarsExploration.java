package Hacker;
import java.io.*;
public class MarsExploration {
    static int isAvail(String s){
        int temp=0;
        String tempStr="SOS";
        if(s.equals(tempStr)){
            temp = 0;
        }else{
            for(int i=0;i<s.length();i++){
                if(tempStr.charAt(i) != s.charAt(i)){
                    temp+=1;
                }
            }
        }
        return temp;
    }
    static int marsExploration(String s) {
        int counter=0,i=0;; 
        String newStr="";
        while(i<=s.length()-3){
            int pos = i,count = 0;
            newStr="";
            while(count<3){
                newStr = newStr + String.valueOf(s.charAt(pos));
                count++;
                pos++;
            }
            counter+=isAvail(newStr);
            i+=3;
        }
        return counter;
    }
	public static void main(String [] args)throws IOException{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(marsExploration(buffer.readLine()));
        buffer.close();
	}
}
