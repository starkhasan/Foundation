//Building a string programatically
//Using StringBuffer
void main(){
  var sb = StringBuffer();
  sb
    ..write('Use a StringBuffer for ')
    ..writeAll(['efficient','string'],' ')
    ..write('.');
  var result = sb.toString();
  print(result.runtimeType);
}
