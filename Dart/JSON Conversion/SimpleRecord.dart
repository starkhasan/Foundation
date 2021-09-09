import 'dart:convert';

class SimpleRecord {
  Results results;

  SimpleRecord(this.results);

  SimpleRecord.fromJson(Map<String, dynamic> json)
      : results = Results.fromJson(json['results']);
}

class Results {
  String totalRecordCount;
  String result;
  List<Records> records;

  Results(this.totalRecordCount, this.records, this.result);

  Results.fromJson(Map<String, dynamic> json)
      : totalRecordCount = json['TotalRecordCount'],
        records =
            List<Records>.from(json['Records'].map((x) => Records.fromJson(x))),
        result = json['Result'];
}

class Records {
  String code;
  String address;
  String contact_phone;

  Records(this.code, this.address, this.contact_phone);

  Records.fromJson(Map<String, dynamic> json)
      : code = json['code'],
        address = json['address'],
        contact_phone = json['contact_phone'];
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
