void main(List<String> args) {
  //in map function of the list in dart
  // return a lazy iterable with elements that are created by calling a function on each element of this Iterable in Iterable order
  var list = [1, 2, 3, 4, 5, 6, 7, 8];
  var newList = list.map((e) => e + 3);
  print(list);
  print(newList);
}
