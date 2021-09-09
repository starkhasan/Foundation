class MyException extends Exception{
  MyException(String str){
    super(str);
  }
}
public class CustomException{
  public static void main(String[] args) {
    try{
      throw new MyException("Ali hasan");
    }catch(MyException e){
      System.out.println(e.getMessage());
    }
  }
}
