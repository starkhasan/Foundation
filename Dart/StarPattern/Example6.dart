import 'dart:io';
void main(){
  var n = 9;
  for(var i=0;i<n;i++){
    for(var j=0;j<n;j++){
      if(i>=j){
        stdout.write(i+1);
      }else{
        stdout.write(' ');
      }
    }
    print('');
  }
}
