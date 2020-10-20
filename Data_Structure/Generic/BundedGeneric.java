package Generic;
import java.io.*;
class Stats<T extends Number>{
    T[] num;
    Stats(T[] o){
        num = o;
    }
    //Return type double in all cases
    double average(){
        double sum = 0.0;
        for(int i=0;i<num.length;i++)
            sum+=num[i].doubleValue();//will get error here if don't extends Number because you have to ensure that only numeric types are passed
        return sum/num.length;
    }
}
public class BundedGeneric {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        Integer iNum[] = {1,2,3,4,5,6};
        Stats<Integer> obj = new Stats<>(iNum);
        double temp = obj.average();
        System.out.println("Average of Integer Array = "+temp);
        buffer.close();
    }
}
