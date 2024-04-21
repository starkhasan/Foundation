class Person {
  final String name;

  Person(this.name);

  void printName() => print(name);
}
void main() {
  //Tear-off can also be used to create reference to constructor.
  //class_name.new syntax in dart is a way to create a reference to a constructor that can be used later.
  final personFactory = Person.new;
  ///Ther personFactory varaible now refers to ther Person class's default constructor, so you can use it to create new instance of the Person class.
  ///The .new syntax is a tear-off, which was introduced in Dart 2.15.
  ///
  ///
  ///
  final newPerson = personFactory('Ali Hasan');

  ///Some of the benefit of used tear-offs 
  ///1. They can make your code more concise
  ///2. They can make your code more reusable
  ///3. They can make your code more efficient.
  ///If you are using Dart 2.15 or higher, i encourage you to try using tear-off.

}