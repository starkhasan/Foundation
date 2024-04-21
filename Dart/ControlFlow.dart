void main() {
  ///Sequential Flow
  String name = "AI";
  print(name);

  ///Contitional Flow
  if(name.isNotEmpty){
    print("Name is Empty");
  } else {
    print("Name is not empty");
  }

  ////Iterative Flow
  for(int i=0;i<10;i++){
    print("Hello Madam");
  }


  ///While Loop
  int count = 5;
  while(count > 0){
    print("Hello World!");
    count-=1;
  }

  ///Do While loop
  ///
  print("Example Do While Loop\n");
  count  = 5;
  do {
    print(count);
    count-=1;
  } while(count > 0);

  print("Using of break statement");
  ///break statement is a control flow statement used in programming to terminate the execution of loop  or switch statement
  var numberList = List.generate(10, (element) => element + 1);
  for(var item in numberList){
    if(item == 5){
      break;
    } else {
      print(item);
    }
  }

  ////continue is used to skip the current iteration and jump to the next iteration
  /// continue statement can only be used with loops
  print("Using a continue statement");
  for(var item in numberList){
    if(item == 5){
      continue;
    } else {
      print(item);
    }
  }
}
