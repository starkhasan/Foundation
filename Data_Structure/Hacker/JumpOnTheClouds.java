package Hacker;
import java.io.*;
public class JumpOnTheClouds {
    static int jumpingOnClouds(int[] ar) {
        int jumpCount = 0,index = 0,pos=0;
        while(true){
            pos = index;
            pos+=2;
            if(pos<ar.length){
                if(ar[index+1] == 1 && ar[index+2] == 1)
                    break;
                else if(ar[index+2]!=1){
                    index+=2;
                    jumpCount+=1;
                }else{
                    index+=1;
                    jumpCount+=1;
                }
            }else{
                if(index == ar.length-1)
                    break;
                else if(ar[index+1]!=1){
                    index+=1;
                    jumpCount+=1;
                }
            }
        }
        return jumpCount;
    }
	public static void main(String [] args)throws IOException{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the Array : ");
		String[] strArray = buffer.readLine().split(" ");
		int[] ar = new int[strArray.length];
		for(int i=0;i<strArray.length;i++){
			ar[i] = Integer.parseInt(strArray[i]);
		}
        System.out.println(jumpingOnClouds(ar));
        buffer.close();
	}
}
