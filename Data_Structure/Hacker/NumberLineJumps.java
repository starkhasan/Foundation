package Hacker;
import java.io.*;
public class NumberLineJumps {
    static String kangaroo(int x1, int v1, int x2, int v2) {
        String result = "NO";
        if((x1>x2 && v1>v2) || (x1<x2 && v1<v2)){
            result = "NO";
        }else{
            for(int i=0;i<10000;i++){
                x1+=v1;
                x2+=v2;
                if(x1 == x2){
                    result = "YES";
                    break;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputHacker.txt"));
        String input = "";
        while((buffer.readLine())!=null){
            input = buffer.readLine();
        }
        String[] strAr = input.split(" ");
        int x1 = Integer.parseInt(strAr[0]);
        int v1 = Integer.parseInt(strAr[1]);
        int x2 = Integer.parseInt(strAr[2]);
        int v2 = Integer.parseInt(strAr[3]);
        System.out.println(kangaroo(x1,v1,x2,v2));
        buffer.close();
    }
}
