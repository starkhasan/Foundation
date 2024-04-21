void main() {
  var list1 = [1,2,3,4,5];
  ///Spread operator (...)
  /// provides a concise way to insert multiple value in a collection
  var list2 = [0,...list1,6,7,8,9];


  var list3 = null;
  ///null-aware  spread operator
  /// If the expression to the right of the spread operator might be null,
  /// you can avoid exceptions by using a null-aware spread operator (...?):
  var list4 = [...list1, ...?list3];

  print(list2);

  print(list4);
}
