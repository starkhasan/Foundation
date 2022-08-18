void main() {
  ///List Collection (An Indexable collecion Object)
  /// Types of List
  /// 1. Fixed length list
  /// 2. Growable List
  ///
  /// List.generate(length, (index) => index, grawable: true) => it creates the growable list
  /// List.generate(length, (index) => index, growable: false) => it creates the non growable list
  ///

  ///Growable List
  var list = List.generate(10, (index) => index+1, growable: true);
  print(list);
  ///in growable list we are able add as well as remove item.
  list.add(50);
  print(list);
  //removing last item
  list.removeLast();
  print(list);

  ///properties of list
  ///first
  print(list.first);
  ///isEmpty => this method returns true if the list is Empty
  print(list.isEmpty);
  //isNotEmpty => this method returns true if the list is not empty
  print(list.isNotEmpty);
  ///length => this method is used to returns the length of the list
  print(list.length);
  ///last => this method returns the length of the list
  print(list.length);
  ///reverse => this method Reversed list (but it returns void)
  print(list.reversed);
  ///sort => this method sort the list
  print(list.sort);



  ///Methods define for the list
  /// add => this method add single item in the list at last
  list.add(11);
  print(list);
  //addAll => this method is used to add other list at the end of the list
  list.addAll([11,22,33,44]);
  print(list);
  //any => checks whether any element of this iterable satisfies test
  ///checks for every element in iteration order and returns true if any of them make test return true otherwise returns false
  if(list.any((item) => item > 5)){
    print('Some item in the list are greater than 5');
  }else{
    print('All items are less than equal to 5');
  }
  //clear => this method is used to clear all the list and return void.
  ///contains => Whether the collection contains an element equal to element.
  /// this operation will check each element in order for being equal to element,
  /// unless it has more efficient way to find an element equal to element
  if(list.contains(33)){
    print('Yes 33 present in the list');
  }else{
    print('No 33 is not present in the list');
  }
  ///elementAt(index) => it returns the element at particular index
  print(list.elementAt(3));
  ///firstWhere => it returns the first element that satisfies the given predicts
  print(list.firstWhere((item) => item == 22));
  //getRange(start, end) => return an iterable that iterates over the object in
  var tempList = list.getRange(0, 4);
  print(tempList);
  ///

}
