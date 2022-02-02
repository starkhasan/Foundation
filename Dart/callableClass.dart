class Student {
  String firstName;
  String lastName;

  Student(this.lastName, this.firstName);
  /*
   * Dart allows the user to create a callable class which allows the instance fo the class to be called as a function
   * 
   * Dart does not support multiple callable method if we try to create more than one cllable function for the same class it will display error
   */
  String call({required String firstName, required String lastName}) => firstName + lastName;
}

void main(List<String> args) {
  var obj = Student('Hasan', 'Ali');
  var fullName = obj(firstName: 'Ali ', lastName: 'Hasan');
  print(fullName);
}
