String reverse(String str){
  if(str.length == 1){
    return str[0];
  }else{
      var tempStr = str[str.length-1] + reverse(str.substring(0,str.length-1));
      return tempStr;
  }
}

main(){
  var result = reverse('ali hasan');
  print('Factorial = $result');
}
