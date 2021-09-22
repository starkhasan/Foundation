import 'dart:io';
void main(List<String> args) {
  //Very Simple Assert
  print("Enter Two Number : ");
  int? a = int.parse(stdin.readLineSync()!);
  int? b = int.parse(stdin.readLineSync()!);
  assert(a > b);
  print("a is greater than b");
}

/*void main(List<String> args) {
  //Simple Assert
  print("Enter Two Number : ");
  var a = int.parse(stdin.readLineSync());
  var b = int.parse(stdin.readLineSync());
  assert(a > b, "a is smaller than b");
  print("a is greater than b");
}
*/


//to compile assert dart --enable-asserts <file_name>.dart
