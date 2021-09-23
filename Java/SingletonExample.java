import java.io.*;
class ExampleName{
    private static ExampleName exampleName_instance = null;
    public String name;
    private ExampleName(){
        name = "Hello , I am part of the ExampleName Class";
    }

    public static ExampleName getInstance(){
        if(exampleName_instance == null)
            exampleName_instance = new ExampleName();
        return exampleName_instance;
    }
}
public class SingletonExample {
    private static final PrintWriter pw = new PrintWriter(System.out,true);
    public static void main(String[] args) {
        var obj1 = ExampleName.getInstance();
        var obj2 = ExampleName.getInstance();
        var obj3 = ExampleName.getInstance();

        pw.println("Hashcode of obj1 is "+obj1.hashCode());
        pw.println("Hashcode of obj2 is "+obj2.hashCode());
        pw.println("Hashcode of obj3 is "+obj3.hashCode());

        if((obj1 == obj2) && (obj2 == obj3))
            pw.println("Three object point to the same memory location");
        else
            pw.println("Three object do not point to same memory location");
   }
}
