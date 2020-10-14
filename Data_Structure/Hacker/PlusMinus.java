package Hacker;
import java.io.*;
public class PlusMinus {
    static void plusMinus(int[] arr) {
		int plus=0,minus=0,zero=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i] > 0){
				plus++;
			}else if(arr[i] < 0){
				minus++;
			}else if(arr[i] == 0){
				zero++;
			}
		}
		System.out.println(String.format("%.6f",(double)plus/arr.length));
		System.out.println(String.format("%.6f",(double)minus/arr.length));
		System.out.println(String.format("%.6f",(double)zero/arr.length));
    }
	public static void main(String [] args)throws IOException{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the Array : ");
		String[] strArray = buffer.readLine().split(" ");
		int[] ar = new int[strArray.length];
		for(int i=0;i<strArray.length;i++){
			ar[i] = Integer.parseInt(strArray[i]);
		}
        plusMinus(ar);
        buffer.close();
	}
}
