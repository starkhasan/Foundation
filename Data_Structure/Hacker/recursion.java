package Hacker;
import java.util.Scanner;
class demo{
	long Fact(long n){
		long result=0;
		if(n==1)
			return 1;
		result=Fact(n-1)*n;
		return result;
	}	
}
class Recursion extends demo
{
	public static void main(String [] args)
	{
		Recursion d = new Recursion();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number: ");
		long a = sc.nextLong();
		long x=d.Fact(a);
		System.out.println(x);
		sc.close();
	}
}
