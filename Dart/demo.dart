import 'dart:async';

void main() => runApp();

void runApp() {
  var duration = Duration(milliseconds: 3000);
  Timer(duration, _navigation);
}

_navigation() {
  print("This thing is printing after 3 Second");
}
