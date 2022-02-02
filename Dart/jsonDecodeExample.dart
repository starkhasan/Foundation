import 'dart:io';
import 'dart:convert';
void main() async{
  var file = File('userInput.json');
  if(await file.exists()){
    var data = await file.readAsString();
    /*
     * jsonDecode() return a Map<String, dynamic> meaning that you do not know the type of the values until runtime.
     * with this approach you lose most of the statically types language features.
     */
    var jsonData = jsonDecode(data);
    jsonData.forEach((item) => print(item.runtimeType));
  }else{
    print('No File is not Exist');
  }
}
