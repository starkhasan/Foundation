package Hacker;
import java.io.*;
public class SaveThePrisoner {
    static int saveThePrisoner(int n, int m, int s) {
        int temp = (s-1 + m-1)%n +1;
        return temp;
    }
	public static void main(String [] args)throws IOException{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(saveThePrisoner(3830347,568814045,3368104));
        buffer.close();
	}    
}
