class Greeter {
  final String name;
  Greeter(this.name);

  void greet(String who) => print('$name says: Hello $who!');
}

void main(List<String> args) {
  final m = Greeter('Ali');
  final g = m.greet; //Here g hold a function pointer to m.greet
  g('Hasan'); // invoke function using function pointer g

  //calling foreach on an iterable by passing it a function pointer
  ['Hasan', 'Asad', 'Adbi'].forEach(m.greet);

  ['Hasan', 'Asad', 'Adbi'].forEach((element) => g(element));

}
