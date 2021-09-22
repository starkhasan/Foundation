import 'dart:async';

void main() {
  print('calculation');
  var number = 120;
  print(number * 4);
  futureOperation();
  print('Working');
}

void futureOperation() async {
  print('Processing');
  var result =  getName();
  print(result);
}

Future<String> getName() async{
  await Future.delayed(const Duration(seconds: 0), () {});
  return "Hasan Ali";
}
