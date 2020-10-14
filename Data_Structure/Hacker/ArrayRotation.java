//java program for Array rotation of the array
package Hacker;
import java.util.Scanner;
/*class ArrayRotation
{
    public static void main(String [] args)
    {
        System.out.println("Array Right Rotation : ");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size : ");
        int size=sc.nextInt();
        
        int a[]=new int[size];
        System.out.println("Enter Element in Array : ");
        for(int i=0;i<size;i++)
        a[i]=sc.nextInt();

        System.out.println("Enter Number of Rotation : ");
        int rotation=sc.nextInt();
        int key=0,temp=0;

        for(int i=0;i<rotation;i++)
        {
            key=a[size-1];
            for(int j=size-2;j>=0;j--)
            {
                a[j+1]=a[j];
            }
            a[0]=key;
        }

        for(int i=0;i<size;i++)
        System.out.print(a[i]+" ");

    }
}
*/


public class ArrayRotation
{
    public static void main(String [] args)
    {
        System.out.println("Array Left Rotation : ");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size : ");
        int size=sc.nextInt();
        
        int a[]=new int[size];
        System.out.println("Enter Element in Array : ");
        for(int i=0;i<size;i++)
        a[i]=sc.nextInt();


        System.out.println("Enter Number of Rotation : ");
        int rotation=sc.nextInt();
        int key=0;

        for(int i=0;i<rotation;i++)
        {
            key=a[0];
            for(int j=0;j<size-1;j++)
            {
                a[j]=a[j+1];
            }
            a[size-1]=key;
        }

        for(int i=0;i<size;i++)
        System.out.print(a[i]+" ");
        sc.close();
    }
}