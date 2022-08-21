/// Inheritance
/// Inheritance is a mechanism in which one class acuires all the propertoes
/// and behaviour of a parent class.
///
/// The idea behind inheritance is that you can create new classes that are
/// built upon existing classes. When we inherit from an existing class, we can
/// reuse methods and fields of the parent class. Moreover we can add new methods
/// and fields in our current class also.
///
/// Inheritance represent the IS-A relationship which is also known as
/// parent-child relationship.
///
void main(){
  var programmerObject = Programmer();
  print('Salary of programmer = ${programmerObject.salary}');
  print('Bonus of programmer = ${programmerObject.bonus}');
}
///Base or Parent class
class Employee {
  double salary = 4000.0;
}
///Derived or Child class
/// The extends keyword indicates that you are making a new class that derived from an existing class.
class Programmer extends Employee {
  int bonus = 1000;
}
///Here, Programmer object can access the field of own class as well as Employee class i.e code reusability.
///
///
