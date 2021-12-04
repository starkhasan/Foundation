main(List<String> args) {
  var reg = RegExp(r'c(.)t');
  var str = 'The fat cxt sat on the mat  cmt  cat';

  var iteReg = reg.allMatches(str);
  for (var item in iteReg) {
    print(item.start);
  }
}
