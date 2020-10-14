package Hacker;
import java.io.*;
public class SaveThePrisoner {
    static int saveThePrisoner(int n, int m, int s) {
        int position = 0;
        int remaining = 0;
        if(m>=n){
            remaining = m%n;
            if(remaining == 0){
                if((s-1) < 0){
                    position = n;
                }else{
                    position = s-1;
                }
            }else{
                if((s-1+remaining) <= n){
                    position = s-1+remaining;
                }else{
                    position = s-1+remaining;
                    position = position - n;
                }
            }
        }else{
            if(m+s <= n){
                position = m+s-1;
            }else{
                position = (s+m) - (n+1);
            }
        }
        return position;
    }
	public static void main(String [] args)throws IOException{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		SaveThePrisoner d = new SaveThePrisoner();
        System.out.println(saveThePrisoner(3830347,568814045,3368104));
        buffer.close();
	}    
}
