abstract class TestAbstractClass{
    static void testStaticMethod(){
        System.out.println("Static method of TestAbstractClass");
    }
}
public class AbstractStaticMethod extends TestAbstractClass{

    public void MainClassMethod(){
        System.out.println("This is the main class method");
    }
    public static void main(String[] args) {
        TestAbstractClass obj = new AbstractStaticMethod();
        TestAbstractClass.testStaticMethod();
        /**
         * you can declare variable as object references that use an interface rather than a class type.
         * any instance of any class that implements the declared interface can be refered to by such
         * a variable
         * 
         * when you call method through one of these references the correct version will be called based on the actual instances 
         * of the interface being referred to. This is one of the key feature of the interfaces.
         */

        var obj1 = new AbstractStaticMethod();
        obj1.MainClassMethod();
        testStaticMethod();//static import of abstract class static method
    }
}