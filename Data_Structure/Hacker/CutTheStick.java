package Hacker;
import java.io.*;
import java.util.*;
public class CutTheStick {
    static int minNumber(int[] arr){
        int min = 0;
        boolean first = true;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 0){
                continue;
            }else{
                if(first){
                    min = arr[i];
                    first = false;
                }
                else if(min > arr[i]){
                    min = arr[i];
                }
            }
        } 
        return min;
    }
    static int[] cutTheSticks(int[] arr) {
        Set<Integer> set = new HashSet<>();
        List<Integer> listArray = new ArrayList<Integer>();
        int min = 0;
        int count = 0,j=0;
        while(j<arr.length){
            count=0;
            min = minNumber(arr);
            for(int i=0;i<arr.length;i++){
                if(arr[i] >= 1){
                    int temp = arr[i] - min;
                    if(temp < 0)
                        arr[i] = 0;
                    else
                        arr[i] = temp;
                    count++;
                }
                set.add(arr[i]);
            }
            if(count>0)
                listArray.add(count);
            if(set.size() == 1 && arr[0] == 0){
                break;
            }
            j+=1; 
        }
        int[] newAr = new int[listArray.size()];
        for(int k=0;k<listArray.size();k++)
            newAr[k] = listArray.get(k);
        return newAr;
    }
	public static void main(String [] args)throws IOException{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Array : ");
		String[] strAr = buffer.readLine().split(" ");
		int[] ar = new int[strAr.length];
		for(int i=0;i<strAr.length;i++)
			ar[i] = Integer.parseInt(strAr[i]);
		int[] newAr = cutTheSticks(ar);
		System.out.println("Final Array : ");
		for(int i=0;i<newAr.length;i++)
			System.out.print(newAr[i]+" ");
	}
}
