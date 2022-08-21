
///A object is an instance of a class, as you know, A class is a blueprint
/// from which object are created.
/// A dart object is a logical entity.
void main(){
  ///creating a class object
  /// Object is an entity. Objects are declared to access functions and data declared in a class.
  var object = Student(name: 'Ali', age: 24);
  ///for accessing the class properties and methods we use . operator
  object.printStudentInformation();
}
///declare a class
class Student{
  ///member variable
  late String name;
  late int age;

  ///constructor
  Student({required String name, required int age}){
    this.name = name;
    this.age = age;
  }
  ///member function
  void printStudentInformation(){
    print('$name age is $age');
  }
}
