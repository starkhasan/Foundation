import 'dart:io';

main(){
  var str = 'ali hasan';
  //Simple manually way
  for(var i=str.length-1; i >= 0; i--){
    stdout.write(str[i]);
  }
}
