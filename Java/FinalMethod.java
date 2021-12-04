class Parent{
  final void run(){
    System.out.println("Running");
  }
}
public class FinalMethod extends Parent{
  // void run(){
  //   System.out.println("Running Safely");
  // }//final method can't be overrided.
  public static void main(String[] args){
    var obj = new FinalMethod();
    obj.run();//But finalMethod can be inherited
  }
}
