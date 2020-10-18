package Hacker;
import java.io.*;
public class JavaForLoop2 {
    static void ForLoop2(int a,int b,int n){
        int sum = 0;
        for(int i=0;i<n;i++){
            int temp = (int)Math.pow(2,i);
            if(i==0)
                sum = a + (temp*b);
            else
                sum+=temp*b;
            System.out.print(sum+" ");
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputHacker.txt"));
        boolean isFirst = true,isSecond = true;
        int a = 0,b = 0,n = 0;
        while((buffer.readLine())!=null){
            if(isFirst){
                isFirst = false;
                a = Integer.parseInt(buffer.readLine());
            }else if(isSecond){
                isSecond = false;
                b = Integer.parseInt(buffer.readLine());
            }else{
                n = Integer.parseInt(buffer.readLine());
            }
        }
        ForLoop2(a,b,n);
        buffer.close();
    }
}
