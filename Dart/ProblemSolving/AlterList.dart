void main(){
  var newList = List.generate(50,(item) => item+1);
  //Alter the item inside the list and return new One
  var alterList = newList.map((item) => item%2 == 0 ? true : false);
  print(alterList);

  var alterList1 = newList.map((item) => item+1);
  print(alterList1);
}
