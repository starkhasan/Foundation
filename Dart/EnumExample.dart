enum Color {red, green, pink}
void main() {
  var favColor = Color.green;
  if(favColor == Color.red){
    print("This is my favorite color");
  } else {
    print("This is not my favorite color");
  }

  ///Each enum has an index getter which returns the zero-based position of the value in the enum declaration.
  print(Color.red.index);

  ///To get the list of all enum value, use the enum's values constant.
  var enumList = Color.values;
  print(enumList);

  for(var item in Color.values){
    print(item);
  }

  ///You can use enum in switch case
  switch(favColor){
    case Color.red:
      print("The color is red");
      break;
    case Color.green:
      print("The color is green");
      break;
    case Color.pink:
      print("The color is pink");
      break;
    default:
      print("Color does not found");
  }


  ///To access the name of an enumerated value, such as "blue"
  ///
  print(favColor.name);
}
