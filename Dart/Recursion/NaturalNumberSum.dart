///Write a progam to sum of n natural number using recursion
int naturalNumberSum({required int number}){
  if(number == 1){
    return number;
  }else{
    return number + naturalNumberSum(number: number-1);
  }
}
void main(){
  var number = 10;
  var result = 0;
  ///Iterative Approach
  for(var i=1;i<=10;i++){
    result+=i;
  }
  print('Addition = $result');

  ///Recursive Approach
  var recurResult = 0;
  recurResult = naturalNumberSum(number: number);
  print('Recursive Addition = $recurResult');
}