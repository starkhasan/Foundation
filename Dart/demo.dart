void main(){
  List<Employee> employeeList = [];
  employeeList.add(Employee(name: 'Alex', age: 24, salary: 245.0));
  employeeList.add(Employee(name: 'Martin', age: 39, salary: 120.0));
  employeeList.add(Employee(name: 'Lara', age: 42, salary: 213.0));
  employeeList.add(Employee(name: 'Allen', age: 21, salary: 90.0));
  employeeList.add(Employee(name: 'Johnny', age: 25, salary: 500.0));
  employeeList.add(Employee(name: 'Tony', age: 66, salary: 112.0));
  employeeList.add(Employee(name: 'Robert', age: 51, salary: 342.0));
  employeeList.add(Employee(name: 'MacCorty', age: 49, salary: 411.0));
  employeeList.add(Employee(name: 'Romonof', age: 37, salary: 492.0));
  employeeList.add(Employee(name: 'Natasha', age: 33, salary: 531.0));
  employeeList.add(Employee(name: 'Nebula', age: 19, salary: 871.0));
  employeeList.add(Employee(name: 'Gamora', age: 45, salary: 102.0));
  employeeList.add(Employee(name: 'Groot', age: 66, salary: 941.0));

  employeeList.sort(((a, b) => b.salary.compareTo(a.salary)));

  for(var item in employeeList){
    print('${item.name} => ${item.age} => ${item.salary}');
  }
}
class Employee{
  String name;
  int age;
  double salary;

  Employee({
    required this.name,
    required this.age,
    required this.salary
  });
}