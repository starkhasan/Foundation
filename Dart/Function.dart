import 'dart:io';

void main() {
  print("Enter Name : ");
  var name = stdin.readLineSync();
  print("Enter Age : ");
  var age = int.parse(stdin.readLineSync()!);
  printDetails(name, age);
}

printDetails(name, age) {
  print("My name is ${name} and i am ${age} years old");
}

//Function return value
/*
import 'dart:io';

void main() {
  print("Enter Name : ");
  var name = stdin.readLineSync();
  print("Enter Age : ");
  var age = int.parse(stdin.readLineSync());
  var isValid = printDetails(age);
  if (isValid)
    print("${name} is mature");
  else
    print("${name} you are a kid");
}

printDetails(age) {
  if (age > 18) return true;
  return false;
}
*/

/*
//Recursion 
void main() {
  print("Enter Number : ");
  var number = int.parse(stdin.readLineSync());
  print("Factorial of ${number} is ${factorial(number)}");
}

factorial(number) {
  if (number == 1)
    return 1;
  else {
    return number * factorial(number - 1);
  }
}
*/

