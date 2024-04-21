///Count Stream
Stream<int> countStream(int number) async* {
  for(var i=1;i <= number ;i++){
    yield i;
  }
}

///Stream Sum
Future<int> sumStream(Stream<int> stream) async {
  int sum = 0;
  await for(var item in stream){
    sum+=item;
  }
  return sum;
}

void main() async {
  //Initialize a stream of integer 0-9
  Stream<int> stream = countStream(10);

  ///Computer the sum of the stream of integer
  int sum = await sumStream(stream);
  ///print the sum
  print('Summation => $sum');
}
