int largestItem(List<int> array){
  var largest = double.minPositive.toInt();
  var second = double.minPositive.toInt();
  for(var item in array){
    if(largest < item){
      second = largest;
      largest = item;
    } else if(second < item && item < largest){
      second = item;
    }
  }
  return second;
}

void printArray(List<int> array){
  for(var item in array){
    print(item);
  }
}

void main() {
  var array = <int>[9,8,7,6,5,4,3,2,1];
  var result = largestItem(array);
  print("Second Largest Item = $result");
}