int binarySearch(List<int> array, int p, int q, int k){
  if(p <= q){
    int mid = p+q ~/ 2;
    if(array[mid] == k){
      return mid;
    }
    if(k < array[mid]){
      return binarySearch(array, p, mid - 1, k);
    }
    return binarySearch(array, mid + 1, q, k);
  } else {
    return -1;
  }
}

void main(){
  var array = [3,4,5,6,7,8,9,10];
  var k = 5;
  var result = binarySearch(array, 0, array.length - 1, k);
  if(result >= 0){
    print("$k is present in the array");
  } else{
    print("Item doesn't exist");
  }
}