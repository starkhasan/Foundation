void main(List<String> args) async {
  var listNumber = List.generate(10, (index) => index + 1);
  listNumber.forEach((element) => print(element));

  var listAnotherNumber = generatorFuntion();
  print(listAnotherNumber);

  var list = naturalsTo(10);
  list.forEach((element) =>
      print('Number => $element   Type  =>  ${element.runtimeType}'));

  var number = await asynchronousNatual(10);
  number.forEach((element) => print(element));
}

//synchronous generator function
Iterable<int> naturalsTo(int n) sync* {
  int k = 0;
  while (k < n) yield k++;
}

List<int> generatorFuntion() {
  var listNumber = List.generate(10, (index) => index + 1);
  return listNumber;
}

//asynchronous generator function
Stream<int> asynchronousNatual(int n) async* {
  int k = 0;
  while (k < n) yield k++;
}

//if you generate is recursive you can improve its performance by using yield*
Iterable<int> naturalDownFrom(int n) sync* {
  if (n > 0) {
    yield n;
    yield* naturalDownFrom(n - 1);
  }
}
