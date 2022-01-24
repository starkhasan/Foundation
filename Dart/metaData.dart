class Television {
  @Deprecated('From Version 2.4 this method has been deprecated, try using turnOn method')
  void activate() {
    turnOn();
  }

  void turnOn() {
    print('Television Turn ON');
  }
}

void main(List<String> args) {
  var obj = Television();
  obj.turnOn();
}
