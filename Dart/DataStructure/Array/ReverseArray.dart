//In Place Algorithm
void reverseInPlace(List<int> array){
  var n = array.length;
  var length = array.length - 1;
  if(n%2 == 0){
    n = n~/2 - 1;
  } else {
    n = n~/2;
  }
  for (var i = 0; i <= n; i++) {
    var temp = array[i];
    array[i] = array[length - i];
    array[length - i] = temp;
  }
}

///Using Extra Space
List reverse(List<int> array){
  var temp = [];
  for (var i = array.length - 1; i >= 0; i--) {
    temp.add(array[i]);
  }
  return temp;
}

void main() {
  var array = <int>[1, 2];
  print(array);
  //reverseInPlace(array);
  print(reverse(array));
}