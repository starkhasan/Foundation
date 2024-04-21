///1
///Positional Parameter
///Positional parameter are the most common type of paramter in dart function.
///They are defined in function's paramter list and are matched to the arguments based on thier position
///You can provide default values for positional paramters, making them optional
void printDetails(String name, int age){
  print("Name: $name, Age: $age");
}

///Positional Parameter with optional named paramter
// void printDetails(String name, {int age = 26, String address = "Wali ganj"}){
//   print("Name: $name, Age: $age");
// }

// ///Positional paramter with optional position parameter
// void printDetails(String name, [int age = 26, String address = "Wali Ganj"]){
//   print("Name: $name Age: $age Address: $address");
// }



///2
///Named Parameter
///Named paramters are specified using curly braces {} in the function's paramter list.
///They are matched to the arguments based on their names, allowing you to pass arguments in any order
///Named paramters are also optional by default
void printPerson({String? name, int? age}){
  print("Name: $name, Age: $age");
}

///3
///Optional Parameter with default value
///Both positional and named paramters can be made optional by providing default values
///if no value is provided for an optional parameter, it takes on the default value.
void greet(String name, {String greeting = "Hello"}){
  print("$greeting $name");
}


///4
///Required Parameter
///In Dart 2.9 and later, you can explicitly mark paramter as required using the required keyword
///This ensures that the caller must provide a value for the required parameter
void sayHello({required String name}){
  print("Hello $name");
}


///5
///Functional Paramter (Function callbacks)
///You can pass functions as paramters to other functions. This is often used for callbacks and event handling
void executeWithCallback(void Function() callback){
  callback();
}



void main() {
  printDetails("Ali Hasan", 26);
}