class MyThread extends Thread{}
public class NoRunMethod{
  public static void main(String[] args) {
    var obj = new MyThread();
    obj.start();
  }
}
