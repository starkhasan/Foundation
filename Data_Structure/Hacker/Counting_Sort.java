
//implementing the counting sort
import java.util.Scanner;
class demo
{

    public int[] count_element(int temp[],int C[])
    {

        int new_length=temp.length;
        int new_length1=C.length;

        int key=0;
        for(int j=1;j<new_length;j++)
        {
            key=temp[j];
            int i=j-1;
            while(i>=0 && temp[i]>key)
            {
                temp[i+1]=temp[i];
                i-=1;
            }
            temp[i+1]=key;
        }

        int count=0;

        for(int i=0;i<new_length;i++)
        {
            System.out.print(temp[i]+" ");
        }

        int temp1=0,k=0;

        for(int i=0;i<new_length;i++)
        {
            i=temp1;
            
            for(int j=i;j<new_length;j++)
            {
                if(temp[i]==temp[j])
                {
                    count++;
                }
            }

            for(int x=0;x<new_length1;x++)
            {
                if(x==temp[i])
                {
                    C[x]=count;
                }
            }
    
            temp1+=count;
            count=0;
        }

        return C;
    }

    public void counting_sort(int ar[])
    {

        int new_length=ar.length;
        int B[]=new int[new_length+1];

        int max=0;
        for(int i=1;i<=new_length;i++)
        {
            max=ar[i];
            for(int j=1;j<=new_length;j++)
            {
                if(ar[j]>max)
                {
                    max=ar[j];
                }
            }
        }

        int ar_temp[]=new int[new_length];
        for(int i=1;i<=new_length;i++)
        {
            ar_temp[i]=ar[i];
        }

        //Implement a new Array
        int new_ar[]=new int[max+1];

        new_ar=count_element(ar_temp,new_ar);
        System.out.println();

        for(int i=0;i<max+1;i++)
        {
            System.out.print(new_ar[i]+" ");
        }
        System.out.println();
        int new_ar1[]=new int[max+1];

        int temp1=0;
        for(int i=0;i<max+1;i++)
        {
            if(i==0)
            {
                new_ar1[i]=new_ar[i];
                temp1=new_ar1[i];
            }
            else
            {
                temp1+=new_ar[i];
                new_ar1[i]=temp1;
            }


            System.out.print(new_ar1[i]+" ");
        }

        System.out.println("\n Before Sorting Array : ");
        for(int i=0;i<new_length;i++)
        {
            System.out.print(ar[i]+" ");
        }

        for(int i=new_length;i>=1;i--)
        {
            B[new_ar1[ar[i]]]=ar[i];
            new_ar1[ar[i]]=new_ar1[ar[i]]-1;
        }


        System.out.println("\nAfter Sorting Array : ");
        for(int i=1;i<=new_length;i++)
        {
            System.out.print(ar[i]+" ");
        }

    }

    public static void main(String [] args)
    {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Size : ");
        int ar_size=sc.nextInt();

        int ar[]=new int[ar_size+1];
        System.out.println("Enter Element : ");
        for(int i=1;i<=ar_size;i++)
        {
            ar[i]=sc.nextInt();
        }

        demo d=new demo();
        d.counting_sort(ar);

    }
}
*/