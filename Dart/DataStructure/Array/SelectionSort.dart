void selectionSort(List<int> array){
  var n = array.length;
  for (var i = 0; i < n - 1; i++) {
    var pos = i;
    var key = array[i];
    for (var j = i+1; j < n; j++) {
      if(key > array[j]){
        key = array[j];
        pos = j;
      }
    }
    key = array[i];
    array[i] = array[pos];
    array[pos] = key;
  }
}

void printArray(List<int> array){
  for(var item in array){
    print(item);
  }
}

void main() {
  var array = <int>[5,4,7,1,3,9,8];
  print("Before Sorting");
  printArray(array);
  selectionSort(array);
  print("After Sorting");
  printArray(array);
}