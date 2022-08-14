void main() {
  import 'dart:io';
  void main() {
    ///Number data types
    var a = 10;
    //checing the type of data type using runtimeType method in dart
    print(a.runtimeType);
    ///checking different properties of the int
    ///isFinite
    print(a.isFinite);
    ///isNaN
    print(a.isNaN);
    ///isNegative
    print(a.isNegative);
    ///isEven
    print(a.isEven);
    ///isOdd
    print(a.isOdd);


    ///Checking the different method of the int
    /// returing the absolute value
    print(a.abs());
    ///return the ceil value
    print(a.ceil());
    ///return Floor value
    print(a.floor());
    ///return integer after discarding fractional digit
    print(a.truncate());
    ///return the string equivalent representation of the number
    print(a.toString().runtimeType);

  }

}
