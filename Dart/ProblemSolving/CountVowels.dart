main(){
  var data = 'ali hasan';
  var countVowels = 0;
  var countConsonent = 0;
  data = data.replaceAll(' ','');
  for(var i=0;i<data.length;i++){
    var tempData = data[i].toUpperCase();
    if(tempData == 'A' || tempData == 'E' || tempData == 'I' || tempData == 'O' || tempData == 'U'){
      countVowels++;
    }else {
      countConsonent++;
    }
  }
  print('Total Vowels = $countVowels\nTotal Consonents = $countConsonent');
}
