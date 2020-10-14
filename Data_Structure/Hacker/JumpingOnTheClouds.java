package Hacker;
import java.io.*;
public class JumpingOnTheClouds {
    static int jumpingOnClouds(int[] c, int k) {
        int energy = 100;
        int pos = 0;
        while(true){
            pos+=k;
            if(pos < c.length){
                if(c[pos] == 1)
                    energy-=3;
                else
                    energy-=1;
            }else if(pos == c.length){
                if(c[0] == 1)
                    energy-=3;
                else
                    energy-=1;
                break;
            }else{
                pos = pos - c.length;
                if(c[pos] == 1)
                    energy-=3;
                else
                    energy-=1;
            }
        }
        return energy;
    }
	public static void main(String [] args)throws IOException{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the Array : ");
		String[] strArray = buffer.readLine().split(" ");
		int[] ar = new int[strArray.length];
		for(int i=0;i<strArray.length;i++){
			ar[i] = Integer.parseInt(strArray[i]);
		}
		System.out.println("Enter Number of the Step");
		int k = Integer.parseInt(buffer.readLine());
        System.out.println(jumpingOnClouds(ar,k));
        buffer.close();
	}
}
