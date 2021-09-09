class Outer{
  class Inner{
    public void show(){
      System.out.println("In a nested class method");
    }
  }
}
class NestedInnerClass{
  public static void main(String [] args){
    var in = new Outer().new Inner();
    in.show();
  }
}
