import java.util.*;
import java.io.*;
class Demo{

    static int partition(int[] ar,int p,int r){
        int key = ar[r];
        int i = p-1;
        for(int j=p;j<r;j++){
            if(ar[j] < key){
                i+=1;
                int temp = ar[i];
                ar[i] = ar[j];
                ar[j] = temp;
            }
        }
        int temp = ar[i+1];
        ar[i+1] = ar[r];
        ar[r] = temp;
        return i+1;
    }
    
    static void sort(int[] ar,int p,int r){
        if(p<r){
            int q = partition(ar,p,r);
            sort(ar,p,q-1);
            sort(ar,q+1,r);
        }
    }
    static void printArray(int[] ar){
        for(int i=0;i<ar.length;i++){
            System.out.print(ar[i]+" ");
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputDemo.txt"));
        String input = "";
        while((buffer.readLine())!=null){
            input = buffer.readLine();
        }
        String[] strAr = input.split(" ");
        int[] ar = new int[strAr.length];
        for(int i=0;i<strAr.length;i++)
            ar[i] = Integer.parseInt(strAr[i]);
        sort(ar,0,ar.length-1);
        printArray(ar);
        buffer.close();
    }
}