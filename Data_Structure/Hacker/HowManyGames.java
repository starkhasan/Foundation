package Hacker;
import java.io.*;
public class HowManyGames {
    static int howManyGames(int p, int d, int m, int s) {
        int count = 0;
        int expanse = p;
        while(expanse <= s){
            if(p > m){
                p-=d;
                if(p<m)
                	p=m;
            }else{
                p=m;
            }
            count++;
            expanse+=p;
        }
        return count;
    }
	public static void main(String [] args)throws IOException{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(howManyGames(20,3,6,85));
        buffer.close();
	}
}
