///Dart Functional Programming
///In functional programming you can do things like the following
/// 1. Pass functionas as arguments
/// 2. Assign a function to a variable
/// 3. Deconstruct a function that takes multiple arguments into a sequence of function that each take a single argument(also called currying)
/// 4. create a nameless function that can be used as a constant value(also called a lambda expression)
///
/// Dart supports all those features. In Dart, even functions are objects and have a type Function.
/// This means that functions can be assigned to variable or passed as argument to other functions.
/// you can also call an instance of a Dart class as if it were a function.
///
String scream(int length) => "A${'a' * length}h!";
void main(){
  final values = [1,2,3,4,5,10,50];
  for(var length in values){
    print(scream(length));
  }
}
