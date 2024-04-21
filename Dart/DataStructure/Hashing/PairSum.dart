int pairSum(List<int> array, int k){
  var map = <int, int>{};
  var pair = 0;
  for(var item in array){
    var otherNum = k - item;
    if(map.containsKey(otherNum)){
      pair = pair + map[otherNum]!;
    } else if(map.containsKey(item)){
      var count = map[item]!;
      map[item] = count + 1;
    } else {
      map[item] = 1;
    }
  }

  return pair;
}


//naive Approach
int pairSum2(List<int> array, int k){
  var result = 0;
  for (var i = 0; i < array.length - 1; i++) {
    for (var j = i+1; j < array.length; j++) {
      if(array[i] + array[j] == k){
        result+=1;
      }
    }
  }
  return result;
}



void main() {
  var array = <int>[10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1];
  var k = 11;
  var result = pairSum(array, k);
  print("Total pair => $result");
}