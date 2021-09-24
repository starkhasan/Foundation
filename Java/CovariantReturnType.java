class A{}
class B extends A{}
class Base{
    A fun(){
        System.out.println("Base fun");
        return new A();
    }
}
class Derived extends Base{
    B fun(){
        System.out.println("Derived fun");
        return new B();
    }
}

public class CovariantReturnType {
    public static void main(String[] args) {
        Base obj = new Derived();
        obj.fun();
    }
}
