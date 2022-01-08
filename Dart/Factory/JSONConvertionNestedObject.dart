import 'dart:convert';

class RestrictionResponse{
  final String restrictionType;
  final String booleanLogic;
  final List<Restriction> restrictions;

  RestrictionResponse({required this.restrictionType,required this.booleanLogic,required this.restrictions});

  factory RestrictionResponse.fromJson(Map<String,dynamic> json){
    return RestrictionResponse(
      restrictionType: json['restriction-type'],
      booleanLogic: json['boolean-logic'],
      restrictions: List<Restriction>.from(json['restrictions'].map((item) => Restriction.fromJson(item)))
    );
  }

}

class Restriction{
  final String restrictionType;
  final Property property;
  final String matchMode;
  final String value;

  Restriction({required this.restrictionType,required this.property,required this.matchMode,required this.value});

  factory Restriction.fromJson(Map<String, dynamic> json){
    return Restriction(
      restrictionType: json['restriction-type'],
      property: Property.fromJson(json['property']),
      matchMode: json['match-mode'],
      value: json['value']
    );
  }
}

class Property{
  final String name;
  final String type;

  Property({required this.name,required this.type});

  factory Property.fromJson(Map<String, dynamic> json){
    return Property(
      name: json['name'],
      type: json['type']
    );
  }
}

void main(){
  var responseBody = """
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
  var response = RestrictionResponse.fromJson(jsonDecode(responseBody));
  print(response.restrictionType);
  print(response.booleanLogic);
  for(var item in response.restrictions){
    print(item.restrictionType);
    print(item.property.name);
    print(item.property.type);
    print(item.matchMode);
    print(item.value);
  }
}
