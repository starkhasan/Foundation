optionalDefaultArgument({String? name,int? value = 20}){
  print(name);
  value == null
  ? print('The Integer value is null')
  : print('Value = $value');
}
void main(){
  optionalDefaultArgument(name: 'Ali Hasan');
}
