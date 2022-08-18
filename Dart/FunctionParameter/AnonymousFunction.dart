///Anonymus Function
/// Most function are named, such as main() or printElement().
/// you can also create a nameless function called an anonymous function, or sometimes a lambda or closure.
void main(){
  ///here (index) function is an anonymous function.
  var list = List.generate(10, (index) => index+1);
  list.forEach((item) => print(item));
}
