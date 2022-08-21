
/// Polymorphism
/// Polymorphism is a concept by which we can perform a single action in different ways.

/// Real life example of polymorphism
/// A lady  can have different characteristics simultaneously. She can be mother, a daughter, or a wife, so the same lady
/// possesses different bahaviour in different situations.
///
/// Ploymorphism in Dart is supported only in the form of runtime polymorphism.
///
/// Dart  does not support method overloading (Compile Time Polymorphism), so each method name must be unique
/// regardless of its parameters requirement due to the support of dynamic data type.
///
///
class Car {
  void power(){
    print('It runs on petrol');
  }
}
class Honda extends Car{}
class Tesla extends Car{
  @override
  void power(){
    print('It runs on eletricity');
  }
}
void main(){
  var hondaObject = Honda();
  var teslaObject = Tesla();
  hondaObject.power();
  teslaObject.power();
}
