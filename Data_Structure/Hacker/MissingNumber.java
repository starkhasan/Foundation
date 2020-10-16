package Hacker;
import java.util.*;
import java.io.*;
public class MissingNumber {
    static int partition(int[] arr,int p,int r){
        int key = arr[r];
        int i = p - 1;
        for(int j=p;j<r;j++){
            if(key > arr[j]){
                i+=1;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[r];
        arr[r] = temp;
        return i+1;
    }
    static void sortArray(int[] arr,int p,int r){
        if(p<r){
            int q = partition(arr,p,r);
            sortArray(arr, p, q-1);
            sortArray(arr, q+1, r);
        }
    }
    static int[] missingNumbers(int[] arr, int[] brr) {
        List<Integer> listMissing = new ArrayList<Integer>();
        HashMap<Integer,Integer> mapOne = new HashMap<>();
        HashMap<Integer,Integer> mapTwo = new HashMap<>();
        
        for(int i=0;i<brr.length;i++){
            if(!mapTwo.containsKey(brr[i]))
                mapTwo.put(brr[i],1);
            else{
                int temp = mapTwo.get(brr[i]);
                mapTwo.put(brr[i],temp+1);
            }
        }

        for(int i=0;i<arr.length;i++){
            if(!mapOne.containsKey(arr[i]))
                mapOne.put(arr[i],1);
            else{
                int temp = mapOne.get(arr[i]);
                mapOne.put(arr[i],temp+1);
            }
        }

        Object[] keys = mapTwo.keySet().toArray();
        for(int i=0;i<keys.length;i++){
            if(!listMissing.contains(keys[i])){
                if(!mapOne.containsKey(keys[i])){
                    listMissing.add((int)keys[i]);
                }else{
                    if((int)mapOne.get(keys[i]) != (int)mapTwo.get(keys[i])){
                        listMissing.add((int)keys[i]);
                    }
                }
            }
        }
        int[] result = new int[listMissing.size()];
        for(int i=0;i<listMissing.size();i++){
            result[i] = listMissing.get(i);
        }
        sortArray(result,0,result.length-1);
        return result;
    }
    static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputDemo.txt"));
        String first = "",second = "";
        boolean isFirst = true;
        while((buffer.readLine())!=null){
            if(isFirst){
                isFirst = false;
                first = buffer.readLine();
            }else{
                second = buffer.readLine();
            }
        }
        String[] strA = first.split(" ");
        String[] strB = second.split(" ");
        int[] firstAr = new int[strA.length];
        int[] secondAr = new int[strB.length];
        for(int i=0;i<strA.length;i++)
            firstAr[i] = Integer.parseInt(strA[i]);
        for(int i=0;i<strB.length;i++)
            secondAr[i] = Integer.parseInt(strB[i]);
        int[] result = missingNumbers(firstAr,secondAr);
        printArray(result);
        buffer.close();
    }
}
