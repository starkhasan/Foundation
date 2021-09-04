class Animal{
  void eat(String animal){System.out.println(animal+" eats");}
}
class Dog extends Animal{
  void bark(String animal){
    System.out.println(animal+" barks");
  }
}
public class SingleLevelInheritance{
  public static void main(String[] args){
    var obj = new Dog();
    var animal = "Dog";
    obj.bark(animal);
    obj.eat(animal);
  }
}
//When a class Inherits the Another Single class that is known as the SingleLevelInheritance
