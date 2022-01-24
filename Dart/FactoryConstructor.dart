class Student {
  Student.namedConstructor();
  static final Student instance = Student.namedConstructor();

  factory Student.init() {
    return instance;
  }
}

void main(List<String> args) {
  var obj1 = Student.init();
  var obj2 = Student.init();
  if (identical(obj2, obj1)) {
    print("Both the object are identical");
  } else {
    print("Both objects are not identical");
  }
}
