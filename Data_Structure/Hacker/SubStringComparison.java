package Hacker;
import java.io.*;
public class SubStringComparison {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter String ");
        String str = buffer.readLine();
        System.out.println("Enter Count ");
        int k = Integer.parseInt(buffer.readLine());
        String max = "",min = "",temp = "";
        int count = 0,j = 0;
        for(int i=0;i<=str.length()-k;i++){
            j=i;
            count = 0;
            temp = "";
            while(count<k){
                temp = temp + String.valueOf(str.charAt(j));
                j++;
                count++;
            }
            if(i==0)
                min = max = temp;
            else{
                if(min.compareTo(temp) > 1)
                    min = temp;
                else if(max.compareTo(temp) < 1)
                    max = temp;
            }
        }
        System.out.println(min+" "+max);
        buffer.close();
    }
}
