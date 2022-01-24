import 'dart:io';
/*
 * Dart does not have character types
 *
 * To use a String as a char user 'your_str'.codeUnitAt(0)
 *
 * To covert a code to a string you use String constructor String.fromCharCode
 *
 */
void main(){
  var n = 5;
  var chr = 'A'.codeUnitAt(0);
  for(var i=0;i<n;i++){
    for(var j=0;j<n;j++){
      if(j <= i){
        stdout.write(String.fromCharCode(chr));
        chr+=1;
      }else{
        stdout.write(' ');
      }
    }
    print('');
  }

  chr = 'A'.codeUnitAt(0);

  print('\n\nAnother Example\n');
  for(var i=0;i<n;i++){
    for(var j=0;j<n;j++){
      if(j <= i){
        stdout.write(String.fromCharCode(chr));
      }else{
        stdout.write(' ');
      }
    }
    chr+=1;
    print('');
  }

}
