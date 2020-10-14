package Hacker;
import java.io.*;
public class BeautifulBinaryString {
    static int beautifulBinaryString(String s) {
        int count = 0,counter= 0;
        String str = "010",temp="";
        char[] charArray = s.toCharArray();
        for(int i=0;i<=charArray.length-3;i++){
            int pos = i;
            count = 0;
            temp = "";
            while(count<3){
                temp+=String.valueOf(charArray[pos]);
                count++;
                pos++;
            }
            //System.out.println(temp);
            if(temp.equals(str)){
                counter++;
                charArray[pos-1] = '1';
            }
        }
        return counter;
    }
	public static void main(String [] args)throws IOException{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(beautifulBinaryString(buffer.readLine()));
        buffer.close();
	}
}
