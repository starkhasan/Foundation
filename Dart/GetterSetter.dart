class Rectangle {
  double left, top, width, height;

  Rectangle(this.left, this.top, this.width, this.height);

  //Define two calculated properties right and bottom
  double get right => left + width;

  set right(double value) => left = value - width;

  double get bottom => top + height;

  set bottom(double value) => top = value - height;
}

void main(List<String> args) {
  var rec = Rectangle(3, 4, 20, 15);
  rec.right = 12;
}
