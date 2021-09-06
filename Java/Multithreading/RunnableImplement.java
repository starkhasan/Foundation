class MyRunnable implements Runnable{
  @Override
  public void run(){
    System.out.println("Runnable ChildThread");
  }
}
public class RunnableImplement{
  public static void main(String[] args) {
    var myRunnable = new MyRunnable();
    var threadObj = new Thread(myRunnable);
    threadObj.start();
    System.out.println("Main Thread");
  }
}
