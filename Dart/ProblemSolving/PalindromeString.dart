main(){
  var firstStr = 'ali hasan';
  var secondStr = firstStr.split('').reversed.join('');
  if(firstStr == secondStr){
    print('Both Strings are Palidrome');
  }else{
    print('Both Strings are not Palindrome');
  }
}
