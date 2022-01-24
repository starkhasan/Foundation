class ImmutablePoint {
  final double x;
  final double y;
  const ImmutablePoint({required this.x, required this.y});
}

void main(List<String> args) {
  //Some classes provide constant constructor. To create a compile-time constant constructor put the const keyword befoe the constructor name
  var a = const ImmutablePoint(x: 1, y: 1);
  var b = const ImmutablePoint(x: 1, y: 1);
  if (identical(a, b)) {
    print('Both are identical');
    print('\n A Object HasCode => ${a.hashCode}');
    print('\n B Object HasCode => ${b.hashCode}');
  } else {
    print('Both are not identical');
  }
}
