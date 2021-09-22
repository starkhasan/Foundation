class Employee {
  static var empDept;
  var name;
  var salaray;
  printEmpDetails() {
    print("Employee's name is ${name}");
    print("Employee's salary is ${salaray}");
    print("Employee's Department is ${empDept}");
  }
}

void main(List<String> args) {
  Employee emp1 = new Employee(); 
  Employee emp2 = new Employee();
  Employee.empDept = "MIS";
  
  emp1.name = 'John'; 
  emp1.salaray = 25000; 
  emp1.printEmpDetails();

  emp2.name = 'Keith'; 
  emp2.salaray = 30000;
  emp2.printEmpDetails();
}