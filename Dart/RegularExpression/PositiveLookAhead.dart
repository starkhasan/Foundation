void main(List<String> args) {
  /**
   * Positive Lookahead (?=)
   * positive lookahead asset that first part of the expression must be followed by the lookahead expression
   * 
   * For example, the regular expression (T|t)he(?=\sfat) means: match either a lowercase t or 
   * an uppercase T, followed by the letter h, followed by the letter e. In parentheses we define a 
   * positive lookahead which tells the regular expression engine to match The or the only if it's 
   * followed by the word fat.
   */
  var reg = RegExp(r'(T|t)he(?=\sfat)');
  var str = ' The fat cat sat on the mat.';
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
