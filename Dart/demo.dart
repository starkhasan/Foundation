class Student {
  late String name;
  late int age;

  set setName(String name) => this.name = name;

  set setAge(int age) => this.age = age;

  String get getName {
    return name;
  }

  int get getAge {
    return age;
  }
}

void main(List<String> args) {
  var obj = new Student();
  obj.setName = "Ali Hasan";
  obj.setAge = 12;
  print('Your name ${obj.name} and you are ${obj.age} years old');
}
