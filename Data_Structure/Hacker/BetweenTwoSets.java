package Hacker;
import java.io.*;
import java.util.*;
public class BetweenTwoSets {
    public static int min(List<Integer> b){
        Collections.sort(b);
        return b.get(0);
    }
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int  minElement = min(b);
        List<Integer> listResult = new ArrayList<Integer>();
        boolean isDivisible = true;
        int count = 0,temp=0;
        for(int i=1;i<=minElement;i++){
            temp = i;
            isDivisible = true;
            for(int j=0;j<a.size();j++){
                if(temp%a.get(j)!=0){
                    isDivisible=false;
                    break;
                }
            }
            if(isDivisible)
                listResult.add(i);
        }
        for(int i=0;i<listResult.size();i++){
            temp = listResult.get(i);
            isDivisible=true;
            for(int j=0;j<b.size();j++){
                if(b.get(j)%temp!=0){
                    isDivisible = false;
                    break;
                }
            }
            if(isDivisible){
                count++;
            }
        }
        return  count;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputHacker.txt"));
        List<Integer> a = new ArrayList<Integer>();
        List<Integer> b = new ArrayList<Integer>();
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
            a.add(Integer.parseInt(first.split(" ")[i]));
        }
        for(int i=0;i<second.split(" ").length;i++){
            b.add(Integer.parseInt(second.split(" ")[i]));
        }
        System.out.println(getTotalX(a,b));
        buffer.close();
    }
}
