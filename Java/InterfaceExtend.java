import java.io.PrintWriter;
interface A{
    void meth1();
    void meth2();
}
interface B extends A{
    void meth3();
}
class MyClass implements B{
    private static final PrintWriter pw = new PrintWriter(System.out,true);
    @Override
    public void meth1(){
        pw.println("Imlement method 1");
    }

    @Override
    public void meth2(){
        pw.println("Imlement method 2");
    }

    @Override
    public void meth3(){
        pw.println("Imlement method 3");
    }
}
public class InterfaceExtend{
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.meth1();
        obj.meth2();
        obj.meth3();
    }
}
