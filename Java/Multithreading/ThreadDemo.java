class MyThead extends Thread{
    public void run(){
      for(var i=0;i < 5;i++){
        System.out.println("Child Thread");
      }
    }
}
public class ThreadDemo{
  public static void main(String[] args) {
    var obj = new MyThead();
    obj.start();
    for(var i=0;i < 5;i++){
      System.out.println("Main Thread");
    }
  }
}
