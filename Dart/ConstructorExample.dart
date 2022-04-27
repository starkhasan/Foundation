class Student{
  //instance variable
  String? name;

  /// Class Constructor
  /// Constructor is used to initialize the instance variable and also object when it is created
  /// Constructor does not have the explicit return type not even void
  ///
  /// three types of constructor
  ///
  /// 1. Default Constructor / No Argument Constructor
  /// 2. Parametrized Constructor
  /// 3. Named Constructor
  ///
  /// No Argument Constructor
  // Student(){
  //   this.name = 'Ali Hasan';
  // }


  /// Parametrized Constructor
  // Student({required String firstName, required String lastName}){
  //   name = '$firstName $lastName';
  // }


  /// Dart does not have the facility of Method Overloading
  /// Dart does have Named Constructor, which allow to declare the two different constructor with different name

  Student.fullName({required String firstName, required String lastName}){
    name = '$firstName $lastName';
  }

  Student.shortName({required String name}){
    this.name = name;
  }

  printName() => print(name);
}
void main(){
  var obj = Student.fullName(firstName: 'Ali', lastName: 'Hasan');
  obj.printName();
  obj = Student.shortName(name: 'Ali');
  obj.printName();
}
