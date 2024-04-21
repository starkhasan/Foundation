///Move All Zero
void moveZeroLeft(List<int> array){
  var i = -1;
  for (var j = 0; j < array.length; j++) {
    if(array[j] == 0){
      i+=1;
      var temp = array[i];
      array[i] = array[j];
      array[j] = temp;
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
  moveZeroLeft(array);
  print("After Arranging Array");
  printArray(array);
}