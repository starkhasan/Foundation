import 'dart:convert';

class CountryData {
  int symbolsReturned;
  String base;
  Map data;

  CountryData({required this.symbolsReturned,required this.base,required this.data});

  factory CountryData.fromJson(Map<String, dynamic> json){
    return CountryData(
      symbolsReturned: json['symbols_returned'],
      base: json['base'],
      data: json['data']
    );
  }

  Map<String, dynamic> toJson() =>
      {'symbols_returned': symbolsReturned, 'base': base, 'data': data};
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

  var response = CountryData.fromJson(jsonDecode(data));
  print(response.runtimeType);
  //var jsonData = json.encode(response); // we can do it
  var jsonData = jsonEncode(response);
  print(jsonData);
}

//jsonDecode(jsonString)  it actually accept a jsonString and convert it into Map<String, dynamic>
//jsonEncode(Object)  it actually accept a object and convert it into the Json String simply..
