import 'dart:convert';
class CurrencyValue {
  int symbolsReturned;
  String base;
  Map data;//Returning HashMap

  CurrencyValue({required this.symbolsReturned,required this.base,required this.data});

  factory CurrencyValue.fromJson(Map<String, dynamic> json){
    return CurrencyValue(
      symbolsReturned: json['symbols_returned'],
      base: json['base'],
      data: json['data']
    );
  }
}

void main() {
  var data = '''{
  "symbols_returned": 147,
  "base": "USD",
  "data": {
    "AED": 3.672940,
    "AFN": 75.617000,
    "ALL": 109.780000,
    "AMD": 490.740000,
    "ANG": 1.797350,
    "AOA": 313.147500,
    "ARS": 37.864500,
    "AUD": 1.408450,
    "AWG": 1.800000,
    "AZN": 1.702500,
    "BAM": 1.727050,
    "BBD": 2.004250
  }
}''';

  var response = CurrencyValue.fromJson(jsonDecode(data));
  var dataResponse = response.data;
  dataResponse.forEach((key, value) {
    print('$key -> $value');
  });
}
