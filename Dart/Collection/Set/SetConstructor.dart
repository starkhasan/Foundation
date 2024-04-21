void main() {
  ////A Collection of object in which each object can occur only once.


  ///Iterating over elements of a set may be either unordered or ordered in some way.
  ///1. HashSet is unordered, which means that its iteration order is unspecified.
  ///2. LinkedHashSet => iterates in insertion order of its element
  ///3. SplayTreeSet => iterates the element in sorted order.
  ///
  var set = <int>{1,2,3,4,5,6,7,6};//Declaring a set using Set Literal

  ///Constructor of set
  var emptySet = Set();

  var list = List.generate(10, (element) => element+1);
  var setFrom = Set.from(list);

  //Creates an empty identity Set
  var setIdentity = Set.identity();

  //Creates a Set from element
  var setOf = Set.of(list);

  ///Creates an unmodified Set from elements.
  var setUnmodified = Set.unmodifiable(list);



}
