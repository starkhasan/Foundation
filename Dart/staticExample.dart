class Student {
  //static variable
  static const String name = "Ali Hasan";
  String address = "Wali Ganj, Arrah";

  //Static method
  /*
  * Static method can not access the non static variable
  */
  static String userInformation() => name;
}

void main(List<String> args) {
  //to access the static method and variable
  //we actually do not need to create the instance of the Class
  print('Name = ${Student.userInformation()}');
  //to access the non static variable we need to create the instance of the Class
  print('Address = ${Student().address}');
}