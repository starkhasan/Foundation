main(){
  var data = "Ali Hasan";
  print('Simple Data = $data');
  data = data.split('').reversed.join('');
  print(data);


  //Using Loops Reverse the String
  for(var i=data.length-1;i>=0;i--){
    print(data[i]);
  }
}
