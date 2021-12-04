void main() {
  var regEx = RegExp(r'^([a-zA-Z0-9_\.\-]*)@([a-zA-Z0-9]*)\.([a-zA-Z]{2,5})$');
  var str = 'alihasan226@gmail.com';
  if (regEx.hasMatch(str)) {
    print('Email is Valid');
  } else {
    print('Email is Invalid');
  }
}
