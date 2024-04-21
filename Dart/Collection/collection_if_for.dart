void main() {

  ////Collection if
  ///
  var promoActive = false ;
  var nav = ['Home', 'Furniture', 'Plants', if (promoActive) 'Outlet'];
  print(nav);

  ///Collection for to manipulate the items of a list before adding  them to another list
  var listOfInts = [1, 2, 3];
  var listOfStrings = ['#0', for (var i in listOfInts) '#$i'];

  print(listOfStrings);
}
