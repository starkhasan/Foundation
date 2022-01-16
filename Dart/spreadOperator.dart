void main(List<String> args) {
  //Dart 2.3 introduced the spread operator (...) and the null-aware spread operator (...?)
  // which provide a concise way to insert multiple values into a collection
  var list1 = [1, 2, 3, 4, 5, 6, 7];
  var list2 = [1, 2, 3, ...list1, 5, 4, 2];
  print(list2);
}