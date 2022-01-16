void main(List<String> args) {
  bool isActive = false;
  var list = [1, 2, 3, if (isActive) 4, 5];
  print(list);
  print(list.runtimeType);
}