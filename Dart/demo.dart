class Student {
  String firstName;
  String lastName;

  Student(this.lastName, this.firstName);
  String call() => firstName + lastName;
}

void main(List<String> args) {
  var obj = Student('Hasan', 'Ali');
  var fullName = obj();
  print(fullName);
}
