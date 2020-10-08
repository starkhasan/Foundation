/*
An operator is a special symbol that is used to carry out some specific operations on its operand
In dart we have follwing type of operators available.
1. Assignment Operator
2. Arithmetic Operator
3. Type test operator
4. Relational Operator
5. Logical Operator
6. Bitwise Operator
7. Conditional Operator
8. Cascade Operator
*/

import 'dart:io';

/*
void main() {
  print("Enter number : ");
  var number = int.parse(stdin.readLineSync()); // assignment operator using to assign the value to variable number
  print(number);
}
*/

/*
void main() {
  print("Enter two Number : ");
  var a = int.parse(stdin.readLineSync());
  var b = int.parse(stdin.readLineSync());
  print("Arithmetic Operator + result ${a + b}");
  print("Arithmetic Operator - result ${a - b}");
  print("Arithmetic Operator * result ${a * b}");
  print("Arithmetic Operator / result ${a / b}");
  print("Arithmetic Operator % result ${a % b}");
}
*/

/*Relational Oprator
void main(List<String> args) {
  print("Enter Two Number : ");
  var a = int.parse(stdin.readLineSync());
  var b = int.parse(stdin.readLineSync());
  if (a > b)
    print("${a} is greater than ${b}");
  if (a < b)
    print("${b} is greater than ${a}");
  if (a == b)
    print("${a} and ${b} both are equal");
  if (a != b)
    print("${a} and ${b} are not equal");
}
*/

/*
//Logical Operator
void main() {
  print("Enter Two number : ");
  var a = int.parse(stdin.readLineSync());
  var b = int.parse(stdin.readLineSync());
  if (a > b && a > 0) {
    print("${a} is greater than ${b}");
  } else {
    print("${b} is greater than ${a}");
  }
}
*/


//Conditional Operator
void main() {
  print("Enter Two Number : ");
  var a = int.parse(stdin.readLineSync());
  var b = int.parse(stdin.readLineSync());
  var temp = a > b ? a : b;
  print("${temp} is greater");
}
