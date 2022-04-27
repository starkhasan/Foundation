class Bike {
  int speed = 180;
}
class Car extends Bike {
  int speed = 200;
  //invoking the parent class vaiable using super
  void display() => print('The speed of car ${super.speed}');
}
void main(){
  //creating the child class instance
  var obj = Car();
  obj.display();
}
