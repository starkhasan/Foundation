import 'dart:convert';

class DataExample {
  String restrictionType;
  String booleanLogic;
  List<RestrictionsType> restrictions;

  DataExample({required this.restrictionType,required this.booleanLogic,required this.restrictions});
  //converting jsonstring to DataExample Instance
  factory DataExample.fromJson(Map<String, dynamic> json){
    return DataExample(
      restrictionType: json['restriction-type'],
      booleanLogic: json['boolean-logic'],
      restrictions: List<RestrictionsType>.from(json['restrictions'].map((value) => RestrictionsType.fromJson(value)))
    );
  }

  //Convert DataExample instance to Map<String, dynamic>
  Map<String, dynamic> toJson() => {
    'restriction-type': restrictionType,
    'boolean-logic': booleanLogic,
    'restrictions': List<dynamic>.from(restrictions.map((e) => e.toJson()))
  };
}

class RestrictionsType {
  String restrictionType;
  Property property;
  String matchMode;
  String value;

  RestrictionsType({required this.restrictionType,required this.property,required this.matchMode,required this.value});

  factory RestrictionsType.fromJson(Map<String, dynamic> json){
      return RestrictionsType(
        restrictionType: json['restriction-type'],
        property: Property.fromJson(json['property']),
        matchMode: json['match-mode'],
        value: json['value']
      );
  }

  Map<String, dynamic> toJson() => {
    'restriction-type': restrictionType,
    'property': property.toJson(),
    'match-mode': matchMode,
    'value': value
  };
}

class Property {
  String name;
  String type;

  Property({required this.name,required this.type});

  factory Property.fromJson(Map<String, dynamic> json){
    return Property(
      name: json['name'],
      type: json['type']
    );
  }

  Map<String, dynamic> toJson() => {'name': name, 'type': type};
}

void main(List<String> args) {
  var data = """
    {
      "restriction-type": "boolean-search-restriction",
      "boolean-logic": "and",
      "restrictions": [
        {
          "restriction-type": "property-search-restriction",
          "property": {
            "name": "name",
            "type": "STRING"
          },
          "match-mode": "EXACTLY_MATCHES",
          "value": "admin"
        },
        {
          "restriction-type": "property-search-restriction",
          "property": {
            "name": "email",
            "type": "STRING"
          },
          "match-mode": "EXACTLY_MATCHES",
          "value": "admin@example.com"
        }
      ]
    }
  """;

  var response = DataExample.fromJson(jsonDecode(data));
  print(response.restrictionType);
  print(response.booleanLogic);
  print('\n');
  for (var item in response.restrictions) {
    print(item.restrictionType);
    print(item.property.name);
    print(item.property.type);
    print(item.matchMode);
    print(item.value);
  }

  var rawData = response.toJson();
  //converting DataExample Instance to Map<String,dynamic>
  print(rawData.runtimeType);
}
