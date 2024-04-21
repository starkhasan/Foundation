//dart has two kind of functional parameters: positional and named.
///Positional parameters are the kind you are likely familiar with

///normal positional parameter
/// int sumUp(int a, int b, int c){
///  return a+b+c;
///}
/// int total = sumUp(1,2,3);
///
/// with Dart you can make these positional parameter optional by wrapping them in brackets
/// int sumUpToFive(int a, [int? b, int? c, int? d, int? e]){
///  int sum = a;
///  if(b != null) sum += b;
///  if(c != null) sum +=c;
///  if(d != null) sum +=d;
///  return sum;
///}
///
/// optional positional parameter are always last in a function's parameter list
/// their default value is null unless you provide another default value
/// int sumUpToFive(int a, [int b = 2, int c = 3, int d = 4, int e = 5]) {
// ···
///}
///
/// Named parameter
/// Using a curly braces syntax at the end of the parameter list, you can define parameter that have names
/// Named parameters are optional unless they're explicitly marked as required.
///
/// void printName(String firstName, String  lastName, {Sttring? middleName}){
/// print('$firstName ${middleName ?? ''} $lastName')
///}
///
/// if the type of a paramter is non-nullable then you must either provide a default
/// value (as shown in the following code) or marked the parameter as required.
///
/// void printName(String firstName, String lastName, {String middleName = ''}) {
/// print('$firstName $middleName $lastName');
///}
///
///
///
