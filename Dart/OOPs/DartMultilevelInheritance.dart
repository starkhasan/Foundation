
/// Multilevel Inheritance
/// When there is a chain of inheritance, it is known as multilevel inheritance.
void main(){
  var babyObject = BabyDog();
  babyObject.eat();
  babyObject.bark();
  babyObject.weep();
}
class Animal{
  void eat() => print('Eating');
}
class Dog extends Animal {
  void bark() => print('Barking');
}
class BabyDog extends Dog {
  void weep() => print('Weeping');
}
