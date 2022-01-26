class Bird {
  fly() => print('Birds fly');
}

class Carnivorous extends Bird {
  String name = 'Carnivorous only eats Animal flesh and meat';
  eat() {
    super.fly();
    print('They only eat meats');
  }
}

class Eagal extends Carnivorous {
  vision() {
    print('Eagal has sharp vision');
    print(super.name);
  }
}

void main(List<String> args) {
  var objEagal = Eagal();
  objEagal.vision();
  objEagal.eat();
}
