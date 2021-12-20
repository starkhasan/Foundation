public class Demo{
  public static void main(String[] args) {
    int a = 10;
    int b = a++ + ++a;
    System.out.println(a+" "+b);
  }
}