import 'dart:convert';
import 'dart:io';

class CountryList {
  int id;
  String name;
  int countryId;
  String countryCode;
  String stateCode;
  String? type;
  String? latitude;
  String? longitude;

  CountryList(this.id, this.name, this.countryId, this.countryCode, this.stateCode,
      this.type, this.latitude, this.longitude);

  CountryList.fromJson(Map<String, dynamic> json)
      : id = json['id'],
        name = json['name'],
        countryId = json['country_id'],
        countryCode = json['country_code'],
        stateCode = json['state_code'],
        type = json['type'],
        latitude = json['latitude'],
        longitude = json['longitude'];
}


void main() async {
  var fileContent = new File('JsonInput.json');
  if (await fileContent.exists()) {
    print('YES!! File is Exist');
    var content = await fileContent.readAsString();
    var response = List<CountryList>.from(jsonDecode(content).map((x) => CountryList.fromJson(x)));
    for(var item in response){
      print('${item.id} -> ${item.name}');
    }
  } else {
    print('NO!! File is not Exist');
  }
}
