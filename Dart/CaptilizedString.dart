void main(){
  var data = 'ali hasan';
  data = captilizedString(data);
  print(data);
}
String captilizedString(String name){
  name = name[0].toUpperCase() + name.substring(1);
  return name;
}
