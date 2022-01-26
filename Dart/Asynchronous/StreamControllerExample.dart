import 'dart:async';

void main(){
  final streamController = StreamController<DateTime>();
  Timer.periodic(const Duration(seconds: 1), (timer){
    streamController.add(DateTime.now());
  });

  streamController.stream.listen((event){
    print(event);
  });

  /*
   * We can also cancel the streamController using the streamController.cancel()
   * 
   * we can pause the StreamController using streamController.pause()
   *
   * we can resume the StreamController using the streamController.resume()
   */
}
