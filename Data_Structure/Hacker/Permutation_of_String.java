
//program for finding  all the permutaion of the latter
import java.util.Scanner;
class demo
{
    public int product_calculation(int length)
    {
        int result=1;

        for(int i=1;i<=length;i++)
        result*=i;

        return result;
    }
    public static void main(String [] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String : ");
        String str=new String(sc.nextLine());
        demo d=new demo();
        int str_len=str.length();
        char c[]=str.toCharArray();

        int m=d.product_calculation(str_len);
        System.out.println("Product of String length = "+m);

        int a[]=new int[str_len];
        for(int i=0;i<str_len;i++)
        a[i]=c[i];

        int key=0;
        for(int j=1;j<str_len;j++)
        {
            key=a[j];
            int i=j-1;
            while(i>0 && a[i]>key)
            {
                a[i+1]=a[i];
                i-=1;
            }
            a[i+1]=key;
        }

        int temp=0,val_str=0,count=0,temp1=1;

        for(int i=0;i<str_len;i++)
        {
            i=temp;
            if(i>str_len)
            {
                break;
            }
            for(int j=i;j<str_len;j++)
            {
                if(a[i]==a[j])
                count++;
            }
            temp+=count;
            val_str=d.product_calculation(count);
            temp1*=val_str;
            count=0;
        }

        System.out.println("Permutation = "+(m/temp1));
    }
}

