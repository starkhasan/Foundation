class Parent{
  void show(){
    System.out.println("Yes i belongs to parent");
  }
}
class Child extends Parent{
  void show(){
    //super.show();//if we want to call parent class show method from child method
    System.out.println("Yes i belongs to child");
  }
}
public class MethodOverriding{
  public static void main(String[] args) {
    Parent obj = new Child();
    obj.show();
  }
}
//If we make all the method as static in parent as well as child
//then it only call the method of parent class
//that is considered as the Method Hiding.
