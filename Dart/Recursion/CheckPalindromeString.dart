String reverseString({required String str}){
  return str.split('').reversed.join('');
}

String recurStringReverse({required String str}){
  if(str.length <= 1){
    return str;
  }else{
    return str.substring(str.length-1) + recurStringReverse(str: str.substring(0, str.length-1));
  }
}

void main(){
  var number = 'ali hasan';
  // //Iterative Approach
  // if(number == reverseString(str: number)){
  //   print('Number is palindrome number');
  // }else{
  //   print('Number is not palindrome');
  // }

  ///Recursive Approach
  var result = recurStringReverse(str: number);
  print(result);
  if(number == result){
    print('Number is palidrome');
  }else{
    print('Number is not palindrome');
  }
}