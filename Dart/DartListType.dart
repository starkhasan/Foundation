
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


  ///Non Growable list
  var list2 = List.generate(10, (index) => index+1, growable: false);
  print(list2);
  ///in growable list we are unable to add as well as remove item.
  list2.add(50); ///will throw error cannot add to fixed length list
  print(list2);
  list2.removeLast();// will throw error cannot remove to fixed length list

}
