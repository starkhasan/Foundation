void main(){
  var userString = 'this is my name';
  print('Extension Method Make UpperCase => ${userString.makeUpper}');
  print('Extension Method Make LowerCase => ${userString.makeLower()}');
  print('Extension Method Make Captialized => ${userString.makeCaptialized()}');
}

extension StringExtension on String{
  String get makeUpper => this.toUpperCase();

  String makeLower() => this.toLowerCase();

  String makeCaptialized() {
    var data = this;
    data = data[0].toUpperCase() + data.substring(1);
    return data;
  }
}
