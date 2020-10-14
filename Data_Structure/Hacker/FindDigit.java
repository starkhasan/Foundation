package Hacker;
import java.io.*;
import java.util.*;
public class FindDigit {
    static void findNumber(List<Integer> list,int n){
        int number = n;
        while(number>0){
            int temp = number%10;
            list.add(temp);
            number = number/10;
        }
    }
    static int findDigits(int n) {
        List<Integer> listNumber = new ArrayList<>();
        findNumber(listNumber,n);
        int counter = 0;
        for(int i=0;i<listNumber.size();i++){
            if(listNumber.get(i)!=0 && n%listNumber.get(i)==0){
                counter++;
            }
        }
        return counter;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputDemo.txt"));
        int n = 0;
        while((buffer.readLine())!=null){
            n = Integer.parseInt(buffer.readLine());
        }
        System.out.println("Result = "+findDigits(n));
        buffer.close();
    }    
}
