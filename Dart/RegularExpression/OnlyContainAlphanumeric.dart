void main(List<String> args) {
  var regExp = RegExp(r'^[a-zA-Z]+$');
  var string = 'al';
  var item = regExp.hasMatch(string);
  print(item);
}