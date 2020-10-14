package Hacker;
import java.io.*;
public class AppendandDelete {
    static String appendAndDelete(String s, String t, int k) {
        String result = "";
        if(s.equals(t)){
            int value = (s.length()*2)+1;
            if(k>value)
                result="No";
            else
                result="Yes";
        }else if(s.length() <= t.length()){
            int k1 = 0;
            int pos = -1;
            int value = 0;
            while(k1<s.length()){
                if(t.charAt(k1) != s.charAt(k1)){
                    pos = k1;
                    break;
                }
                k1+=1;
            }
            if(pos == 0){
                value = t.length() + 2;
                if(value<=k)
                    result="Yes";
                else
                    result="No";
            }else if(pos<0){
                int temp = t.length() - s.length();
                if((k-temp)<s.length())
                    result="Yes";
                else
                    result="No";
            }else{
                int tempPosition = s.length() - pos;
                value = (t.length()-pos)+tempPosition;
                if(value==k)
                    result="Yes";
                else
                    result="No";
            }
        }else if(s.length() > t.length()){
            int k1=0,pos=-1,value=0;
            while(k1<t.length()){
                if(s.charAt(k1) != t.charAt(k1)){
                    pos = k1;
                    break;
                }
                k1+=1;
            }
            if(pos<0){
                value = s.length()-t.length();
                if(value<=k)
                    result="Yes";
                else
                    result="No";
            }else{
                int tempPosition = s.length() - pos;
                value = (t.length()-pos)+tempPosition;
                if(value<=k)
                    result = "Yes";
                else
                    result = "No";
            }
        }
        return result;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputDemo.txt"));
        String line = "";
        String s = "",t="";
        int k=0;
        while((buffer.readLine())!=null){
            line = buffer.readLine();
        }
        String[] strAr = line.split(" ");
        s = strAr[0];
        t = strAr[1];
        k = Integer.parseInt(strAr[2]);
        System.out.println(appendAndDelete(s,t,k));
        buffer.close();
    }
}
