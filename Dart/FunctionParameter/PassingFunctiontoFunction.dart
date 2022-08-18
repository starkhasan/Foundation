
void main() {
  var list = List.generate(10, (index) => index+1);
  ///pass function as a parameter to another function
  list.forEach(printFunction);
}
void printFunction(int element) => print(element);
