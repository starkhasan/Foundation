import 'dart:collection';
//Collection of key value pair is consiered to as the Map
void main(){
  /*
   * Three different type maps
   *
   * HashMap
   * LinkedHashMap
   * SplayTreeMap
   */
  var listKeys = List.generate(10,(index) => index+1);
  listKeys.shuffle();
  print(listKeys);
  var listValues = List.generate(10,(index) => 'Index $index');
  listValues.shuffle();

  var map = Map.fromIterables(listKeys,listValues);
  map.forEach((key, value) => print('$key => $value'));
  //Coverting a LinkedHashMap to SplayTreeMap
  //SplayTreeMap sort the LinkedHashMap on the basis of the key
  var splayMap = SplayTreeMap<int, String>.from(map,(a, b) => a.compareTo(b));
  print(splayMap);
}
