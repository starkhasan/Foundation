void main(){
  var list = [10,12,13,14,15,16,17,18,19,20];
  var first = 10;
  var last = 20;
  ///time complexity n2
  for(var i = first;i<=last;i++){
    if(list.indexOf(i) == -1){
      print('$i missing number');
    }
  }

  ///time complexity n
  var numberSum = 0;
  var temp = 0;
  for(var item in list){
    temp+=item;
  }
  for(var i=first;i<=last;i++){
    numberSum+=i;
  }
  if(numberSum-temp != 0){
    print('Missing number = ${numberSum-temp}');
  }
}
