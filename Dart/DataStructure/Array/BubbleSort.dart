void bubbleSort(List<int> array){
  var n = array.length;
  for (var i = 0; i < n; i++) {
    for (var j = 0; j < n -1; j++) {
      if(array[j] > array[j+1]){
        var temp = array[j];
        array[j] = array[j+1];
        array[j+1] = temp;
      }
    }
  }
}
void main() {
  var array = <int>[5,4,7,1,3,9,8];
  print("Before Sorting => $array");
  bubbleSort(array);
  print("After Sorting => $array");
}