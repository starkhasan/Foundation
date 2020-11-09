import java.util.*;
import java.io.*;
public class RecursionExample {
    //Without Recursion
    static void fib(int num){
        if(num == 0)
            System.out.println(0+" ");
        else{
            int total = 0,first = 1,second = 0;
            for(int i=0;i<num;i++){
                if( i<=1 )
                    System.out.print(i+" ");
                else{
                    total = first + second;
                    System.out.print(total+" ");
                    second = first;
                    first = total;
                }
            }
        }
    }
    //With Recursion
    static int total = 0,first = 1,second = 0,count=1;
    static void fibonacci(int num){
        if(num>0){
            if(count<=1){
                System.out.print(1+" ");
                count++;
            }else{
                total = first + second;
                System.out.print(total+" ");
                second = first;
                first = total;
            }
            fibonacci(num-1);
        }
    }

    //Sum of Digit using Recursion
    static int sumDigit(int num){
        if(num>0){
            int temp = num%10;
            return temp+sumDigit(num/10);
        }else{
            return 0;
        }
    }

    //Multiplication of two number without using loop and multiplication operator use Recursion
    static int productNumber(int x,int y){
        if(x>0){
            return  y + productNumber(x-1, y);
        }else{
            return 0;
        }
    }


    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Any Number : ");
        int base_number = Integer.parseInt(buffer.readLine());
        fibonacci(base_number);
    }
}
