import java.util.Scanner;
public class MainClass implements Calulation{

    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter First Number");
        int first_number = sc.nextInt();
        System.out.println("Enter Second Number");
        int second_number = sc.nextInt();
        int result = mainClass.summation(first_number, second_number);
        System.out.println("Summation = "+result);
        sc.close();
    }

    @Override
    public int summation(int a, int b) {
        return a+b;
    }
}