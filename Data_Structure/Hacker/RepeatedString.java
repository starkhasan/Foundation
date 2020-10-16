package Hacker;
import java.io.*;
public class RepeatedString {
    static long repeationOrder(String str){
		long count = 0;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i) == 'a')
				count++;
		}
		return count;
	}
	static long repeatedString(String s, long n) {
		long repeatedNumber = 0;
		long quotient = n/s.length();
		long temp = repeationOrder(s);
		if(n%s.length() == 0){
			repeatedNumber = quotient*temp;
		}else{
			long remainder = n%s.length();
			repeatedNumber = (quotient*temp) + repeationOrder(s.substring(0,(int)remainder));
		}
		return repeatedNumber;	
    }
	public static void main(String [] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("InputRepeatedString.txt"));
		boolean isFirst = true;
		String str = "";
		long n = 0;
		while((br.readLine())!=null){
			if(isFirst){
				isFirst = false;
				str = br.readLine();
			}else{
				n = Long.parseLong(br.readLine());
			}
		}
		System.out.println(repeatedString(str,n));
		br.close();
	}
}
