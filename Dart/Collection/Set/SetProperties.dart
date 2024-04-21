void main() {

  var set = <int>{1,2,3,4,5,6,7,6};//Declaring a set using Set Literal

  print(set.first);

  print(set.last);

  print("Set Length => ${set.length}");

  print(set.isEmpty);

  print(set.isNotEmpty);


  var itr = set.iterator;

}
