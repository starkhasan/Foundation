abstract class Dog {
  void bark() => print('Dog usually bark');
  void eat();
}

class Demo extends Dog {
  void sound() => print('Each animal speaks in their own language');

  @override
  void eat() {
    // TODO: implement eat
  }
}

void main(List<String> args) {
  var obj = Demo();
  obj.bark();
  obj.sound();
}
