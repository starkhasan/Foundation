
/*
//default method in interface addded in JDK 8
interface First{
    public static final int number = 10;
    default void printMessage(){
        System.out.println("This is deafult inside the interface");
    }
}
public class InterfaceDemo1 implements First{
    public static void main(String[] args) {
        InterfaceDemo1 obj = new InterfaceDemo1();
        obj.printMessage();
        System.out.println(obj.number);
    }
}
*/

/*
//static method in interface addded in JDK 9
interface First{
    public static final int number = 10;
    static void printMessage(){
        System.out.println("This is deafult inside the interface");
    }
}
public class InterfaceDemo1 implements First{
    public static void main(String[] args) {
        InterfaceDemo1 obj = new InterfaceDemo1();
        First.printMessage();
        System.out.println(obj.number);
    }
}
*/


/*
JDK 9 introduced private method and private static method in interface. In java 9 and later version an interface can have  different
things:

1. Constant veriables
2. Abstract methods
3. Default methods
4. Static methods
5. Private methods
6. Private Static methods

These private method will improve code re-usability inside interface and will provide choice to expose only our intended method 
implementations to users. These methods are only accessible within that interface only and cannot accessed or inherited from
an interface to another interface or class

Rules For using Private Methods in interfaces
1) Private interface method cannot be abstract and no private and abstract modifier together
2) Private method can be used only inside interface and other static and non-static interface methods
3) Private non-static methods cannot be used inside private static method

*/
// Java 9 program to illustrate 
// private methods in interfaces 
interface TempI { 

	public abstract void mul(int a, int b); 

    public default void add(int a, int b) { 
        // private method inside default method 
		sub(a, b); 
        // static method inside other non-static method 
		div(a, b); 
		System.out.print("Answer by Default method = "); 
		System.out.println(a + b); 
	}

	public static void mod(int a, int b) {
		div(a, b); // static method inside other static method 
		System.out.print("Answer by Static method = "); 
		System.out.println(a % b); 
	} 

	private void sub(int a, int b) {
		System.out.print("Answer by Private method = "); 
		System.out.println(a - b); 
	} 

	private static void div(int a, int b) {
		System.out.print("Answer by Private static method = "); 
		System.out.println(a / b); 
	} 
} 

class InterfaceDemo1 implements TempI { 

	@Override
	public void mul(int a, int b) {
		System.out.print("Answer by Abstract method = "); 
		System.out.println(a * b); 
	} 

	public static void main(String[] args) { 
		TempI in = new InterfaceDemo1(); 
		in.mul(2, 3); 
		in.add(6, 2); 
		TempI.mod(5, 3); 
	} 
} 


















