
import java.util.Scanner;
class demo
{

    public void number_indexing(int number)
    {
        int index[]=new int[10];
        for(int i=0;i<10;i++)
        {
            index[i]=0;
        }

        int temp=number;
        while(temp>0)
        {
            int x=temp%10;

            for(int i=0;i<10;i++)
            {
                if(x==i)
                {
                    index[i]+=1;
                }
            }

            temp=temp/10;
        }


        System.out.println("\nNumber Index : ");
        for(int i=0;i<10;i++)
        {
            System.out.print(index[i]+" ");
        }

    }

    public static void main(String [] args)
    {

        demo d=new demo();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Number : ");
        int number=sc.nextInt();
        d.number_indexing(number);
        sc.close();

    }

}


/*
OutPut: -------------------
Enter Number :
13245

Number Index :
0 1 1 1 1 1 0 0 0 0
*/