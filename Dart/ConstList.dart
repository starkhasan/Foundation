void main(List<String> args) {
  var names = const ['Ali', 'Hasan'];
  print(names);
  // names.add('Hasan');
  // print(names);

  var newList = List.generate(10, (index) => index + 1, growable: false);
  print(newList);
  newList[0] = 12;
  print(newList);
}
