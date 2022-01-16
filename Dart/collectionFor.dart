void main(List<String> args) {
  var list = [1, 2, 3];
  var newList = [
    1,
    2,
    for (var item in list) item+1
  ];
  print(newList);
  print(newList.runtimeType);
}
