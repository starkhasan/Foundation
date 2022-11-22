
void main(){
  var list = [11, 22, 44, 33, 55];
  sortList(item: list);
  var key = 22;
  var index = binarySearch(list: list, p: 0, r: list.length-1, key: key);
  print('Index => $index');
}
int binarySearch({required List<int> list, required int p, required int r, required int key}){
  if(p<=r){
    var mid = (p+r) ~/ 2;
    if(list[mid] == key){
      return mid;
    }
    if(list[mid] > key){
      return binarySearch(list: list, p: p, r: mid-1, key: key);
    }
    return binarySearch(list: list, p: mid+1, r: r, key: key);
  }
  return -1;
}
///this method is used to sort the list
void sortList({required List<int> item}){
  for(var j=1;j<item.length;j++){
    var key = item[j];
    var i = j-1;
    while(i >= 0 && item[i] > key){
      item[i+1] = item[i];
      i-=1;
    }
    item[i+1] = key;
  }
}
///Method to print the list
void printList({required List<int> list}){
  for(var item in list){
    print(item);
  }
}