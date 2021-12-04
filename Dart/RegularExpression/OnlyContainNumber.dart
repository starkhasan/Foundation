void main(List<String> args) {
  var regExp = RegExp(r'^[0-9]+$');
  var string = '2344#';
  var item = regExp.hasMatch(string);
  print(item);
}
