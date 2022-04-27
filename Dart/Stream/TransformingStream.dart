import 'dart:io';

///method for transforming the Stream<int> into Stream<String>
Stream<String> getStringStream(Stream<int> intStream) async* {
  String data = '';
  await for (final item in intStream) {
    data += item.toString();
  }
  yield data;
}

void main() {
  print('Fectching Data .............');

  ///Stream of int
  var intStream =
      Stream<int>.periodic(const Duration(seconds: 1), (item) => item)
          .map((event) => event + 2)
          .take(10);

  ///transorming Stream of int to Stream to String
  getStringStream(intStream).listen((event) => stdout.write('$event \n'));
}
