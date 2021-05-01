import java.io.*;
public class RotationClockWise {
    public static void rotateClockWise(int[] ar){
        int lastElement = ar[ar.length-1];
        for(int i= ar.length -1 ;i >= 1;i--){
            ar[i] = ar[i-1];
        }
        ar[0] = lastElement;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputArray.txt"));
        String input = "";
        while(buffer.readLine()!=null){
            input = buffer.readLine();
        }
        String[] strAr = input.split(" ");
        int[] ar = new int[strAr.length];
        for(int i=0;i<strAr.length;i++){
            ar[i] = Integer.parseInt(strAr[i]);
        }
        rotateClockWise(ar);
        for (int i : ar) {
            System.out.print(i+" ");
        }
        buffer.close();
    }
}
