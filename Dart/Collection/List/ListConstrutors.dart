void main() {
  ///List.empty constructor => create an empty list
  ///We can also define the type list it can create, using generic type like List<int>.empty()
  var list1 = List.empty(growable: true);
  print(list1);
  list1.add(2);
  print(list1);

  ///List.filled => Create a list of the given length with fill at each position
  var list2 = List.filled(10, 1, growable: false);
  print(list2);

  ///List.from => Create a list containing all elements
  Iterable<int> originalIterable = [1,2,3,4,5];
  var list3 = List.from(originalIterable, growable: false);
  print(list3);

  ///List.generate => generate a list of values
  var list4 = List.generate(10, (index) => index+1, growable: false);
  print(list4);

  ///List.of => create a list from elements
  var list5 = List.of([1, 2, 3, 4, 5]);
  print(list5);


  ///List.unmodifiable => creates an unmodifiable list containning all elements
  var list6 = List.unmodifiable([1,2,3,4,5,6]);
  print(list6);
  list6.add(4);
}