import java.io.*;
import java.util.*;
public class Demo{
    static int arrSum(int[][] arr){
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(i==1 && (j==0 || j==2)){
                    continue;
                }else{
                    sum+=arr[i][j];
                }
            }
        }
        return sum;
    }
    static int hourglassSum(int[][] arr) {
        int n = arr.length;
        int result = 0;
        int count1=0,count2=0;
        boolean isFirst = true;
        for(int i=0;i<=n-3;i++){
            for(int j=0;j<=n-3;j++){
                int a = i;
                int b = j;
                int[][] temp = new int[3][3];
                count1 = 0;
                while(count1<3){
                    b=j;
                    count2 = 0;
                    while(count2<3){
                        temp[count1][count2] = arr[a][b];
                        b+=1;
                        count2+=1;
                    }
                    a+=1;
                    count1+=1;
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
        BufferedReader buffer = new BufferedReader(new FileReader("InputDemo.txt"));
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
