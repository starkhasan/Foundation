//java program for Array rotation of the array
import java.util.Scanner;
class demo
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

        System.out.println("\nArray without Rotation : ");
        for(int i=0;i<size;i++){
            System.out.print(a[i]+" ");
        }

        System.out.println("\nEnter Number of Rotation : ");
        int rotation=sc.nextInt();
        int key=0;

        for(int i=0;i<rotation;i++)
        {
            key=a[size-1];
            for(int j=size-2;j>=0;j--)
            {
                a[j+1]=a[j];
            }
            a[0]=key;
        }

        System.out.println("\nArray After Right Rotation : ");
        for(int i=0;i<size;i++)
        System.out.print(a[i]+" ");

        sc.close();

    }
}