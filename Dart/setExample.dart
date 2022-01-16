void main(List<String> args) {
  var set = <int>{};
  var list = const [1, 2, 3, 4, 5];
  set = {1, 2, 3, ...list}; //spread operator
  print(set);
  set = {4, 5, 6, if (true) 10, 12}; //collection if
  print(set);

  set = {1, 2, 3, for (var item in list) item}; //set collection for
  print(set);
}
