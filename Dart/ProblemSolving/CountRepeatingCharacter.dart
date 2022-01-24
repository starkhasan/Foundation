main(){
  var data = 'MISSISSIPPI';
  var map = Map<String,int>();
  for(var i = 0; i < data.length; i++){
    var tempData = data[i];
    if(map.containsKey(tempData)){
      var temp = map[tempData]!;
      map[tempData] = temp+1;
    }else{
      map[tempData] = 1;
    }
  }

  map.forEach((key, value){
    print('$key -> $value');
  });
}
