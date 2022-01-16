void main() {
  //Nested Function
  //A Function Inside another function or Local Function
  
  String performcaptialized(String variable) {
    var tempData = variable[0].toUpperCase() + variable.substring(1);
    return tempData;
  }

  var str = "ali hasan";
  str = performcaptialized(str);
  print(str);
  
}