///Null-aware operator
/// Dart offers some handy operator for dealing with values that might be null.
/// One is the ??= assignment operator, which asigns a value to a variable only if that variable is null
void main(){
  int? a; //null
  a ??= 3;//null aware assignment operator
  print(a);

  a ??= 5;
  print(a);

  ///Another null-aware operator is ?? which return the expression on its left
  ///unless that expression's value is null in which case it evaluate and return the expression on its right
  print(1 ?? 3);
  print(null ?? 12);
}
