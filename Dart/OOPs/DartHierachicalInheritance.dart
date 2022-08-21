
/// Hierarchical Inheritance
/// When two or more class inherits a single class, it is known as hierarchical inheritance.
void main(){
  var cat = Cat();
  cat.eat();
  cat.meow();
}
class Animal{
  void eat() => print('Eating');
}
class Dog extends Animal {
  void bark() => print('Barking');
}
class Cat extends Animal {
  void meow() => print('Meowing');
}
