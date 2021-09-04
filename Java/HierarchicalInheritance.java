class Animal{
  void eat(String animal){
    System.out.println(animal+" eats");
  }
}
class Dog extends Animal{
  void bark(){
    System.out.println("Dogs bark");
  }
}
class Cat extends Animal{
  void meow(){
    System.out.println("Cats Meow");
  }
}
public class HierarchicalInheritance{
  public static void main(String[] args) {
    var dogObj = new Dog();
    var catObj = new Cat();
    dogObj.eat("Dog");
    dogObj.bark();
    catObj.eat("Cat");
    catObj.meow();
  }
}
