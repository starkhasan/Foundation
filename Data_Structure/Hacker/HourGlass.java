package Hacker;
import java.io.*;
import java.util.*;
public class HourGlass {
    static int calculation(int[][] ar){
        int ar_size = ar.length;
        int count = 0;
        for(int i=0;i<ar_size;i++){
            for(int j=0;j<ar_size;j++){
                if((i==1 && j==0) || (i==1 &&j==2)){
                    continue;
                }else{
                    count+=ar[i][j];
                }
            }
        }
        return count;
    }
    static int hourglassSum(int[][] arr) {
        int outer_count = 0;
        int inner_count = 0;
        int result = 0;
        boolean isFirst = true;
        for(int i=0;i<=arr.length-3;i++){
            for(int j=0;j<=arr.length-3;j++){
                int k=i;
                int l=j;
                int temp[][] = new int[3][3];
                outer_count = 0;
                while(outer_count<3){
                	l=j;
                	inner_count = 0;
                    while(inner_count<3){
                        temp[outer_count][inner_count] = arr[k][l];
                        inner_count++;
                        l++;
                    }
                    k++;
                    outer_count++;
                }
                if(isFirst){
                    isFirst = false;
                    result = arrSum(temp);
                }else if(result < arrSum(temp)){
                    result = arrSum(temp);
                }
            }
        }
        return result;
    }
    static int[] assignArray(String str){
        String[] strAr = str.split(" ");
        int[] a = new int[strAr.length];
        for(int i=0;i<strAr.length;i++){
            a[i] = Integer.parseInt(strAr[i]);
        }
        return a;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputHacker.txt"));
        List<String> listString = new ArrayList<>();
        while((buffer.readLine())!=null){
            listString.add(buffer.readLine());
        } 
        int ar_size = listString.size();
        int[][] arr = new int[ar_size][ar_size];
        for(int i=0;i<ar_size;i++){
            arr[i] = assignArray(listString.get(i));
        }
        int n = hourglassSum(arr);
        System.out.println(n);
        buffer.close();
    }
}
