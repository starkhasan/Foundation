/*import java.util.Scanner;
class demo
{
	public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Number: ");
		try
		{
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=a/b;
			System.out.println("OK");
		}
		catch(ArithmeticException e)
		{
			System.out.println("CAN'T BE  DIVIDED");
			//System.out.println(e);
		}
	}
}
*/
import java.util.Scanner;
class demo
{
	public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		try
		{
		int n=Integer.parseInt(s);
		System.out.println(n);
		}
		catch(Exception e)
		{
			System.out.println("Bad String");
		}
	}
}






















