package Hacker;
import java.util.*;
class Demo
{
	public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
		try
		{
			int n=sc.nextInt();
			String s=Integer.toString(n);
			if(n==Integer.parseInt(s))
				System.out.println("Good Job");
			else
				System.out.println("Wrong Answer");
			sc.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
			