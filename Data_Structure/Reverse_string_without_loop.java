import java.util.Scanner;
public class Reverse_string_without_loop {
    static String reverseString(String temp){
        StringBuffer str = new StringBuffer(temp);
        return str.reverse().toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String");
        String name = sc.nextLine();
        System.out.println(reverseString(name));
        sc.close();
    }   
}
