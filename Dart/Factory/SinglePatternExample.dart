class Student{
  // ///Named Constructor of the Student class
  // Student.namedConstructor();
  //
  // ///Student class instance
  // static final Student _instance = Student.namedConstructor();
  //
  // ///factory Constructor of Student class
  // factory Student(){
  //   return _instance;
  // }



  ///Named Constructor of the Student class
  Student();

  ///Student class instance
  static final Student _instance = Student();

  ///factory Constructor of Student class
  factory Student.init(){
    return _instance;
  }
}

void main(){
  var obj1 =  Student.init();
  var obj2 =  Student.init();
  var obj3 =  Student.init();

  if(obj1 == obj2){
    print('Both objects are equal  ${obj1.hashCode}  ${obj2.hashCode}');
  } else{
    print('Both objects are not equal');
  }
}
