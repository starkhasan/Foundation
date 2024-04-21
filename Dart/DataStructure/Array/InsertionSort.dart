void insertionSort(List<int> array){
  for (var j = 1; j < array.length; j++) {
    var key = array[j];
    var i = j - 1;
    while(i >= 0 && array[i] > key){
      array[i+1] = array[i];
      i-=1;
    }
    array[i+1] = key;
  }
}

void main(){
  var list = [4,3,5,2,6,1,8];
  print("Before Sorting $list");
  insertionSort(list);
  print("After Sorting $list");
}