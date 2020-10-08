//Program for conversion 12hr time to 24
 import java.util.Scanner;
 class demo
 {

 	public static void main(String [] args)
 	{
 		Scanner sc=new Scanner(System.in);
		System.out.println("Author :  Ali Hasan\n");
 		System.out.println("Enter Time : ");
 		String str=new String(sc.nextLine());

 		//System.out.println(str.substring(8,10));
 		String new_str=str.substring(8,10);
 		//System.out.println(new_str);

 		String new_str1=new String(str.substring(0,8));
 		//System.out.println(new_str1);

 		String new_str3=str.substring(2,8);

 		int str_len=new_str1.length();

 		char c[]=new_str1.toCharArray();

 		int a[]=new int[2];

 		for(int i=0;i<2;i++)
 		{
 			a[i]=Integer.parseInt(String.valueOf(c[i]));
 		}

 		if(new_str.equals("PM"))
 		{

 			a[0]+=1;
 			a[1]+=2;

 			String new_str2=new String();
 			for(int i=0;i<2;i++)
 			{
 				new_str2+=String.valueOf(a[i]);
 			}

 			//System.out.println(new_str2+new_str3);

 			new_str2=new_str2+new_str3;


 			System.out.println(new_str2);

 		}
 		else
 		{
 			new_str1=new_str1;
 			System.out.println(new_str1);
 		}

 	}
 
 }
