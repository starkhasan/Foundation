import java.util.Scanner;
interface MyNumber{
    boolean oddeven(int a);
}
class demo{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        MyNumber myNumber;
        myNumber = (a) -> {
            boolean flag = a%2==0 ? true : false;
            return flag;
        };

        System.out.println("Enter Any Number ");
        if(myNumber.oddeven(sc.nextInt())){
            System.out.println("Even");
        }else{
            System.out.println("Odd");
        }
        sc.close();
    }
}