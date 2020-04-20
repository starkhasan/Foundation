import java.util.Scanner;
interface MyNumber{
    int summation(int a);
}
class demo{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyNumber myNumber;
        myNumber = (n) -> {
            System.out.println("\nEnter the Element in Array : ");
            int sum=0;
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            for(int i=0;i<n;i++){
                sum+=a[i];
            }
            return sum;
        };
        System.out.println("Enter Size of the Array ");
        int ar_size=sc.nextInt();
        System.out.println("Summation of Array = "+myNumber.summation(ar_size));
        sc.close();
    }
}
