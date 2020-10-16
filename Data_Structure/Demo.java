abstract class Main{
    public abstract void print();
}
public class Demo extends Main{
    @Override
    public void print(){
        System.out.println("This is abstraction Example : ");
    }
    public static void main(String[] args) {
        Demo d = new Demo();
        d.print();
    }
}