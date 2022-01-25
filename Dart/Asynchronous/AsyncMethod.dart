void main() async{
  var data = await futureMethod();
  print('Done $data');
}
Future<String> futureMethod() async{
  await Future.delayed(const Duration(seconds: 1));
  return 'Ali Hasan';
}
