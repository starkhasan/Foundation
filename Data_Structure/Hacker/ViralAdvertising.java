package Hacker;
import java.io.*;
public class ViralAdvertising {
    static int viralAdvertising(int n) {
        int like_people = 0;
        int total_people = 5;
        for(int i=0;i<n;i++){
            int temp = total_people / 2;
            like_people+=temp;
            temp = temp * 3;
            total_people = temp;
        }
        return like_people;
    }
	public static void main(String [] args)throws IOException{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(viralAdvertising(3));
        buffer.close();	
	}
}
