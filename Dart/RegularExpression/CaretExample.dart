void main(List<String> args) {
  /**
   * Caret sign is to check if a matching character is the first character of the input string
   * if we apply the following regular expression ^a (means a must be the following starting character) to string abc
   */
  var reg = RegExp(r'^(T|t)he');
  var str = 'The car is parking in The garage';
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
