class SingletonClass{
  SingletonClass.namedConstructor();
  static final SingletonClass _instance = SingletonClass.namedConstructor();
  /*
   * Use the factory keyword when implementing a constructor that does not always create a new instace of its class.
   * A factory constructor might return an instance from a cache or it might return an instance of a subtype.
   * initializing a final variable using logic that can't be handled in the initializer list
   *
   * Another way to handle late initialization of final variablel is to user late final
   * Factory constructor have no access to this.
   */
  factory SingletonClass(){
    return _instance;
  }
}

void main(){
  var s1 = SingletonClass();
  var s2 = SingletonClass();
  var s3 = SingletonClass();
  var s4 = SingletonClass();
  var s5 = SingletonClass();
  var s6 = SingletonClass();

  if(identical(s1,s2)  && identical(s2,s3) && identical(s3,s4) && identical(s3,s4) && identical(s4,s5) && identical(s5,s6)){
    print('All instance are indetical');
  }else{
    print('All instance are not identical');
  }


  if(s1 == s2 && s2 == s3 && s3 == s4 && s4 == s5 && s5 == s6){
    print('All Instance are same');
  }else{
    print('All instance are not same');
  }

}
