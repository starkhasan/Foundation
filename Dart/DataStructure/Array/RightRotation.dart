void rightRotation(List<int> array, int k){
  var n = array.length;
  k = k % n;
  if(k != 0){
    while(k > 0){
      var last = array[n-1];
      for(var i = n - 2; i >= 0; i--){
        array[i+1] = array[i];
      }
      array[0] = last;
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
  var k = 8;
  printArray(array);
  rightRotation(array, k);
  print("\n");
  printArray(array);
}