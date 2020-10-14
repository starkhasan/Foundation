package Hacker;
import java.io.*;

public class BeautifulDaysAtMovies {
    static String reverse(String number){
        String temp = "";
        for(int i=number.length()-1;i>=0;i--){
            temp = temp + String.valueOf(number.charAt(i));
        }
        return temp;
    }
    static int beautifulDays(int i, int j, int k) {
        int daysCount = 0;
        for(int p=i;p<=j;p++){
            int newNum = Math.abs(p - Integer.parseInt(reverse(String.valueOf(p))));
            System.out.print(newNum+" ");
            if(newNum%k == 0){
                daysCount++;
            }
        }
        return daysCount;
    }
	public static void main(String [] args)throws IOException{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nOutput = "+beautifulDays(13,45,3));	
        buffer.close();
	}
}
