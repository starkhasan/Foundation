int partition(List<int> list,int p,int r){
  var key = list[r];
  var i = p-1;
  for(var j=p;j<r;j++){
    if(list[j] < key){
      i = i + 1;
      var temp = list[i];
      list[i] = list[j];
      list[j] = temp;
    }
  }
  var temp = list[i+1];
  list[i+1] = list[r];
  list[r] = temp;
  return i+1;
}

void quickSort(List<int> list,int p,int r){
  if(p < r){
    var q = partition(list,p,r);
    quickSort(list,p,q-1);
    quickSort(list,q+1,r);
  }
}

void main(){
  var listData = List.generate(20, (item) => item+1);
  listData.shuffle();
  //Perform the QuickSort Algorithm
  quickSort(listData, 0, listData.length-1);
  listData.forEach((item) => print(item));
}
