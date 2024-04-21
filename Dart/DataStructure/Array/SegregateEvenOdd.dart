void segregate(List<int> array){
  var j = -1;
  var n = array.length;
  for (var i = 0; i < n; i++) {
    if(array[i] % 2 == 0){
      j+=1;
      var temp = array[j];
      array[j] = array[i];
      array[i] = temp;
    }
  }
}

void main() {
  var array = <int>[7, 2, 9, 4, 6, 1, 3, 8, 5];
  print("Before Segregation => $array");
  segregate(array);
  print("After Segregation => $array");
}