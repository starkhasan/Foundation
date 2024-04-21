void main() {
  ///Different types of String
  var singleQuoteString = 'this is a single quote string';
  var doubleQuoteString = 'this is a double quote string';
  var tripleQuoteString = '''this is a triple
sjhdg
sdfg
  1jhsdjfhghsjdf
  quote string''';

  var rawString = r'this\n is a raw string';

  // print("Single Quote String => $singleQuoteString");
  // print("Double Quote String => $doubleQuoteString");
  // print("Triple Quote String => $tripleQuoteString");
  // print("Raw Quote String => $rawString");


  ///Different constructor of String
  ///
  ///
  /// Different property of string in dart
  var firstString = "this is first string";
  ///length property
  print('Length of string => ${firstString.length}');
  ///isEmpty to check, if the string is empty
  print(firstString.isEmpty);
  ///isNotEmpty to check, the if the string is not empty.
  print(firstString.isNotEmpty);


  ///Different methods of string
  var methodString  = "this is method string";
  print(methodString.endsWith("ing"));
  print(methodString.indexOf('is'));
  print(methodString.lastIndexOf('is'));
  print(methodString.toUpperCase());
  print(methodString.toLowerCase());
  print(methodString.trim());
  print(methodString.trimLeft());
  print(methodString.trimRight());
  print(methodString.contains('is'));
  print(methodString.replaceAll("is", "as"));
  print(methodString.replaceRange(0, 2, "as"));
  print(methodString.toString());
  print(methodString.substring(2));
  print(methodString.split(''));


  var temp = '6';
  print(temp.padLeft(5,'0'));
}
