class Vector {
  final int x, y;
  Vector(this.x, this.y);
  Vector operator +(Vector v) => Vector(x + v.x, y + v.y);
  Vector operator -(Vector v) => Vector(x - v.x, y - v.y);
}

void main(List<String> args) {
  final v = Vector(2, 3);
  final w = Vector(2, 2);
  var newVector = v + w;
  print("New Vector => x ${newVector.x}   y  ${newVector.y}");
}
