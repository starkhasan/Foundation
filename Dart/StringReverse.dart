void main(){
  var nameStr = "Ali Hasan";
  print(nameStr);
  /*
   * We can Reverse the String using split and reversed join function
   */
  nameStr = nameStr.split('').reversed.join('');
  print(nameStr);

  /*
   * Working of the reversed.join('')
   *
   * reversed => it is a method of list to reversed the list
   * join => it is a function of the list to convert each element to a String and concatenates to the end of strings.
   *
   */

  var result = reverseExplicit(nameStr);
  print(result);
}

//Reverse String
String reverseExplicit(String newStr){
  String result = "";
  for(var i=newStr.length - 1;i>=0;i--){
    result+=newStr[i];
  }
  return result;
}
