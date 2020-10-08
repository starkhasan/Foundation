Given two strings of equal length, you have to tell whether they both strings are identical.
Two strings S1 and S2 are said to be identical, if any of the permutation of string S1 is equal to the string S2. See Sample explanation for more details.

Input :

First line, contains an intger 'T' denoting no. of test cases.
Each test consists of a single line, containing two space separated strings S1 and S2 of equal length.
Output:

For each test case, if any of the permutation of string S1 is equal to the string S2 print YES else print NO.
Constraints:

1<= T <=100
1<= |S1| = |S2| <= 10^5
String is made up of lower case letters only.
Note : Use Hashing Concept Only . Try to do it in O(string length) .

Sample Case:
Input																						Output
3	       					
sumit mitsu				                                                           yes
ambuj jumba							 yes
abhi hibb                                                                                                                                           no


import java.util.Scanner;
class demo
{
	public static void main(String [] args)
	{
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();

 	    s.nextLine();
 	    
 		for(int i=0;i<n;i++)
 		{
 		    
 			String s1 = s.nextLine();
 			String str[]=s1.split(" ");
 			int str_len=str.length;

 			String name_first=str[0];
 			String name_second=str[1];


 			int a[] = new int[name_first.length()];
 			int b[] = new int[name_first.length()];

 			for(int j=0;j<name_first.length();j++)
 			{
 				a[j] = name_first.charAt(j);
 			}

 			for(int j=0;j<name_first.length();j++)
 			{
 				b[j] = name_second.charAt(j);
 			}
 			
 			int key=0;
 			
 			for(int j=1;j<name_first.length();j++)
 			{
 				key = a[j];
 				int k = j-1;
 				while(k>=0 && a[k]>key)
 				{
 					a[k+1] = a[k];
 					k-=1;
 				}
 				a[k+1] = key;
 			}

 			key = 0;

 			for(int j=1;j<name_first.length();j++)
 			{
 				key=b[j];
 				int k=j-1;
 				while(k>=0 && b[k]>key)
 				{
 					b[k+1]=b[k];
 					k-=1;
 				}
 				b[k+1]=key;
 			}

 			char c[] = new char[name_first.length()];
 			char c1[] = new char[name_first.length()];
 			
 			for(int j=0;j<name_first.length();j++)
 			{
 				c[j]=(char)a[j];
 			}

 			for(int j=0;j<name_first.length();j++)
 			{
 				c1[j]=(char)b[j];
 			}

 			String s3=new String(c);
 			String s4=new String(c1);
 			if(s3.equals(s4))
 				System.out.println("YES");
 			else
 				System.out.println("NO");

 		}
	}
}