///Move All Zero
void moveZero(List<int> array){
  var j = 0;
  var i = j - 1;
  for (j; j < array.length; j++) {
    if(array[j] != 0){
      i+=1;
      var temp  = array[j];
      array[j] = array[i];
      array[i] = temp;
    }
  }
}


///Print All Array
void printArray(List<int> array){
  for(var item in array){
    print(item);
  }
}

void main() {
  var array = <int>[1, 2, 0, 0, 0, 3, 6];
  print("Before Arranging Array");
  printArray(array);
  moveZero(array);
  print("After Arranging Array");
  printArray(array);
}