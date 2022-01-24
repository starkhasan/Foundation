import 'dart:io';
/*
 *
 *  +++++++++
     +++++++
      +++++
       +++
        +
 */
void main(){
  var n = 5;

  for(var i=0;i<n;i++){
    for(var j=0;j <(2*n-1) ;j++){
      if(j >= i && j < (2*n-i-1)){
        stdout.write('+');
      }else{
        stdout.write(' ');
      }
    }
    print('');
  }

}
