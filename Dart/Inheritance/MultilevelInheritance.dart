//Multilevel Inheritance
// In this inheritance when a child inherit the behaviour and characteristics of another subclass
class Bird {
  fly() => print('It can fly');
}
class Carnivorus extends Bird{
  eat() => print('It Eats animal flesh');
}
class Eagal extends Carnivorus{
  vision() => print('Eagal has sharp vision');
}
void main(){
  var obj = Eagal();
  obj
    ..vision()
    ..eat()
    ..fly();
}
