import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class CountingSortCounter {
    static int partition(int[] a,int p,int r){
        int key = a[r];
        int i = p - 1;
        for(int j=p;j<r;j++){
            if(a[j] < key){
                i+=1;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[r];
        a[r] = a[i+1];
        a[i+1] = temp;
        return i+1;
    }
    static void quickSort(int[] a,int p,int r){
        if(p<r){
            int q = partition(a,p,r);
            quickSort(a,p,q-1);
            quickSort(a,q+1,r);
        }
    }
    static int[] countingSort(int[] arr) {
    	quickSort(arr,0,arr.length-1);
        int max = arr[arr.length-1];
        System.out.println(max);
        int[] countArr = new int[max+1];
        for(int i=0;i<=max;i++){
            countArr[i] = 0;
        }
        for(int j=0;j<arr.length;j++){
            countArr[arr[j]] = countArr[arr[j]] + 1;
        }
        
        return countArr;
    }
	public static void main(String [] args)throws IOException{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the Array : ");
		String[] strAr = buffer.readLine().split(" ");
		int[] ar = new int[strAr.length];
		for(int i=0;i<strAr.length;i++){
			ar[i] = Integer.parseInt(strAr[i]);
		}
		int[] newArr = countingSort(ar);
		for(int i=0;i<newArr.length;i++){
			System.out.print(newArr[i]+" ");
		}
	}
}
