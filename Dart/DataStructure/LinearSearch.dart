//Iterative Approach
int searchFirst(List<int> array, int k){
  var result = -1;
  for(var i = 0; i < array.length; i++){
    if(array[i] == k){
      result = i + 1;
      break;
    }
  }
  return result;
}

//Recursive Approach
int search(List<int> array, int index, int k){
  if(index == array.length){
    return -1;
  } else {
    if(array[index] == k){
      return index + 1;
    }
    return search(array, index+1, k);
  }
}

void main(){
  var array = [3,4,2,1,5,6,8,9];
  var k = 1;
  var result = search(array, 0, k);
  if(result >= 0){
    print("$k found at position $result");
  } else {
    print("$k doesn't found in array");
  }
}