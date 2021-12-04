void main(List<String> args) {
  var regExp = RegExp(r"\d+");
  var email = 'alihasan@gmail.com';
  if (email.contains(regExp)) {
    print('YES it contains numbers');
  } else {
    print('NO it does not contain any numberin the string');
  }
}
