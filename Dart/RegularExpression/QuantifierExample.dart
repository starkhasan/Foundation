void main(List<String> args) {
  /**
   * Quantifier are used to specify the number of times that a character
   * or a group of character can be repeated.
   */
  var reg = RegExp(r'^[0-9]{2,3}$');
  var str = '12345';
  var first = reg.allMatches(str);
  for (RegExpMatch item in first) {
    print(item.start);
  }

  if (reg.hasMatch(str)) {
    print('It is present');
  } else {
    print('The pattern is not present inside the string');
  }
  
}
