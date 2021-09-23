public class FinalVariable{
  private static final PrintWriter pw = new PrintWriter(System.out,true);

  
  final int speed = 90;
  final int fuel; //blank final variable can only be initialize in Constructor
  static final int acceleration;//blank static final variable can only be initialize in static block

  void speedChange(){
    speed = 100;//error: cannot assign a value to final variable speed
  }

  FinalVariable(){
    fuel = 20;
  }

  static{
    acceleration = 10;
  }

  void showResult(){
    pw.println("Speed = "+speed+"\nFuel = "+fuel+"\nAcceleration = "+acceleration);
  }
  public static void main(String[] args) {
    var obj = new FinalVariable();
    obj.speedChange();
    obj.showResult();
  }
}
