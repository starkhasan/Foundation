optionalPositionalArgument([String? name,int? value]){
  print(name);
  value == null
  ? print('The Integer value is null')
  : print('Value = $value');
}
void main(){
  optionalPositionalArgument('Ali Hasan');
}
