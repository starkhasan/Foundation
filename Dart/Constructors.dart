import 'dart:io';
/*class Employee {
  var empName;
  var empAge;
  var empSalary;

  Employee() { // Default-Constructor
    empName = "Ali Hasan";
    empAge = 22;
    empSalary = 20000;
  }

  void printEmpDetails() {
    print("Name of Employee = ${empName}");
    print("Age of the Employee = ${empAge}");
    print("Salaray of Employee = ${empSalary}");
  }
}

void main(List<String> args) {
  Employee emp = new Employee();
  emp.printEmpDetails();
}*/

/*
class Employee {
  var empName;
  var empAge;
  var empSalary;

  Employee(name, age, salary) { // Parametrized Constructor
    empName = name;
    empAge = age;
    empSalary = salary;
  }

  void printEmpDetails() {
    print("Name of Employee = ${empName}");
    print("Age of the Employee = ${empAge}");
    print("Salaray of Employee = ${empSalary}");
  }
}

void main(List<String> args) {
  print("Enter Name of Employee : ");
  var name = stdin.readLineSync();
  print("Enter Age of Employee : ");
  var age = int.parse(stdin.readLineSync());
  print("Enter Salary of Employee : ");
  var salary = double.parse(stdin.readLineSync());
  Employee emp = new Employee(name,age,salary);
  emp.printEmpDetails();
}
*/

/*Named Constructor
In Dart named constructor allow a class to define multiple constrcutor
*/
void main() {
  Employee emp1 = new Employee();
  Employee emp2 = new Employee.namedConst('EMP001');
}

class Employee {
  Employee() {
    print("Default Constructor Invoked");
  }
  Employee.namedConst(String empCode) {
    print("Named Constructor Invoked");
    print(empCode);
  }
}
