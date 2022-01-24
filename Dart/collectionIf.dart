void main(List<String> args) {
  bool isActive = true;
  var list = [1, 2, 3, if (isActive) 4, 5];
  print(list);
  print(list.runtimeType);
}