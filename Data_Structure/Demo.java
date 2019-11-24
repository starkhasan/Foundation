import java.util.Scanner;
class demo
{
    public static void main(String [] args)
    {
        Scanner sc=new Scanner(System.in);
        Integer a=new Integer(sc.nextInt());
        Integer b=new Integer(sc.nextInt());
        int z=a;
        System.out.println("Example of the UnBoxing = "+z);

        
        if(a==b){
            System.out.println("This is working");
        }
        else{
            System.out.println("This is not working");
        }

        if(a.equals(b)){
            System.out.println("Second method is working");
        }
        else{
            System.out.println("Second method is not working");
        }
        Integer x=Integer.valueOf(5);
        Integer y=Integer.valueOf(5);
        if(x==y){
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }
        sc.close();
    }
}
