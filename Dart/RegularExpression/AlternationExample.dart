void main(List<String> args) {
  /**
   * Vertical bar | is used to define alternation.
   * Alternation is like an OR statement between multiple expression
   */
  var reg = RegExp(r'(T|t)he|car');
  var str = 'The car is moving with the very high speed';
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
