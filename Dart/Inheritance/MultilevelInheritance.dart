//Multilevel Inheritance
// In this inheritance when a child inherit the behaviour and characteristics of another subclass
class Bird {
  fly() => print('They can fly');
}
class Carnivorous extends Bird{
  eat() => print('They Eats animal flesh');
}
class Eagal extends Carnivorous{
  vision() => print('Eagal has sharp vision');
}
void main(){
  var obj = Eagal();
  obj
    ..vision()
    ..eat()
    ..fly();
}
