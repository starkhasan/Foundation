import 'dart:io';
/*
 *      +
       ++
      +++
     ++++
    +++++
     ++++
      +++
       ++
        +
 *
 *
 *
 * 
 */
void main(){
  var n = 5;
  for(var i=0;i < (n*2 -1) ;i++){
    for(var j=0;j<n;j++){
      if(i <= n-1){
        if(j < n-1-i){
          stdout.write(' ');
        }else{
          stdout.write('+');
        }
      }else{
        if(j <= i-n){
          stdout.write(' ');
        }else{
          stdout.write('+');
        }
      }
    }
    print('');
  }
}
