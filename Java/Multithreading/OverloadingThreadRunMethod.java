class MyThread extends Thread{
  public void run(){
    for(var i=0;i<5;i++){
      System.out.println("Child Thread");
    }
  }
  public void run(String name){//Overloading the Run Method, to call this method we have to call it exlicitly from main method
    for(var i=0; i<5; i++){
      System.out.println(name+" Child Thread Start");
    }
  }
}
public class OverloadingThreadRunMethod{
  public static void main(String[] args) {
    var obj = new MyThread();
    obj.start();
    for(var i=0;i<5;i++){
      System.out.println("Main Thread");
    }
  }
}
//Instead of Overloading the run method the start() always call the no-args run method
