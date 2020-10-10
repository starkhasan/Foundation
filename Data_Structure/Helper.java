package helper;
import java.util.*;
public class Helper {

    public static int partition(int[] ar,int p,int r){
        int key = ar[r];
        int i = p - 1;
        for(int j=p;j<r;j++){
            if(key > ar[j]){
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
    public static void quickSort(int[] ar,int p,int r){
        if(p<r){
            int q = partition(ar,p,r);
            quickSort(ar,p,q-1);
            quickSort(ar,q+1,r);
        }
    }
    /*------------------------------Class Method Don't Call that method in other class -------------------------*/

    public static int[] assignArray(String[] strArray){
        int[] ar = new int[strArray.length];
        for(int i=0;i<strArray.length;i++)
            ar[i] = Integer.parseInt(strArray[i]);
        return ar;
    }
    public static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void sortArray(int[] ar){
        quickSort(ar,0,ar.length-1);
    }
    public static void reverseArray(int[] ar){
        int n = 0,m = 0,temp = 0;
        n = m = ar.length;
        if(n%2 == 0)
            n = n/2;
        else
            n = (n+1)/2;
        for(int i=0;i<n;i++){
            temp = ar[i];
            ar[i] = ar[m-1-i];
            ar[m-1-i] = temp;
        }
    }

    public static int maxArray(int[] arr){
        int max = 0;
        for(int i=0;i<arr.length;i++){
            if(i==0)
                max = arr[i];
            else if(max < arr[i])
                max = arr[i];
        }
        return max;
    }
}
