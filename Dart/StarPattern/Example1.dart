import 'dart:io';
/*
 *
 *  *****
     ****
      ***
       **
        *
 */
void main(){
  var n = 5;
  for(var i=0;i<n;i++){
    for(var j=0;j<n;j++){
      if(i<=j){
        stdout.write('*');
      }else{
        stdout.write(' ');
      }
    }
    print('');
  }
}
