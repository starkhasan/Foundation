import 'dart:io';
/*
 *
 *      +
       +++
      +++++
     +++++++
    +++++++++
 */
void main(){
  var n = 5;
  for(var i=0;i<n;i++){
    for(var j=0;j < (n*2 - 1);j++){
      if(j >= (n-1-i) && j <= (n-1+i)){
        stdout.write('+');
      }else{
        stdout.write(' ');
      }
    }
    print('');
  }
}
