import 'dart:convert';

class SimpleRecord {
  Results results;

  SimpleRecord({required this.results});

  factory SimpleRecord.fromJson(Map<String, dynamic> json){
    return SimpleRecord(
        results: Results.fromJson(json['results'])
    );
  }
}

class Results {
  String totalRecordCount;
  String result;
  List<Records> records;

  Results({required this.totalRecordCount,required this.records,required this.result});

  factory Results.fromJson(Map<String, dynamic> json){
    return Results(
      totalRecordCount: json['TotalRecordCount'],
      records: List<Records>.from(json['Records'].map((x) => Records.fromJson(x))),
      result: json['Result']
    );
  }
}

class Records {
  String code;
  String address;
  String contact_phone;

  Records({required this.code,required this.address,required this.contact_phone});

  factory Records.fromJson(Map<String, dynamic> json){
    return Records(
      code: json['code'],
      address: json['address'],
      contact_phone: json['contact_phone']
    );
  }
}

void main(List<String> args) {
  var data = '''{
   "results":{
      "TotalRecordCount":"1",
      "Records":[
         {
            "code":"PCK_34333338365C93E2D50DB9C",
            "address":"1 AV KHEIREDDINE PACHA Imm Pacha centre BLOC B tunis Tunis 1000",
            "contact_phone":"99608258"
         }
      ],
      "Result":"OK"
   }
}''';
  var response = SimpleRecord.fromJson(jsonDecode(data));
  var resultResponse = response.results;
  print('\nResult -> ${resultResponse.result}');
  print('TotalRecord -> ${resultResponse.totalRecordCount}');
  for (var item in resultResponse.records) {
    print('Code -> ${item.code}');
    print('Address -> ${item.address}');
    print('Contact Phone -> ${item.contact_phone}');
  }
}
