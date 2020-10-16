package Hacker;
import java.util.*;
import java.io.*;
public class SalesByMatch {
    static int sockMerchant(int n, int[] ar) {
        List<Integer> list = new ArrayList<>();
        int pairs = 0,count = 0;
        for(int i=0;i<ar.length;i++){
            if(!list.contains(ar[i]))
                list.add(ar[i]);
        }
        for(int i=0;i<list.size();i++){
            count = 0;
            for(int j=0;j<ar.length;j++){
                if(list.get(i) == ar[j])
                    count++;
            }
            pairs+=count/2;
        }

        return pairs;
    }
    static void printArray(int[] ar){
        for(int i=0;i<ar.length;i++){
            System.out.print(ar[i]+" ");
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputHacker.txt"));
        String second = "";
        while((buffer.readLine())!=null){
            second = buffer.readLine();
        }
        int[] ar = new int[second.split(" ").length];
        for(int i=0;i<second.split(" ").length;i++){
            ar[i] = Integer.parseInt(second.split(" ")[i]);
        }
        System.out.println(sockMerchant(ar.length,ar));
        buffer.close();
    }
}
