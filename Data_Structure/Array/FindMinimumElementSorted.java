import java.io.*;
public class FindMinimumElementSorted {

    public static int findMiminum(int[] ar,int left,int right){
        if(right < left) return arr[0];
        if(right == left) return arr[0];
        int mid = (left+right)/2;
    }

    public static void main(String[] args) {
        BufferedReader buffer = new BufferedReader(new FileRader("InputArray.txt"));
        String input = "";
        while(buffer.readLine()!=null){
            input = buffer.readLine();
        }


        String[] strAr = input.split(" ");
        int[] ar = new int[strAr.length];
        for(int i=0;i<strAr.length;i++){
            ar[i] = Integer.parseInt(strAr[i]);
        }

    }
}
