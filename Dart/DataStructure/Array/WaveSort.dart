void waveSort(List<int> array){
  var n = array.length;
  for (var i = 0; i < n-1; i+=2) {
    var temp = array[i];
    array[i] = array[i+1];
    array[i+1] = temp;
  }
}

void main(){
  var array = <int>[10, 90, 49, 2, 1, 5, 23];
  print("Before Sorting => $array");
  waveSort(array);
  print("After Sorting $array");
}