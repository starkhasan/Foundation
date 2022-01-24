class Student {
  String firstName;
  String lastName;

  Student(this.lastName, this.firstName);
  String call({required String firstName, required String lastName}) =>
      firstName + lastName;
}

void main(List<String> args) {
  var obj = Student('Hasan', 'Ali');
  var fullName = obj(firstName: 'Ali ', lastName: 'Hasan');
  print(fullName);
}
