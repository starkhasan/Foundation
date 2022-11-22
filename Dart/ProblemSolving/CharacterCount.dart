///Write a progam to count the character of a string
void main(){
  var name = 'Engineering';
  name = name.replaceAll(' ','').toLowerCase();
  var map = <String,int>{};
  for(var item in name.split('')){
    if(map.containsKey(item)){
      var data = map[item];
      map[item] = data!.toInt() + 1;
    }else{
      map[item] = 1;
    }
  }

  map.forEach((key, value){
    print('$key -> $value');
  });
}
