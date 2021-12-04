void main(List<String> args) {
  /**
   * Positive Lookbehind (?<=...)
   * Positive Lookbehind are used to get all the matches that are preceded by a specific pattern.
   * 
   * For example, the regular expression (?<=(T|t)he\s)(fat|mat) means: 
   * get all fat or mat words from the input
   * string that come after the word The or the.
   */
  var reg = RegExp(r'(?<=(T|t)he\s)(fat|mat)');
  var str = 'The fat cat sat on the mat.';
  var first = reg.allMatches(str);
  for (RegExpMatch item in first) {
    print(item.start);
  }
}
