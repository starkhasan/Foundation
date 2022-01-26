class Person {
  String? firstName;
  Person(Map data) {
    print('in person class');
  }

  Person.fromJson() {
    print('this is named constructor');
  }
}

class Employee extends Person {
  Employee.fromJson(Map data) : super.fromJson() {
    print('in employee class');
  }
}

void main(List<String> args) {
  var obj = Employee.fromJson({});
}
