import java.util.*;
import java.io.*;
public class SearchInsertPosition {
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
        int temp = ar[r];
        ar[r] = ar[i+1];
        ar[i+1] = temp;
        return i+1;
      }
      static void quickSort(int[] ar,int p,int r){
        if(p<r){
          int q = partition(ar,p,r);
          quickSort(ar, p, q-1);
          quickSort(ar, q+1, r);
        }
      }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputDemo.txt"));
        String input = "";
        boolean isFirst = true;
        int target = 0;
        while((buffer.readLine())!=null){
          if(isFirst){
            isFirst = false;
            input = buffer.readLine();
          }else{
            target = Integer.parseInt(buffer.readLine());
          }
        }
        String[] strAr = input.split(" ");
        int[] ar = new int[strAr.length];
        int i = 0;
        for(String s:strAr){
          ar[i] = Integer.parseInt(s);
          i++;
        }
        quickSort(ar, 0, ar.length-1);
        for(int a:ar)
          System.out.print(a+" ");
        int result = searchInsert(ar,target);
        System.out.println("\nResult  : "+result);
        buffer.close();
      }
}
