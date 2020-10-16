package Hacker;
import java.util.*;
import java.io.*;
public class SubArrayDivision {
    static int birthday(List<Integer> a,int d,int m){
        int count = 0,resultCount = 0,day = 0,pos=0;
        for(int i=0;i<=a.size()-m;i++){
            count = day = 0;
            pos = i;
            while(count<m){
                day+=a.get(pos);
                pos++;
                count++;
            }
            if(day == d)
                resultCount+=1;
        }

        return resultCount;
    }
    static void printArray(int[] ar){
        for(int i=0;i<ar.length;i++){
            System.out.print(ar[i]+" ");
        }
    }
    public static void main(String[] args) throws IOException{
        List<Integer> list = new ArrayList<>();
        BufferedReader buffer = new BufferedReader(new FileReader("InputHacker.txt"));
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
        for(int i=0;i<first.split(" ").length;i++){
            list.add(Integer.parseInt(first.split(" ")[i]));
        }
        int d = Integer.parseInt(second.split(" ")[0]);
        int m = Integer.parseInt(second.split(" ")[1]);
        System.out.println(birthday(list, d, m));
        buffer.close();
    }
}
