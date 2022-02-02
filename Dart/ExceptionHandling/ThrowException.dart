import 'dart:io';

void main(){
  var data = stdin.readLineSync();
  var age = int.parse(data!);
  try{
    validateUser(age);
  } catch(e){
    print('Invalid User');
  }
}

validateUser(int age){
  if(age < 18){
    throw FormatException();
  }else{
    print('Welcome User');
  }
}
