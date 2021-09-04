class Animal{
  void eat(String animal){
    System.out.println(animal+" eats");
  }
}
class Dog extends Animal{
  void bark(String animal){
    System.out.println(animal+" bark");
  }
}
class PitBull extends Dog{
  void about(){
    System.out.println("Pitbull are medium-sized, intelligent and Strong dogs");
  }
}

public class MultilevelInheritance{

  public static void main(String[] args) {
    var obj = new PitBull();
    var animal = "PitBull";
    obj.eat(animal);
    obj.bark(animal);
    obj.about();
  }
}
//When there is a chain of inheritance or a child inherit the property form another child class that is said to be the Multilevel Inheritance.
