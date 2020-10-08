//implementation of Height and Age comparison in name age and height string
import java.util.Scanner;
class demo
{
    public void operation(String str)
    {
        String new_str[]=str.split(",");
        int new_length=new_str.length;
        String name1[]=new String[new_length];
        String name2[]=new String[new_length];
        String name3[]=new String[new_length];
        for(int i=0;i<new_length;i++)
        {
            if(i==0)
            {
               name1=new_str[i].split("-");
            }
            if(i==1)
            {
                name2=new_str[i].split("-");
            }
            if(i==2)
            {
               name3=new_str[i].split("-");
            }
        }
        
        String name_ar[]=new String[new_length];
        int age_ar[]=new int[new_length];
        float height_ar[]=new float[new_length];

        for(int i=0;i<new_length;i++)
        {
            if(i==0)
            {
                name_ar[i]=name1[i];
            }
            if(i==1)
            {
                age_ar[i-1]=Integer.parseInt(name1[i]);
            }
            if(i==2)
            {
                height_ar[i-2]=Float.parseFloat(name1[i]);
            }
        }

        for(int i=0;i<new_length;i++)
        {
            if(i==0)
            {
                name_ar[i+1]=name2[i];
            }
            if(i==1)
            {
                age_ar[i]=Integer.parseInt(name2[i]);
            }
            if(i==2)
            {
                height_ar[i-1]=Float.parseFloat(name2[i]);
            }
        }

        for(int i=0;i<new_length;i++)
        {
            if(i==0)
            {
                name_ar[i+2]=name3[i];
            }
            if(i==1)
            {
                age_ar[i+1]=Integer.parseInt(name3[i]);
            }
            if(i==2)
            {
                height_ar[i]=Float.parseFloat(name3[i]);
            }
        }

       int new_age[]=new int[new_length];
       for(int i=0;i<new_length;i++)
       {
           new_age[i]=age_ar[i];
       }

       float new_height[]=new float[new_length];
       for(int i=0;i<new_length;i++)
       {
           new_height[i]=height_ar[i];
       }

       int key=0;
       for(int j=1;j<new_length;j++)
       {
           key=new_age[j];
           int i=j-1;
           while(i>=0 && new_age[i]>key)
           {
               new_age[i+1]=new_age[i];
               i-=1;
           }

           new_age[i+1]=key;
       }

       int loc=0;
       int second_yongest=new_age[1];
       for(int i=0;i<new_length;i++)
       {
           if(second_yongest==age_ar[i])
           {
               loc=i;
           }
        }

        int count=0;
        

        float new_key;
        for(int j=1;j<new_length;j++)
        {
            new_key=new_height[j];
            int i=j-1;
            while(i>=0 && new_height[i]>new_key)
            {
                new_height[i+1]=new_height[i];
                i-=1;
            }
            new_height[i+1]=new_key;
        }
        

        float temp_height=height_ar[loc];


        for(int i=0;i<new_length;i++)
        {
            count++;
            if(temp_height==new_height[i])
            {
                break;
            }
        }
        String str_height="";
        for(int i=1;i<=new_length;i++)
        {
            if(count==i)
            {
                str_height=str_height+"Third";
            }
            else if(count==i)
            {
                str_height=str_height+"Second";
            }
            else if(count==i)
            {
                str_height=str_height+"Tallest";
            }
        }

        String str_name="";
        for(int i=0;i<new_length;i++)
        {
            if(loc==i)
            {
                str_name=str_name+name_ar[i];
            }
        }


        System.out.println(str_name+" is the Second yongest with "+str_height+" height in the class");



    }

    public static void main(String [] args)
    {

        demo d=new demo();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String : ");
        String str=sc.nextLine();
        d.operation(str);
        sc.close();

    }
}