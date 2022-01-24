import 'dart:io';
/*
 *
 *  +
    ++
    +++
    ++++
    +++++
    ++++
    +++
    ++
    +
 */
void main(){
  var n = 5;
  for(var i=0;i < (n*2 -1) ;i++){
    for(var j=0;j<n;j++){
      if(i <= n-1){
        if(i >= j){
          stdout.write('+');
        }else{
          stdout.write(' ');
        }
      }else{
        if(j < (n+n-i-1)){
          stdout.write('+');
        }else{
          stdout.write(' ');
        }
      }
    }
    print('');
  }
}
