package Hacker;
/*import java.util.*;
class demo
{
	public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter String: ");
		String str=sc.nextLine();
		int n=str.length();
		char c[]=str.toCharArray();
		String e="";
		String o="";
		for(int i=0;i<n;i++)
		{
			if(i%2==0)
				e+=c[i];
			else
				o+=c[i];
		}
		System.out.println(e+" "+o);
	}
}
		*/
		
		import java.util.*;
		class demo
		{
			public static void main(String [] args)
			{
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter Number:");
				int n=sc.nextInt();
				System.out.println("Enter two String: ");
				sc.nextLine();
				String str[]=new String[n];
				for(int i=0;i<n;i++)
				{
					str[i]=sc.nextLine();
				}
				StringBuffer one[]=new StringBuffer[n];
				for(int i=0;i<n;i++)
				{
						one[i].append(str[i]);
				}
				int x[]=new int[n];
				for(int i=0;i<n;i++)
				{
					x[i]=one[i].length();
				}
				for(int i=0;i<n;i++)
				{
					System.out.println(x[i]);
				}
				sc.close();
			}
		}
		
				