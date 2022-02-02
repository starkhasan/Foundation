void main(){
  var listNumber= [0,2,3,4,5,6,7];
  var convertedMap = listNumber.asMap();
  listNumber[7] = 23; //Will show error here because the map formed by asMap function is unmodifiable
  print(listNumber);
}
