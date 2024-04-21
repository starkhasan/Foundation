void leaderArray(List<int> array){
  var max = double.minPositive.toInt();
  for (var i = array.length - 1; i >= 0; i--) {
    if(max < array[i]){
      max = array[i];
      print(max);
    }
  }
}

void main() {
  var array = <int>[1, 2, 3, 4, 5, 2];
  leaderArray(array);
}