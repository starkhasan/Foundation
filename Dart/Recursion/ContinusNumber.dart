import 'dart:io';
///Write a progam to print 1 - 100 without using any loop
void printNumber({required int first, required int second}){
  if(first <= second){
    stdout.write('$first ');
    first+=1;
    printNumber(first: first, second: second);
  }
}
void main(){
  printNumber(first: 1, second: 100);
  print('');
}