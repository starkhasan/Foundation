class Super{
  void display() => print('This is super class method');
}
class Child extends Super {
  void display() => print('This is child class method');

  void message(){
    super.display();
    display();
  }
}
void main(){
  var obj = Child();
  obj.message();
}
