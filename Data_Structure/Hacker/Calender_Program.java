//calender program
import java.util.Scanner;
class demo
{
    public static void main(String [] args)
    {
        System.out.println("Author : Ali Hasan\n");
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter First Day (1-7): ");
        int first_day=sc.nextInt();
        System.out.print("\nEnter Total Day (MAX 31): ");
        int total_day=sc.nextInt();
        int count=1;
        System.out.println("\nSUN  \tMON  \tTUE  \tWED  \tTHU  \tFRI  \tSAT");
        for(int i=0;i<6;i++)
        {
            for(int j=0;j<7;j++)
            {
                if(count>total_day)
                break;
                if(i==0)
                {
                    if(j<first_day-1)
                    System.out.print("  \t");
                    else
                    {
                        System.out.printf("%2d\t",count);
                        count++;
                    }
                }
                if(i>0)
                {
                    if(j<7)
                    {
                        System.out.printf("%2d\t",count);
                        count++;
                    }
                    else
                    System.out.print("   ");
                }
                
            }
            System.out.println();
        }
    }
}

