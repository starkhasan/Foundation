void main(){
  var year = 2020;
  var result = checkLeapYear(year);
  result ? print('Yes Leap Year') : print('No Leap Year');
}
bool checkLeapYear(int year){
  if(year%4 == 0)
     return true;
  else if(year %100 == 0)
     return false;
  else if(year % 400 == 0)
     return true;
  else
     return false;
  
}