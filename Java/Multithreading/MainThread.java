public class MainThread extends Thread{
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println("Current thread : "+t.getName());
        t.setName("Traversal");
        System.out.println("After Name Change : "+t.getName());
        System.out.println("Main thread priority : "+t.getPriority());
        //setting priority to main thread
        t.setPriority(MAX_PRIORITY);
        //Getting New Priority 
        System.out.println("Main thread new priority : "+t.getPriority());
        for (int i = 0; i < 5; i++) {
            System.out.println("Main Thread");
        }

        //Main thread create a child thread
        var ct = new ChildThread();

        System.out.println("Child thread priority : "+ct.getPriority());
        ct.setPriority(MIN_PRIORITY);
        System.out.println("Child thread new priority : "+ct.getPriority());
        ct.start();
    }
}
class ChildThread extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Child Thread");
        }
    }
}
