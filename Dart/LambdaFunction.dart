import 'dart:io';

void main() {
  print("Enter your Name : ");
  var name = stdin.readLineSync();
  print(test());
  printName(name);
}

int test() => 123;
void printName(name) => print(name);
