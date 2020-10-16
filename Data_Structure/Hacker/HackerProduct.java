package Hacker;
import java.io.*;
public class HackerProduct {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] string_array = buffer.readLine().split(" ");
        
        int ar[] = new int[string_array.length];
        for(int i=0;i<string_array.length;i++){
            ar[i] = Integer.parseInt(string_array[i]);
        }

		System.out.println();
        long sum = 1L;
        for(int i=0;i<string_array.length;i++){
        	sum = sum * ar[i];
        }

        System.out.println("Summation = "+sum);
        buffer.close();
    }
        
}
