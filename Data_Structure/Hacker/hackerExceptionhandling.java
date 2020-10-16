package Hacker;
import java.io.*;
import java.util.*;
class MyCalculator 
{
    /*
    * Create the method long power(int, int) here.
    
    */
      public int power(int  x,int y)throws Exception
      {
        int new_result=0;
        if(x<0||y<0)
        {
          throw new Exception("n or p should not be negative.");
        }
        else if(x==0 && y==0)
        {
          throw new Exception("n and p should not be zero.");
        }
        else
        {
          double new_x=(double)x;
          double new_y=(double)y;
          double result=Math.pow(new_x,new_y);
          new_result=(int)result;
          return new_result;
        }
      }
}
class Solution {
    public static final MyCalculator my_calculator = new MyCalculator();
    public static final Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        while (in .hasNextInt()) {
            int n = in .nextInt();
            int p = in .nextInt();
            
            try {
                System.out.println(my_calculator.power(n, p));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}