
//this is the main function of dart program
void main(){
  doStuff();
}
///you can also pass lists or map as default values. The following example defines a function doStuff(), that specifies
/// a default list for a list parameter and a default map for the gifts parameter.
void doStuf({
  List<int> list = const[1,2,3],
  Map<String, String> gifts = const {
    'first': 'paper',
    'second': 'cotton',
    'third': 'leather'
  }
}){
    print('list: $list');
    print('map: $gifts')
}
