package Hacker;
import java.util.*;
import java.io.*;
public class QuickPartition {
    static int[] quickSort(int[] arr) {
        List<Integer> left = new ArrayList<Integer>();
        List<Integer> right = new ArrayList<Integer>();
        List<Integer> equal = new ArrayList<Integer>();
        int pivot = arr[0];
        for(int i=0;i<arr.length;i++){
            if(pivot == arr[i]){
            	equal.add(arr[i]);
            }else if(pivot > arr[i]){
            	left.add(arr[i]);
            }else{
            	right.add(arr[i]);
            }
        }
        int[] a;
        if(left.size()>0){
        	for(int i=0;i<equal.size();i++){
        		left.add(equal.get(i));
        	}
        	
        	if(right.size()>0){
        		for(int i=0;i<right.size();i++){
        			left.add(right.get(i));
        		}
        	}
        	a = new int[left.size()];
        	for(int i=0;i<left.size();i++){
        		a[i] = left.get(i);
        	}
    	}else if(right.size() > 0){
    		for(int i=0;i<right.size();i++){
        		equal.add(right.get(i));
        	}
        	a = new int[equal.size()];
        	for(int i=0;i<equal.size();i++){
        		a[i] = equal.get(i);
        	}
		}else{
			a = new int[equal.size()];
        	for(int i=0;i<equal.size();i++){
        		a[i] = equal.get(i);
        	}
		}
		
		return a;
    }
	public static void main(String [] args)throws IOException{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		String[] strAr = buffer.readLine().split(" ");
		int[] ar = new int[strAr.length];
		for(int i=0;i<strAr.length;i++){
			ar[i] = Integer.parseInt(strAr[i]);
		}
		//quickSort(ar);
		int[] newAr = quickSort(ar);
		for(int i=0;i<newAr.length;i++){
			System.out.print(newAr[i]+" ");
        }
        buffer.close();
	}
}
