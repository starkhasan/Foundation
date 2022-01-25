import 'dart:convert';

class CountryResponse{
  int id;
  String name;
  int countryId;
  String countryCode;
  String stateCode;
  String? type;
  String latitude;
  String longitude;

  CountryResponse({
    required this.id,
    required this.name,
    required this.countryId,
    required this.countryCode,
    required this.stateCode,
    required this.type,
    required this.latitude,
    required this.longitude
  });


  factory CountryResponse.fromJson(Map<String, dynamic> json){
    return CountryResponse(
      id: json['id'],
      name: json['name'],
      countryId: json['country_id'],
      countryCode: json['country_code'],
      stateCode: json['state_code'],
      type: json['type'],
      latitude: json['latitude'],
      longitude: json['longitude']
    );
  }

  Map<String, dynamic> toJson(){
    return {
      'id': id,
      'name': name,
      'country_id': countryId,
      'country_code': countryCode,
      'state_code': stateCode,
      'type': type,
      'latitude': latitude,
      'longitude': longitude
    };
  }

}

void main(){
  var data = """[
    {
        "id": 3901,
        "name": "Badakhshan",
        "country_id": 1,
        "country_code": "AF",
        "state_code": "BDS",
        "type": null,
        "latitude": "36.73477250",
        "longitude": "70.81199530"
    },
    {
        "id": 3871,
        "name": "Badghis",
        "country_id": 1,
        "country_code": "AF",
        "state_code": "BDG",
        "type": null,
        "latitude": "35.16713390",
        "longitude": "63.76953840"
    },
    {
        "id": 3875,
        "name": "Baghlan",
        "country_id": 1,
        "country_code": "AF",
        "state_code": "BGL",
        "type": null,
        "latitude": "36.17890260",
        "longitude": "68.74530640"
    },
    {
        "id": 3884,
        "name": "Balkh",
        "country_id": 1,
        "country_code": "AF",
        "state_code": "BAL",
        "type": null,
        "latitude": "36.75506030",
        "longitude": "66.89753720"
    },
    {
        "id": 3872,
        "name": "Bamyan",
        "country_id": 1,
        "country_code": "AF",
        "state_code": "BAM",
        "type": null,
        "latitude": "34.81000670",
        "longitude": "67.82121040"
    },
    {
        "id": 3892,
        "name": "Daykundi",
        "country_id": 1,
        "country_code": "AF",
        "state_code": "DAY",
        "type": null,
        "latitude": "33.66949500",
        "longitude": "66.04635340"
    },
    {
        "id": 3899,
        "name": "Farah",
        "country_id": 1,
        "country_code": "AF",
        "state_code": "FRA",
        "type": null,
        "latitude": "32.49532800",
        "longitude": "62.26266270"
    },
    {
        "id": 3889,
        "name": "Faryab",
        "country_id": 1,
        "country_code": "AF",
        "state_code": "FYB",
        "type": null,
        "latitude": "36.07956130",
        "longitude": "64.90595500"
    },
    {
        "id": 3870,
        "name": "Ghazni",
        "country_id": 1,
        "country_code": "AF",
        "state_code": "GHA",
        "type": null,
        "latitude": "33.54505870",
        "longitude": "68.41739720"
    },
    {
        "id": 3888,
        "name": "Ghōr",
        "country_id": 1,
        "country_code": "AF",
        "state_code": "GHO",
        "type": null,
        "latitude": "34.09957760",
        "longitude": "64.90595500"
    },
    {
        "id": 3873,
        "name": "Helmand",
        "country_id": 1,
        "country_code": "AF",
        "state_code": "HEL",
        "type": null,
        "latitude": "39.29893610",
        "longitude": "-76.61604720"
    },
    {
        "id": 3887,
        "name": "Herat",
        "country_id": 1,
        "country_code": "AF",
        "state_code": "HER",
        "type": null,
        "latitude": "34.35286500",
        "longitude": "62.20402870"
    },
    {
        "id": 3886,
        "name": "Jowzjan",
        "country_id": 1,
        "country_code": "AF",
        "state_code": "JOW",
        "type": null,
        "latitude": "36.89696920",
        "longitude": "65.66585680"
    },
    {
        "id": 3902,
        "name": "Kabul",
        "country_id": 1,
        "country_code": "AF",
        "state_code": "KAB",
        "type": null,
        "latitude": "34.55534940",
        "longitude": "69.20748600"
    },
    {
        "id": 3890,
        "name": "Kandahar",
        "country_id": 1,
        "country_code": "AF",
        "state_code": "KAN",
        "type": null,
        "latitude": "31.62887100",
        "longitude": "65.73717490"
    },
    {
        "id": 3879,
        "name": "Kapisa",
        "country_id": 1,
        "country_code": "AF",
        "state_code": "KAP",
        "type": null,
        "latitude": "34.98105720",
        "longitude": "69.62145620"
    }
  ]
  """;
  //Converting the Json String to Response Instance
  var response = List<CountryResponse>.from(jsonDecode(data).map((item) => CountryResponse.fromJson(item)));
  print(response);
  //To Convert the Data back to the Json String
  var newData = jsonEncode(List<dynamic>.from(response.map((x) => x.toJson())));
  print(newData);
}
