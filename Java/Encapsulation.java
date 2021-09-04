class Resource{
  private String name;
  private int age;

  public void setName(String name){
    this.name = name;
  }

  public void setAge(int age){
    this.age = age;
  }

  public String getName(){ return name;}
  public int getAge(){ return age;}
}
public class Encapsulation{

  public static void main(String[] args) {
    var obj = new Resource();
    obj.setName("Ali Hasan");
    obj.setAge(22);
    System.out.println(obj.getName()+" "+obj.getAge());
  }
}
