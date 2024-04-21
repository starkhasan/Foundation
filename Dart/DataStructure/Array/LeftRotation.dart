void rotateLeft(List<int> array, int k){
  var n = array.length;
  k = k % n;
  if(k != 0){
    while(k > 0){
      var first = array[0];
      for (var i = 1; i < n; i++) {
        array[i-1] = array[i];
      }
      array[n-1] = first;
      k-=1;
    }
  }
}

void printArray(List<int> array){
  for(var item in array){
    print(item);
  }
}

void main() {
  var array = <int>[1,2,3,4,5,6,7];
  var k = 2;
  printArray(array);
  rotateLeft(array, k);
  print("\n");
  printArray(array);

}