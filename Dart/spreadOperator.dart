void main(List<String> args) {
  //dart 2.3 introduce the spread operator (...) and null-aware spread operator
  // (..?), which provides a concise way to insert
  /// multiple vales in a collection.
  ///
  /// spread operator => we can use this operator to insert all the values of a list into another list.
  var list = [1,2,3,4];
  var list2 = [0, ...list];

  ///null-aware spread operator(...?)
  /// if the expression to the right of the spread operator might be null, you can avoid exception by using a null-aware spread operator...
  var list3 = [0, ...?list];
}
