String reverseStringIterative({required String str}){
  return str.split('').reversed.join();
}


String reverseRecursion({required String str}){
  if(str.length <= 1){
    return str;
  }else{
    return str.substring(str.length-1) + reverseRecursion(str: str.substring(0,str.length-1));
  }
}

void main(){
  ///Write a program to reverse a String
  var str = 'Interview';
  ///Iterative Approach
  print('Reverse String = ${reverseStringIterative(str: str)}');

  ///Recursive Approach
  print('Reverse String Recursive = ${reverseRecursion(str: str)}');
}