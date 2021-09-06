class CreateThread extends Thread{
  public void run(){
    try{
      System.out.println("Thread "+Thread.currentThread().getId()+" is running");
    }catch(Exception e){
      System.out.println("Exception caught");
    }
  }
}
public class ThreadCreation{
  public static void main(String[] args) {
    for(var i = 0; i < 10; i++){
      var obj = new CreateThread();
      obj.start();
    }
  }
}
