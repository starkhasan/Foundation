/*
Sorting 
One common task for computers is to sort data. For example, people might want to see all their files on a computer sorted by size. 
Since sorting is a simple problem with many different possible solutions, it is often used to introduce the study of algorithms.

Insertion Sort 
These challenges will cover Insertion Sort, a simple and intuitive sorting algorithm. We will first start with a nearly sorted list.

Sample Input
5
2 4 6 8 3
Sample Output
2 4 6 8 8 
2 4 6 6 8 
2 4 4 6 8 
2 3 4 6 8 

*/
package Hacker;
import java.util.Scanner;
class Advance_Insertion_Sort1
{
	public void insertion(int arr[])
	{
		int ar_size=arr.length;
		int key=0,i=0;
		for(int j=1;j<ar_size;j++)
		{
			key=arr[j];
			i=j-1;
			while(i>=0 && key<arr[i])
			{
				arr[i+1]=arr[i];
				i-=1;
				for(int k=0;k<ar_size;k++)
				{
					System.out.print(arr[k]+" ");
				}
				System.out.println();
			}
			arr[i+1]=key;
		}

		for(int k=0;k<ar_size;k++)
		{
			System.out.print(arr[k]+" ");
		}
	}
	public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Size : ");
		int ar_size=sc.nextInt();
		System.out.println("Enter Element in Array :");
		int a[]=new int[ar_size];
		for(int i=0;i<ar_size;i++)
		{
			a[i]=sc.nextInt();
		}
		Advance_Insertion_Sort1 d=new Advance_Insertion_Sort1();
		d.insertion(a);
		sc.close();
	}
}