import 'dart:math';

Shape shapeFactory(String type){
  if(type == 'circle') return Circle(2);
  if(type == 'square') return Square(2);
  throw "Can't create $type";
}

abstract class Shape {
  ///adding factory constructor to the absract Shape class
  factory Shape(String type){
    if(type == 'circle') return Circle(2);
    if(type == 'square') return Square(2);
    throw "Can't create $type";
  }
  num get area;
}

class Circle implements Shape {
  final num radius;
  Circle(this.radius);
  num get area => pi * pow(radius, 2);
}

class Square implements Shape {
  final num side;
  Square(this.side);
  num get area => pow(side, 2);
}

main() {
  final circle = Circle(2);
  final square = Square(2);
  ///invoking factory function
  // final circle = shapeFactory('circle');
  // final square = shapeFactory('square');
  print(circle.area);
  print(square.area);
}
