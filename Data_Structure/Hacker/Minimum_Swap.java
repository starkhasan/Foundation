package Hacker;
import java.util.Scanner;
class Minimum_Swap
{
	public void sorting(int arr[])
	{
		int new_length=arr.length;
		int key=0,loc=0,count=0;
		for(int i=0;i<new_length;i++)
		{
			key=arr[i];
			loc=i;
			for(int j=i;j<new_length;j++)
			{
				if(key>arr[j])
				{
					key=arr[j];
					loc=j;
					System.out.print(key+" ");
				}
			}
			if(arr[i]>key)
			{
				arr[loc]=arr[i];
				arr[i]=key;
				count++;
			}
		}
		System.out.println("\n"+count);
	}
	public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Size : ");
		int ar_size=sc.nextInt();
		int a[]=new int[ar_size];
		System.out.println("Enter Element in Array : ");
		for(int i=0;i<ar_size;i++)
		{
			a[i]=sc.nextInt();
		}

		Minimum_Swap d = new Minimum_Swap();
		d.sorting(a);
		sc.close();
	}
}