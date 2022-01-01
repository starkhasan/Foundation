enum MyEnum { one, two, three }
void main(List<String> args) {
  //you can get the string value of each enum
  print('${MyEnum.one.name} and its type is ${MyEnum.one.name.runtimeType}');

  //you can also lookup an enum by its name
  // and it is case sensitive ( that is two and Two are different )
  print(MyEnum.values.byName('two') == MyEnum.two);

  //you can get a map of all name-value pairs
  var mapValues = MyEnum.values.asMap(); // it return an index-value map
  var mapNamedValues = MyEnum.values.asNameMap(); // it return a named-value map
  print(mapValues);//type ListMapView<MyEnum>
  print(mapNamedValues);//typed InternalLinkedHashMap<String,MyEnum>
}
