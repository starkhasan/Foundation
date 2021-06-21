void main(){
  var number = 12;
  print(number.isEven);
  var result = checkPrime(number);
  result ? print('Prime Number') : print('Not Prime');
}
bool checkPrime(int number){
  if(number < 2)
     return false;
  else{
    for(var i=2;i<=number/2;i++){
      if(number%i == 0)
         return false;
    }
    return true;
  }
}