void main() {
  /**
   * Regular Expression for Strong Password
   * It Should contain atleast one small and one Capital and and Digit in Password
   */
  var regEx = RegExp(r'^((?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]{8,})$');
  var str = '0saAn';
  if (regEx.hasMatch(str)) {
    print('Password is Valid');
  } else {
    print('Password is Invalid');
  }
}
