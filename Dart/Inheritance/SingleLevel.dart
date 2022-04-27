class Bird {
  fly() => print('It can fly');
}
class Parrot extends Bird {
  color() => print('The Color of the parrot is green');
}
void main(){
  var obj = Parrot();
  obj
    ..color()
    ..fly();
}
