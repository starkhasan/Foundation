void main(){
  var name = "Ali hasan";
  //Here we are declaring a variable whose name is name and assigning the 'Ali
  // hasan' due to the type inference the dart automatically detect the
  //type of the variable at compile time

  /*
   * Here we are performing the Upper case operation on the string at runtime time
   * it is not storing any of updated string value to any memory location
   */
  print(name.toUpperCase());

  /*
   * Now if we agin the name we will the previous value of name variable, ie alter the name value
   * it shows the string are immutable
   */
  print(name);

  /*
   * to change the value of the string we have to reasign the new value to the variable
   */
  name = name.toUpperCase();
  print(name);
}
