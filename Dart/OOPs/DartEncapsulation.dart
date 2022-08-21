
///Data Encapsulation
/// Data Encapsulation is binding data and functions that use data into one unit. It is also referred to as
/// data hinding and information hiding.
///
/// Dart does not have keyword for restricting access like private, public and protected.
///
/// Encapsulation in Dart happens at the library level and not at the class level.
/// Any identifier that starts with an underscore _ is private to its library.
///
/// Encapsulation means hiding the internal details of mechanics of how an object does something.
///
void main(){
  var studentObject = Student();
  studentObject.setStudentName = 'Ali';
  studentObject.setStudentAge = 24;
  print('${studentObject.getStudentName}  ${studentObject.getStudentAge}');
}

class Student {
  ///identifier that starts with an underscore _ is private to its library.
  late String _name;
  late int _age;

  ///setter method using custom set method
  void set setStudentName(String name) => _name = name;
  void set setStudentAge(int age) => _age = age;

  ///getter method using custom get method
  String get getStudentName => _name;
  int get getStudentAge => _age;
}
