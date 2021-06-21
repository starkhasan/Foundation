void main() {
  RegExp regExp = RegExp(r"^[0-9]+(\.[0-9]{1,2})?$");
  var _listDecimalNumber = [
    12.43,
    34.54,
    41.43,
    45.00,
    45.123,
    92929.12,
    123.12,
    3.1,
    76,
    23.3421,
    10.112
  ];

  var _totalSum = 0.0;
  for (var item in _listDecimalNumber) {
    if(regExp.hasMatch(item.toString()))
      _totalSum += item;
  }

  print('Total Summmation is ${_totalSum.toStringAsFixed(2)}');
}
