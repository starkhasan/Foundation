void main() {
  var reg = RegExp(r'[^0-9]');
  var number = '123asdf234njk55';
  number = number.replaceAll(reg, "");
  print(number);
}
