import java.io.*;
import java.util.*;
public class MaximumMoney {
    static int maximumMoney(int N,int K){
        int money = 0;
        for(int i=1;i<=N;i++){
            if(i%2!=0){
                money+=K;
            }
        }
        return money;
   } 
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputDemo.txt"));
        int N = 0,K = 0;
        boolean isFirst = true;
        while((buffer.readLine())!=null){
            if(isFirst){
                isFirst = false;
                N = Integer.parseInt(buffer.readLine());
            }else{
                K = Integer.parseInt(buffer.readLine());
            }
        }
        int result = maximumMoney(N, K);
        System.out.println("Maximum Money = "+result);
        buffer.close();
    }
}
