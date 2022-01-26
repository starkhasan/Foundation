void main(){
  var data = getIterableData();
  print(data);
  print(data.runtimeType);
}

Iterable<int> getIterableData() sync*{
  for(var i=0;i<10;i++){
    if(i.isEven) yield i;
  }
}
