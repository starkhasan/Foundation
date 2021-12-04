void main(List<String> args) {
  /**
   * Negative Lookbehind (?<...)
   * Negative Lookbehind are used to get all the matches that are not preceded by a specific pattern.
   * 
   * For example, the regular expression (?<=(T|t)he\s)(fat|mat) means: get all fat or mat words from the input
   * string that are not come after the word The or the
   */
  var reg = RegExp(r'(?<!(T|t)he\s)(cat)');
  var str = 'The cat sat on cat.';
  var first = reg.allMatches(str);
  for (RegExpMatch item in first) {
    print(item.start);
  }
}
