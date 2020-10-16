package Hacker;
import java.io.*;

public class StrongPassword {
    static boolean isStrong(int order,String password){
        boolean strong = false;
        switch(order){
            case 1:
            	if(password.matches(".*[a-z].*")){
            		strong = true;
            	}else{
            		System.out.println("Small letter not Present");
            	}
                break;
            case 4:
                if(password.length() >= 6){
                    strong = true;
                }else{
            		System.out.println("Length less than 6");
            	}
                break;
            case 2:
                if(password.matches(".*\\d.*")){
            		strong = true;
            	}else{
            		System.out.println("Digit not present");
            	}
                break;
            case 3:
                if(password.matches(".*[A-Z].*")){
            		strong = true;
            	}else{
            		System.out.println("Capital letter not present");
            	}
                break;
            case 0:
            	if(password.matches(".*[-!@#$%^&*()+].*")){
            		strong = true;
            	}else{
            		System.out.println("Special character not present");
            	}
                break;
        }
        return strong;
    }
    static int minimumNumber(int n, String password) {
        int count = 0;
        int requirement = 0;
        boolean strongPassword = false;
        while(count<5){
            switch(count){
                case 0:
                    strongPassword = isStrong(0,password);
                    if(!strongPassword){
                    	password = password + String.valueOf("@");
                	}
                    break;
                case 1:
                    strongPassword = isStrong(1,password);
                    if(!strongPassword){
                    	password = password + String.valueOf("a");
                	}
                    break;
                case 2:
                    strongPassword = isStrong(2,password);
                    if(!strongPassword){
                    	password = password + String.valueOf("2");
                	}
                    break;
                case 3:
                    strongPassword = isStrong(3,password);
                    if(!strongPassword){
                    	password = password + String.valueOf("A");
                	}
                    break;
                case 4:
                    strongPassword = isStrong(4,password);
                    if(!strongPassword){
                    	int pass_length = 6 - password.length();
                    	requirement+=pass_length-1;
                	}
                    break;
            }
            if(!strongPassword){
                requirement+=1;
            }
            count++;
        }
        return requirement;
    }
	public static void main(String [] args)throws IOException{
        //Scanner sc = new Scanner(System.in);
        BufferedReader buffer = new BufferedReader(new FileReader("InputHacker.txt"));
        String password = "";
        while((buffer.readLine())!=null){
            password = buffer.readLine();
        }
		int number = minimumNumber(password.length(),password);
        System.out.println("Minimum Requirement = "+number);
        buffer.close();
	}
}
