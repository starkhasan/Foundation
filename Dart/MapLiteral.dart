void main(){
  var map = {'Adbi Ansari': 3,'Asad Ansai': 5,'Ali Hasan': 24,'Abdul Shahid': 22};
  print('Type of the Map => ${map.runtimeType}');
  map.forEach((key, value) => print('$key => $value'));
}
