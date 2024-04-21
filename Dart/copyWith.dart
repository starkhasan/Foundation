///copyWith
/// Instead of mutating or copying an object you can use copyWith() to create a
/// new object with same properties as the original but with some of the values changed.
///
/// Example
/// Let's say you have an object in which you want to change some properties.
/// One way to do is by changing each proerpties at a time like object.prop1 = x
/// object.prop2 = y and so on.
/// This will take a long time if you have more than few properties to change.
/// Then copyWith method comes handy. This method takes all the properties(which need to change)
/// and their correspoding values and returns new object with your desired properties.
/// 
class Bicycle {
  int? speed;
  String? name;

  Bicycle(this.speed, this.name);

  Bicycle copyWith(int speed, String name) => Bicycle(speed, name);

  @override
  String toString() => 'Name => $name Speed $speed';

}
void main() {
  var a = Bicycle(20, 'Hero');
  print(a.hashCode);
  var b = a.copyWith(40, 'Honda');
  print(b.hashCode);
}