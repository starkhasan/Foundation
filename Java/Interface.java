interface Vehicle{
  void start();
  void color(String carColor);
  //we can also have the default method in interface After JDK 8
  default void msg(){
    System.out.println("This is default method");
  }
  //we can have static method also After JDK 8
  static int cude(int x){
    return (int)Math.pow(x,3);
  }
}

class Car implements Vehicle{

  @Override
  public void start(){
    System.out.println("Car Started");
  }

  @Override
  public void color(String carColor){
    System.out.println(carColor+" is the color of Car");
  }

  void carMethod(){
    System.out.println("This is the car method");
  }
}
public class Interface{
  public static void main(String[] args) {
    Vehicle obj = new Car();
    obj.start();
    obj.color("Black");
    obj.msg();
    /**
     * we can declare variables as object reference that use an interface rather than class type.
     * Any instance of any class that implemens the declared interfacean referred to by such a variable
     * when you call a method through one of these reference the correct version will be called based on 
     * the actual instance of the interface being referred to,
     * 
     */
    obj.carMethod();//here we cannot call method of Car class because the object of Car is refered by interface ()
    var result = Vehicle.cude(4);
    System.out.println("Volumn of Cude = "+result);
  }
}
