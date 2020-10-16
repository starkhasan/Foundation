package Hacker;
import java.util.*;
class Solution
{
    public static int fibonacci(int n)
    {
        // Complete the function.
      int a[]=new int[n+1];
      int first=1,second=0;
      for(int i=0;i<=n;i++)
      {
        if(i<=1)
          a[i]=i;
        else
        {
          a[i]=first+second;
          second=first;
          first=a[i];   
        }
      }
      return (a[n]);
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}