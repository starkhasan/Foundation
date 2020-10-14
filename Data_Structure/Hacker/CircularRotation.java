package Hacker;
import java.io.*;
import java.util.*;
public class CircularRotation {
    static void rotation(int[] a,int k){
        int count=0;
        while(count<k){
            int key = a[a.length-1];
            for(int i=a.length-2;i>=0;i--){
                a[i+1] = a[i];
            }
            a[0] = key;
            count++;
        }
    }
    static int[] circularArrayRotation(int[] a, int k, int[] queries) {
        if(k!=a.length)
            rotation(a,k);
        int[] result = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            result[i] = a[queries[i]];
        }
        return result;
    }
    static void printArray(int[] ar){
        for(int i=0;i<ar.length;i++){
            System.out.println(ar[i]+" ");
        }
    }
    public static void main(String [] args)throws IOException{
        List<Integer> listQueries = new ArrayList<>();
        BufferedReader buffer = new BufferedReader(new FileReader("InputCircularRotation.txt"));
        String inputAray="";
        int n = 0;
        boolean isFirst = true,isSecond=true;
        while((buffer.readLine())!=null){
            if(isFirst){
                n = Integer.parseInt(buffer.readLine());
                isFirst = false;
            }else if(isSecond){
                inputAray = buffer.readLine();
                isSecond = false;
            }else{
                listQueries.add(Integer.parseInt(buffer.readLine()));
            }
        }
        String[] strA = inputAray.split(" ");
        int[] a = new int[strA.length];
        for(int i=0;i<strA.length;i++){
            a[i] = Integer.parseInt(strA[i]);
        }
        int[] query = new int[listQueries.size()];
        for(int i=0;i<listQueries.size();i++){
            query[i] = listQueries.get(i);
        }
        int[] result = circularArrayRotation(a, n, query);
        System.out.println("Result : ");
        printArray(result);
        buffer.close();
    }
}
