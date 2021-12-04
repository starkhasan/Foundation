main(List<String> args) {
  var reg = RegExp(r'^[A-Z]*$');
  var str = 'ALIHAaAN';
  if (reg.hasMatch(str))
    print('Valid');
  else
    print('Invalid');
}
