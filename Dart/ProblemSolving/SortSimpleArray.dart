
//On Writing AN Algorithm
insertionSort(List<int> list){
  for(var j=1;j<list.length;j++){
    var key = list[j];
    var i = j-1;
    while(i>=0 && list[i] > key){
      list[i+1] = list[i];
      i-=1;
    }
    list[i+1] = key;
  }
}


sortbyPredefinedMethod(List<int> list) => list.sort();


void main(){
  var newList = List.generate(10, (item) => item+1);
  newList.shuffle();

  print(newList);
  insertionSort(newList);
  //Sorting the list using insertion sorting algorithm
  print(newList);
}
