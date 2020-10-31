import java.util.*;
import java.io.*;
public class ElementAppearsOnce {
    static int getMax(int[] ar){
        int max = 0;
        for(int i=0;i<ar.length;i++){
            if(i==0)
                max = ar[i];
            else if(max < ar[i])
                max = ar[i];
        }
        return max;
    }
    static void printArray(int[] ar){
        for(int i=0;i<ar.length;i++)
            System.out.print(ar[i]+" ");
    }
    static int onceOccurance(int[] ar){
        int result = 0;
        int maxEle = getMax(ar);
        int[] temp = new int[maxEle+1];
        for(int i=0;i<=maxEle;i++)
            temp[i] = 0;
        
        for(int i=0;i<ar.length;i++){
            int item = temp[ar[i]];
            temp[ar[i]] = item+1;
        }
        //printArray(temp);
        for(int i=0;i<ar.length;i++){
            if(temp[ar[i]] == 1){
                result = ar[i];
            }
        }
        return result;
    }

    static int onceOccuranceSecond(int[] ar){
        ArrayList<Integer> listItem = new ArrayList<>();
        for(int i=0;i<ar.length;i++){
            if(!listItem.contains(ar[i])){
                listItem.add(ar[i]);
            }
        }
        int sum_non_duplicate = 0;
        for(int a:listItem){
            sum_non_duplicate+=a;
        }
        int sum_duplicate = 0;
        for(int b:ar){
            sum_duplicate+=b;
        }
        int result = (3*sum_non_duplicate - sum_duplicate)/2;
        return  result;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputDemo.txt"));
        String input = "";
        while((buffer.readLine())!=null){
            input = buffer.readLine();
        }
        String[] strAr = input.split(" ");
        int[] ar = new int[strAr.length];
        for(int i=0;i<strAr.length;i++){
            ar[i] = Integer.parseInt(strAr[i]);
        }
        int result = onceOccuranceSecond(ar);
        System.out.println("\n"+result);
        buffer.close();
    }    
}
