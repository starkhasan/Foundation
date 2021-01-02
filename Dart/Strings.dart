import 'dart:io';

void main() {
  print("Enter String : ");
  var name = stdin.readLineSync();
  print(name);
  print(name!.length);
  print(name.substring(3, 7));
  print(name.runtimeType);
  print(name.replaceAll("hasan", "tasan"));
  print("Enter Digit");
  var digit = int.parse(stdin.readLineSync()!);
  print("${digit} is of ${digit.runtimeType} type");
  var newType = digit.toString();
  print("${newType} is of ${newType.runtimeType} type");
  print("Enter a Sentance : ");
  var strSentance = stdin.readLineSync();
  var strAr = strSentance!.split(" ");
  print("${strAr.runtimeType} type");
  for (var ele in strAr) {
    print(ele);
  }
}
