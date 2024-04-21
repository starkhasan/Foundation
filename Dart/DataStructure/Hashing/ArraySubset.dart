bool isSubset(List<int> array1, List<int> array2){
  var map = <int, int>{};
  for(var item in array1){
    map[item] = 1;
  }
  for(var item in array2){
    if(map[item] == null){
      return false;
    }
  }
  return true;
}



void main(){
  var array1 = <int>[1,2,3,4,5,6];
  var array2 = <int>[1,2,7];
  if(isSubset(array1, array2)){
    print("Yes, Array2 is the subset of Array1");
  } else {
    print("No, Array2 is not the subset of Array1");
  }
}