public class InstanceInitializerBlock{
  {
    System.out.println("This is Instance Initializer Block ");
  }

  InstanceInitializerBlock(){
    System.out.println("This is Constructor of the Class");
  }

  public InstanceInitializerBlock(int a,int b){
    System.out.println("Parametrized Constructor\nValue of a = "+a+"  Value of b = "+b);
  }
  public static void main(String[] args) {
    var obj = new InstanceInitializerBlock();
    var obj2 = new InstanceInitializerBlock(23,32);
  }
}
