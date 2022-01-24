import 'dart:io';

/*
 *
 *  +
    ++
    +++
    ++++
    +++++
    ++++++
    +++++++
    ++++++++
    +++++++++
    ++++++++++
 */
main(){
  var n = 10;
  for(var i=0;i<n;i++){
    for(var j=0;j<n;j++){
      if(i>=j){
        stdout.write('+');
      }else{
        stdout.write(' ');
      }
    }
    print('');
  }
}
