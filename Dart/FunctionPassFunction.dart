void main(List<String> args) {
  var listNumber = List.generate(10, (index) => index + 1);

  //Passing a Function as parameter to another function
  listNumber.forEach(printElement);
}

void printElement(int element) {
  print(element);
}
