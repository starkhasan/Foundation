void main() async{
  var data = getNumber();
  var sumData = await sumStream(data);
  print(sumData);
}

Future<int> sumStream(Stream<int> stream) async{
  var sum = 0;
  await for(var item in stream){
    print(item);
    sum+=item;
  }
  return sum;
}

Stream<int> getNumber() async* {
  for(var i=0;i<20;i++){
    if(i.isEven) yield i;
  }
}
