void main(){
  var listItem = [1,2,3,4,5,6,7,8,9,10];

  var result = listItem.fold(10, (previous, item) => previous + item);
  print('Total Sum => $result');
}
