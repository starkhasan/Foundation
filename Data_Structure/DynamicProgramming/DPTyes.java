import java.util.*;
import java.io.*;
/*
//Top Down Approach
import java.util.*;
import java.io.*;
class Demo{
    static int calculateFib(int number){
        int[] memo = new int[number+1];
        return Fib(memo,number);
    }
    static int Fib(int[] memo,int n){
        if(n<2)
            return n;
        if(memo[n]!=0)
            return memo[n];
        memo[n] = Fib(memo, n-1) + Fib(memo, n-2);
        return memo[n];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(buffer.readLine());
        System.out.println(calculateFib(number));        
    }
}
*/


//Bottom Up Approach
import java.util.*;
import java.io.*;
class Demo{
    static int calculateFib(int number){
        if(number==0)
            return 0;
        int[] dp = new int[number+1];

        dp[0] = 0;
        dp[1] = 1;

        for(int i=2;i<number;i++)
            dp[i] = dp[i-1]  +dp[i-2];

        return dp[number-1]; 
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(buffer.readLine());
        System.out.println("Fibonacci Number = "+calculateFib(number));
    }
}