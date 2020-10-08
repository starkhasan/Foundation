import java.io.*;
import java.util.*;
public class EqualArrayMethod {
    static void isEqualArray(int[] A,int[] B){
        if(Arrays.equals(A,B))
            System.out.println("Equal");
        else
            System.out.println("Different");
    }
    static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    static void assignArray(int[] ar,String[] str){
        int i = 0;
        for(;i<str.length;i++)
            ar[i] = Integer.parseInt(str[i]);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputDemo.txt"));
        String first = "",second = "";
        boolean isFirst = true;
        while((buffer.readLine())!=null){
            if(isFirst){
                isFirst = false;
                first = buffer.readLine();
            }else                
                second = buffer.readLine();
        }
        int[] arr = new int[first.split(" ").length];
        int[] brr = new int[second.split(" ").length];
        assignArray(arr, first.split(" "));
        assignArray(brr, second.split(" "));
        isEqualArray(arr,brr);
        buffer.close();
    }
}
