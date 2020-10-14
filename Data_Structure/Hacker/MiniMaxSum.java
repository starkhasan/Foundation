package Hacker;
import java.io.*;
public class MiniMaxSum {
    static void miniMaxSum(int[] arr) {
		long min=0,max=0,temp=0;
		for(int i=0;i<arr.length;i++){
			temp = 0;
			for(int j=0;j<arr.length;j++){
				if(j==i){
					continue;
				}else{
					temp+=(long)arr[j];
				}
			}
			if(i==0){
				min=max=temp;
			}else{
				if(min > temp){
					min = temp;
				}
				if(max < temp){
					max = temp;
				}
			}
		}
		System.out.println(min+" "+max);	
    }
	public static void main(String [] args)throws IOException{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the Array : ");
		String[] strArray = buffer.readLine().split(" ");
		int[] ar = new int[strArray.length];
		for(int i=0;i<strArray.length;i++){
			ar[i] = Integer.parseInt(strArray[i]);
		}
        miniMaxSum(ar);
        buffer.close();
	}
}
