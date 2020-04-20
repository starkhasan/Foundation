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
        System.out.print("\nEnter Total Days (29-31): ");
        int total_day=sc.nextInt();
        try{
            if(first_day==0 || first_day>7){
                throw new NumberFormatException("Please Enter Valid First Day");
            }else if(total_day<29 || total_day>31){
                throw new NumberFormatException("Please Enter Valid Total Days in a Month");
            }else{
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
        }catch(NumberFormatException ae){
            System.out.println(ae.getMessage());
        }
        sc.close();
    }
}

