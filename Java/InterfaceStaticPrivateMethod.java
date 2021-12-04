interface Number{
    public void printnumber();

    //this is static method declare inside the JDK 8
    static void staticMethod(){
        System.out.println("This is static method");
    }

    default public void defaultMethod(){
        printMessage("This is default method");
    }

    private void printMessage(String msg){
        System.out.println(msg);
    }
}
public class InterfaceStaticPrivateMethod implements Number{
    @Override
    public void printnumber(){
        System.out.println("This is the Number : ");
    }

    public static void main(String[] args) {
        InterfaceStaticPrivateMethod obj = new InterfaceStaticPrivateMethod();
        obj.printnumber(); 
        obj.defaultMethod();
        Number.staticMethod();
    }
}
