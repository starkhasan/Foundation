class Performer {
  void perform() => print('performing');
}

mixin Dancer {
  void perform() => print('Dance...Dance....');
}
mixin Singer {
  void perform() => print('Sing...Sing...Sing....');
}

class Musician extends Performer with Dancer, Singer {
  void showTimer() => perform();
}

void main() {
  var obj = Musician();
  obj.showTimer();
}
