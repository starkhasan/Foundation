import java.util.Scanner;
import java.io.*;
class demo
{
    public static void main(String [] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Length of Array : ");
        int number=sc.nextInt();
        int arr[]=new int[number];
        System.out.println("Enter Element in Array : ");
        for(int i=0;i<number;i++)
        {
            arr[i]=sc.nextInt();
        }


        System.out.println("Array Element : ");
        for(int i=0;i<number;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}