package Hacker;
import java.util.*;
import java.io.*;
public class RemoveDuplicateFromArray {
    static int max(int[] ar){
		int max = 0;
		for(int i=0;i<ar.length;i++){
			if(i==0){
				max = ar[i];
			}else if(max < ar[i]){
				max = ar[i];
			}
		}
		return max;
	}
	static void SortUsingArray(String[] strAr){
		int[] ar = new int[strAr.length];
		for(int i=0;i<strAr.length;i++){
			ar[i] = Integer.parseInt(strAr[i]);
		}
		int max_ele = max(ar);
		int[] newAr = new int[max_ele+1];
		for(int i=0;i<=max_ele;i++)
			newAr[i] = 0;
		for(int i=0;i<ar.length;i++){
			newAr[ar[i]]+=1;
		}
		System.out.println();
		for(int i=0;i<newAr.length;i++){
		 	if(newAr[i]>0)
		 		System.out.println(i+" is repeated "+newAr[i]+" times");
		}
	}
	static void SortUsingList(String[] strAr){
		List<Integer> listArray = new ArrayList<>();
		for(int i=0;i<strAr.length;i++){
			System.out.print(strAr[i]+" ");
			if(!listArray.contains(Integer.parseInt(strAr[i]))){
				listArray.add(Integer.parseInt(strAr[i]));
			}
		}
		System.out.println("\nArray After Removing Duplicate Items");
		Iterator itr = listArray.iterator();
		while(itr.hasNext()){
			System.out.print(itr.next()+" ");
		}
	}
	public static void main(String [] args)throws IOException{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the Element in Array");
		String[] strAr = buffer.readLine().split("\\s|,");
		//SortUsingList(strAr);
        SortUsingArray(strAr);
        buffer.close();
	}
}
