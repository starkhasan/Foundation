import 'dart:convert';
class Address{
  String street;
  String city;
  String country;
  int zipCode;

  Address(this.street,this.city,this.country,this.zipCode);

  Address.fromJson(Map<String, dynamic> json)
     :street = json['street'],
      city = json['city'],
      country = json['country'],
      zipCode = json['zipCode'];

  Map<String, dynamic> toJson() => {
    'street': street,
    'city': city,
    'country': country,
    'zipCode': zipCode
  };

}
class User{
  String name;
  String email;
  Address address;

  User(this.name,this.email,this.address);

  //A User.fromJson() Constructor for constructing a new User instance from a map Structure
  User.fromJson(Map<String, dynamic> json)
    : name = json['name'],
    email = json['email'],
    address = Address.fromJson(json['address']);

  // jsonDecode() return Map<String, dynamic>  meaning that you do not know the
  // type of the value until runtime.


  //toJson() method which convert a User instance in to map
  Map<String, dynamic> toJson() => {
    'name': name,
    'email': email,
    'address': address.toJson()
  };
}
void main() {
  var userResponse = '''{
    "name": "Leanne Graham",
    "email": "Sincere@april.biz",
    "address": {
      "street": "Kulas Light",
      "city": "Gwenborough",
      "country": "India",
      "zipCode": 802301
    }
}''';

  var json = jsonDecode(userResponse);
  var response = User.fromJson(json);
  print(response.name);
  print(response.email);
  print(response.address.city);
  print(response.address.country);
}
