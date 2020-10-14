package Hacker;
import java.io.*;
public class BinaryNumberCount {
    public static void main(String [] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Number : ");
		int number = Integer.parseInt(br.readLine());
		String binary = "";
		while(number > 0){
			int temp = number%2;
			binary = binary + String.valueOf(temp);
			number/=2;
		}
		System.out.println(binary);
		int i=0,j=0,count=0,max=0;
		while(i<binary.length()){
			j=i;
			count=0;
			while(j<binary.length()){
				if(Integer.parseInt(String.valueOf(binary.charAt(j))) == 1){
					count++;
				}else{
					break;
				}
				j++;	
			}
			if(i==0){
				max = count;
				
			}else if(max < count){
				max = count;
			}
			i++;
		}
		
		System.out.println(max);
		br.close();
	}
}
