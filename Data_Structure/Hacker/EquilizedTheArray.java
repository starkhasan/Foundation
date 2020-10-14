package Hacker;
import java.io.*;
public class EquilizedTheArray {
    static int repeat(int[] ar){
        int count = 0;
        int element = 0;
        for(int i=0;i<ar.length;i++){
            if(element!=ar[i]){
                element = ar[i];
                int temp = 0;
                for(int j=0;j<ar.length;j++){
                    if(element == ar[j]){
                        temp++;
                    }
                }
                if(count < temp){
                    count = temp;
                }
            }else{
                continue;
            }
        }
        return count;
    }
    static int equalizeArray(int[] arr) {
        int repeat_element = repeat(arr);
        return (arr.length - repeat_element);
    }
	public static void main(String [] args)throws IOException{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the Array : ");
		String[] strAr = buffer.readLine().split(" ");
		int[] ar = new int[strAr.length];
		for(int i=0;i<strAr.length;i++){
			ar[i] = Integer.parseInt(strAr[i]);
		}
        System.out.println(equalizeArray(ar));
        buffer.close();
	}
}
/*
//Alternate Solution
import java.util.*;
import java.io.*;
class Demo{
	static void printArray(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
	static int maxElement(int[] arr){
        int max = 0;
        for(int i=0;i<arr.length;i++){
            if(i==0)
                max = arr[i];
            else if(max < arr[i])
                max = arr[i];
        }
        return max;
    }
    static int maxRepeat(int[] arr){
    	//printArray(arr);
        int max = maxElement(arr);
        //System.out.println("\nMax = "+max);
        int count = 0;
        int[] countArr = new int[max+1];
        for(int i=0;i<max;i++){
            countArr[i] = 0;
        }
        //printArray(countArr);
        //System.out.println();
        for(int i=0;i<arr.length;i++){
            countArr[arr[i]] = countArr[arr[i]] + 1;
        }	
        max = maxElement(countArr);
        for(int i=0;i<countArr.length;i++){
        	if(max == countArr[i])
        		count++;
    	}
    	return max;
    }
    static int equalizeArray(int[] arr) {
        int temp = maxRepeat(arr);
        return arr.length-temp;
    }
	public static void main(String [] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("InputEqualizedArray.txt"));
		String input = "";
		while((br.readLine())!=null){
			input = br.readLine();
		}
		String[] strAr = input.split(" ");
		int[] ar = new int[strAr.length];
		for(int i=0;i<strAr.length;i++){
			ar[i] = Integer.parseInt(strAr[i]);
		}
		System.out.println(equalizeArray(ar));
	}
}
*/
