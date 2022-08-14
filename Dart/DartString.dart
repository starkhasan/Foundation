import 'dart:io';
void main() {
  ///String Data Types
  var str = "Cocacola";
  ///checking the runtimeType of str variable
  print(str.runtimeType);
  ///different way to define the string
  /// Single Quote String
  var singleQuoteString = 'Single Quote';
  ///Double Quote String
  var doubleQuoteString = "Double Quote String";
  ///Triple Quote String
  var tripleQuoteString = '''Triple Quote String''';

  ///Raw string (to declare raw string add r before the quotation symbol, and it consider escape sequences as the character)
  var rawString = r'Hello\nWorld';
  print(rawString);

  ///Declaring different properties of the string
  //length property of string
  print(str.length);
  ///isEmpty property of the string
  print(str.isEmpty);
  ///isNotEmpty property of the string
  print(str.isNotEmpty);
  ///concatination using + operator
  print(str+' Good');
  ///repeatation using * operator
  print(str*3);
  ///[] index operator to get the particular string at particular index
  print(str[3]);


  ///Declaring different string methods
  ///toLowerCase() to convert string to lower case
  print(str.toLowerCase());
  ///toUpperCase() to convert string to UPPER case
  print(str.toUpperCase());
  ///trim() to remove the leading and trailing space from a string
  print(str.trim());
  ///split() to split the string using any regular expression /// and it return List<String> after performing split() operation
  print(str.split(''));
  ///substring() to produce a sub string from existing string from a particular start and end index.
  print(str.substring(0,3));
  ///idnexOf() to return the positon of first match of pattern in string
  print(str.indexOf('c'));
  ///contains() return true or false if a pattern exist in the string
  print(str.contains('c'));


  ///Advance Concept
  /// to create a string in dart programatically
  /// to create a string programatically we will have to use StringBuffer
  /// StringBuffer
  /// to generate a string from StringBuffer call toString() method on String Buffer Object
  var strBuffer = StringBuffer();
  strBuffer
    ..write('Ali Hasan ')
    ..writeAll(['Flutter','Developer'], ' ')
    ..write('.');
  var newString = strBuffer.toString();
  print(newString);
}
