void main(List<String> args) {
  /**
   * Dollar sign $ is used to check if matching character is the last character in the string
   */
  var reg = RegExp(r'(at\.)$');
  var str = 'The fat cat. sat. on the mat.';
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
