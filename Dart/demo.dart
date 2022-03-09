void main(){
  List<int> listNumber = List.generate(20, (index) => index+1);
  var listString = listNumber.map((item) => item.toString());
  for(var item in listString){
    print(item.runtimeType);
  }
}
