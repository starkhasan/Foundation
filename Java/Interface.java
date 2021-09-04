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
}
public class Interface{
  public static void main(String[] args) {
    var obj = new Car();
    obj.start();
    obj.color("Black");
    obj.msg();
    var result = Vehicle.cude(4);
    System.out.println("Volumn of Cude = "+result);
  }
}
