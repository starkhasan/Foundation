
//implementation of Greedy Algorithm Knapsack
import java.util.Scanner;
class demo
{
    static Scanner sc=new Scanner(System.in);
    static int n=0,max_cap=0;
    public int ar_location(float new_ppu[],float index) 
    {

        int new_size=new_ppu.length;
        int loc=0;
        for(int i=0;i<new_size;i++)
        {
            if(index==new_ppu[i])
            {
                loc=i;
                new_ppu[i]=0.0f;
                break;
                
            }
        }

        return loc;

    }
    public static void main(String [] args)
    {
        demo d=new demo();
        System.out.println("Number of Items  ");
        n=sc.nextInt();
        System.out.println("Knapsack Capacity  ");
        max_cap=sc.nextInt();
        System.out.println("Profit of Each Item  ");
        int pr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            pr[i]=sc.nextInt();
        }
        System.out.println("Weight of Each Item  ");
        int wt[]=new int[n];
        for(int i=0;i<n;i++)
        {
            wt[i]=sc.nextInt();
        }
        float ppu[]=new float[n];
        for(int i=0;i<n;i++)
        {
            ppu[i]=(float)pr[i]/(float)wt[i];
        }

        float new_ppu[]=new float[n];
        for(int i=0;i<n;i++)
        {
            new_ppu[i]=ppu[i];
        }
        System.out.println("Profit Per Weight ");
        for(int i=0;i<n;i++)
        {
            System.out.printf("%.2f ",new_ppu[i]);
        }

        float temp=0.0f,sum=0.0f,new_weight=0.0f,check=0.0f;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n-1;j++)
            {
                if(ppu[j]<ppu[j+1])
                {
                    temp=ppu[j];
                    ppu[j]=ppu[j+1];
                    ppu[j+1]=temp;
                }
            }
        }
        
        System.out.println();
        System.out.println("Profit Per Weight ");
        for(int i=0;i<n;i++)
        {

            System.out.printf("%.2f ",ppu[i]);
        }
        System.out.println();
        for(int i=0;i<n;i++)
        {
            if(new_weight<max_cap)
            {
                float index=ppu[i];
                int new_index=d.ar_location(new_ppu,index);
                //System.out.print(" "+new_index+" ");
                float weight=wt[new_index];
                new_weight+=weight;
                if(new_weight<=max_cap)
                {
                    sum+=pr[new_index];
                    check=new_weight;
                }
               else
                {
                    weight=max_cap-check;
                    new_weight=check+weight;
                    weight=(pr[new_index]*weight)/wt[new_index];
                    sum+=weight;
                }
                //System.out.print(new_weight+"  ,");
            }
            
        }
        System.out.println();
        System.out.printf("Maximum Profit = %.2f",sum);
    }
}