void main() {
  var list = List.generate(10, (index) => index+1);
  list.forEach(printFunction);
}
///pass function as a parameter to another function
void printFunction(int element) => print(element);
