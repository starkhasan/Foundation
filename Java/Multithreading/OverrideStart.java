class MyThread extends Thread{
  public void start(){
    System.out.println("Executing Start Method");
  }
  public void run(){
    System.out.println("Executing Run Method");
  }
}
public class OverrideStart{
  public static void main(String[] args) {
    var obj = new MyThread();
    obj.start();
  }
}
//If we override start method than then the run method will not execute.
//only start method will execute.
