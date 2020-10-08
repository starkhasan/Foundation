class Employee {
  var empName;
  var empAge;
  var empSalary;

  void printEmpDetails() {
    print("Name of Employee = ${empName}");
    print("Age of the Employee = ${empAge}");
    print("Salaray of Employee = ${empSalary}");
  }
}

void main(List<String> args) {
  Employee emp = new Employee();
  emp.empName = "Ali Hasan";
  emp.empAge = 22;
  emp.empSalary = 20000;
  emp.printEmpDetails();
}