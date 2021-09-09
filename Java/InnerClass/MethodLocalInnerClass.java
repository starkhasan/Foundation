class Outer{
  void outerMethod(){
    System.out.println("Inside outermethod");
    class Inner{
      void innerMethod(){
        System.out.println("Inside innerMethod");
      }
    }
    var obj = new Inner();
    obj.innerMethod();
  }
}
public class MethodLocalInnerClass{
  public static void main(String[] args) {
    var obj = new Outer();
    obj.outerMethod();
  }
}
