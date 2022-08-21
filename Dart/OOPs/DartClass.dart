
///Object Oriented Programming allows us to create object that contain both data and functions.
/// Object Oriented Programming is easier and faster to execute compared to Procedural Programming.
/// Dart is a object oriented programming language.
///
/// Various OOP features can be implemented in Dart they are:
/// 1. Classes
/// 2. Objects
/// 3. Data Encapsulation
/// 4. Inheritance
/// 5. Ploymorphism
void main() {
  ///class is a blueprint by which we can create an object how an object to access
  /// properties memeber of a class
  var studentObject = Student('Ali Hasan', '24');
  studentObject.printStudentDetails();
}
///Classes
/// Class is a user defined data type and it contains it's own data members(Constructors, Getters and Setters)
/// and member functions. A class encapsulates data for the object.
///
/// A class in Dart can be declared by using the keyword class followed by the class name and the class
/// and the body of the class should be enclosed with a pair of curly braces.
///
///
/// A class contains
/// 1. constructor
/// 2. method
/// 3. fields
/// 4. getter and setter
class Student {
  ///member variable, instance variable, fields
  late String name;
  late String age;

  ///constructor of class
  Student(String name, String age){
    this.name = name;
    this.age = age;
  }

  ///member function of class
  void printStudentDetails(){
    print('$name age is $age');
  }

}
