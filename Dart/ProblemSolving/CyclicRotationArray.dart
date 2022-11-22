///Array Rotation
import 'dart:io';
void main(){
  var list = <int>[1, 2, 3, 4, 5, 6, 7];
  var count = 12;
  arrayRotation(array: list, count: count);
  printArray(array: list);
}
///program to perform thearray rotation
void arrayRotation({required List<int> array, required int count}){
  int k = 0;
  if(count != 0){
    count = count % array.length;
    print('Count = $count');
    while(k < count){
      var temp = array[0];
      for(var i=1;i<array.length;i++){
        array[i-1] = array[i];
      }
      array[array.length-1] = temp;
      k+=1;
    }
  }
}

void printArray({required List<int> array}){
  for(var item in array){
    stdout.write('$item ');
  }
  print('');
}