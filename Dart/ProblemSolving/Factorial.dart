int fact(int num){
  if(num <= 1)
    return 1;
  else
    return num * fact(num-1);
}

main(){
  var result = fact(6);
  print('Factorial = $result');
}
