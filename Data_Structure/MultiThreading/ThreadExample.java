package MultiThreading;
class Demo extends Thread{
    public void run(){
        for(int i=0;i<5;i++)
            System.out.println("Child Thread");
    }
}
public class ThreadExample {
    public static void main(String[] args) {
        Demo d = new Demo();
        d.start();
        for(int i=0;i<5;i++)
            System.out.println("Main Thread");
    }
}
