package Hacker;
import java.io.*;
public class HackerEarth {
    public static void main(String args[] ) throws Exception{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
		boolean isValid = false;
		int i=0;
		while(i<input.length()-1){
			if(i==2){
			System.out.println(String.valueOf(isValid));
				if(input.charAt(i) == 'A' || input.charAt(i) == 'E' || input.charAt(i) == 'I' || input.charAt(i) == 'O' || input.charAt(i) == 'U' || input.charAt(i) == 'Y'){
					isValid = false;
					break;
				}else{
					isValid = true;
				}
				i++;
			}else{
				int sum = Integer.parseInt(String.valueOf(input.charAt(i))) + Integer.parseInt(String.valueOf(input.charAt(i+1)));
				if(sum%2 == 0){
					isValid = true;
				}else{
					isValid = false;
					break;
				}
				if(i==0){
					i=2;
				}else if(i==4){
					i=7;
				}else{
					i++;
				}
			}
		}
		if(isValid){
			System.out.println("valid");
		}else{
			System.out.println("invalid");
        }
        buffer.close();
    }
}
