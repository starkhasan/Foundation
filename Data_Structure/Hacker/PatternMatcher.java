package Hacker;
import java.io.*;
public class PatternMatcher {
    public boolean isValid(String password){
		if(password.matches(".*[a-z].*")){
			return true;
		}
		return false;
	}
	public static void main(String [] args)throws IOException{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the Password : ");
		PatternMatcher obj = new PatternMatcher();
		if(obj.isValid(buffer.readLine())){
			System.out.println("Password is Valid");
		}else{
			System.out.println("Password is not Valid");
        }
        buffer.close();
	}
}
