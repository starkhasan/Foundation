/*

//Conversion of Lower case String in Upper Case String without ToUpperCase method
import java.util.Scanner;
class demo
{
    public static void main(String [] args)
    {
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter String in Lower Case : ");
        String str_lower=sc.nextLine();

        char chr_lower[]=str_lower.toCharArray();
        int lower_string[]=new int[str_lower.length()];

        for(int i=0;i<str_lower.length();i++)
        {
            lower_string[i]=chr_lower[i];
        }


        for(int i=0;i<str_lower.length();i++)
        {
            if(lower_string[i]==32)
                continue;
            else
            {
                lower_string[i]=lower_string[i]-32;
            }
        }

        for(int i=0;i<str_lower.length();i++)
        {
            chr_lower[i]=(char)lower_string[i];
        }


        String new_string=new String(chr_lower);
        System.out.println("String in Upper Case : "+new_string);

    }
}
*/

/*
//Conversion of Upper Case String in Lower Case String without toLowerCase() method
import java.util.Scanner;
class demo
{
    public static void main(String [] args)
    {
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter String in Upper Case : ");
        String str_lower=sc.nextLine();

        char chr_lower[]=str_lower.toCharArray();
        int lower_string[]=new int[str_lower.length()];

        for(int i=0;i<str_lower.length();i++)
        {
            lower_string[i]=chr_lower[i];
        }


        for(int i=0;i<str_lower.length();i++)
        {
            if(lower_string[i]==32)
                continue;
            else
            {
                lower_string[i]=lower_string[i]+32;
            }
        }


        for(int i=0;i<str_lower.length();i++)
        {
            chr_lower[i]=(char)lower_string[i];
        }


        String new_string=new String(chr_lower);
        System.out.println("\nString in Lower Case : "+new_string);

    }
}
*/


