//Multilevel Inheritance
// In this inheritance when a child inherit the behaviour and characteristics of another subclass
class Bird{
  void fly() => print('it can fly');
}
class Parrot extends Bird{
  void speak() => print('Parrot speaks like human');
}
class Eagle extends Bird{
  void vision() => print('Eagle has sharpe vision');
}

void main(){
  var eagleObj = Eagle();
  var parObj = Parrot();

  eagleObj.vision();
  eagleObj.fly();
  parObj.speak();
  parObj.fly();
}
