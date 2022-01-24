import 'dart:io';
/*
 *
 *  1
    12
    123
    1234
    12345
    123456
    1234567
    12345678
    123456789
 */
void main(){
  var n = 9;
  for(var i=0;i<n;i++){
    for(var j=0;j<n;j++){
      if(i>=j){
        stdout.write('${j+1}');
      }else{
        stdout.write(' ');
      }
    }
    print('');
  }
}
