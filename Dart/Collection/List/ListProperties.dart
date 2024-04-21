void main() {
  var list = List.generate(1, (index) => index+1);

  ///1
  ///first => access the first item of the list
  print(list);

  ///It can also write on first item using first property
  list.first = 45;

  print(list);


  ///2
  ///hashCode => return the hashCode for this object
  print(list.hashCode);


  ///3
  ///isEmpty => return true if collection has no element.
  print(list.isEmpty); 


  ///4
  ///isNotEmpty => reutrn true if collection has atleast one element.
  print(list.isNotEmpty);

  ///5
  ///last =>access the last item of the list
  print(list.last);

  ///It an also write on last item using last property
  list.last = -10;


  ///6
  ///reversed => An iterable of the object in this list in reverse order.
  var revlist = list.reversed;
  print(revlist);

  ///7
  ///runtimeType => A representation of the runtime type of the object
  print(list.runtimeType);

  ///8 
  ///single => checks that this iterable has only one element and return that element
  print(list.single);

  ///if list will contain more than one item throw Unhandled exception:
  ///Bad state: Too many elements
  

  ///9
  ///iterator => A new iterator that allows iterating the elements of this Iterable.
  var newList = list.iterator;

}