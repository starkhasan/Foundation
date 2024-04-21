class Bicycle {
  int cadence;
  // int speed;
  //To make a dart identifer as private to its library, start its name with an
  // underscore(_).
  int _speed = 0;
  int gear;

  ///Using this in a constructor parameter list is a handy shortcut for assigning
  /// values to instance variables.
  Bicycle(this.cadence, this.gear);

  ///getter to the bicycle class
  int get speed => _speed;

  ///by default dart provides implicit getter and setter for all public instance variables,
  /// you don't need to define your own getters or setters unless you want to enforce read-only or write-only variable.

  ///setter methods
  void applyBreak(int decrement){
    _speed -= decrement;
  }

  void speedUp(int increment){
    _speed += increment;
  }



  ///All Dart classes have a toString() method that you can override
  ///to provide more useful output
  @override
  String toString() => 'Bicycle: $speed mph';
  ///The @override annotation tells the analyzer that you are intentionalyy override a member

  ///Use string interpolation to put the value of an expression inside a string literal: ${expression}
  ///if expression is an identifier, you can skip the braces $variableName.
  ///
}
///the main method lives at the top level.
/// In Dart you can define code outside of classes.
/// variables, functions, getter and setter cal all live outside of classes.
void main(){
  ///Remove the optional new keyword
  ///The new keyword become optional in Dart2.
  var bike = new Bicycle(2, 0);
  ///if you know that a variable's value won't change, then you can use final instead of var

  ///the  print() function accepts any object (not just strings).
  ///it converts it to a string using then object's toString() method.
  print(bike);

  print(bike);
}
