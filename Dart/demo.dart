import 'dart:io';
import 'dart:convert';

class AllState {
  int id;
  String name;
  int countryId;
  String countryCode;
  String stateCode;
  String? type;
  String? lat;
  String? lng;

  AllState(this.id, this.name, this.countryId, this.countryCode, this.stateCode,
      this.type, this.lat, this.lng);

  AllState.fromJson(Map<String, dynamic> json)
      : id = json['id'],
        name = json['name'],
        countryId = json['country_id'],
        countryCode = json['country_code'],
        stateCode = json['state_code'],
        type = json['type'],
        lat = json['latitude'],
        lng = json['longitude'];
}

main(List<String> args) async {
  var file = File('JsonInput.json');
  if (await file.exists()) {
    var data = await file.readAsString();
    var response = List<AllState>.from(
        jsonDecode(data).map((item) => AllState.fromJson(item)));
    for (var item in response) {
      print('Id -> ${item.id}\nName -> ${item.name}\nCountryId ->${item.countryId}\nCountryCode -> ${item.countryCode}\nStateCode -> ${item.stateCode}\nLatitude ${item.lat}\nLongitude -> ${item.lng}\n');
    }
  }
}
