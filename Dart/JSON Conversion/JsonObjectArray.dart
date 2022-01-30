import 'dart:convert';

class User {
  String name;
  String firstName;
  String lastName;
  String displayName;
  String email;
  Password password;
  bool active;
  Attributes attributes;

  User({
    required this.name,
    required this.firstName,
    required this.lastName,
    required this.displayName,
    required this.email,
    required this.password,
    required this.active,
    required this.attributes
  });

  factory User.fromJson(Map<String, dynamic> json){
    return User(
      name: json['name'],
      firstName: json['first-name'],
      lastName: json['last-name'],
      displayName: json['display-name'],
      email: json['email'],
      password: Password.fromJson(json['password']),
      active: json['active'],
      attributes: Attributes.fromJson(json['attributes'])
    );
  }
}

class Password {
  String value;

  Password(this.value);
  Password.fromJson(Map<String, dynamic> json) : value = json['value'];
}

class Attribute {
  String name;
  List<String> value;

  Attribute(this.name, this.value);

  Attribute.fromJson(Map<String, dynamic> json)
      : name = json['name'],
        value = List<String>.from(json['values'].map((element) => element));
}

class Attributes {
  List<Attribute> attribute;

  Attributes(this.attribute);

  Attributes.fromJson(Map<String, dynamic> json)
      : attribute = List<Attribute>.from(
            json['attributes'].map((element) => Attribute.fromJson(element)));
}

void main(List<String> args) {
  var data = """
    {
      "name" : "my_username",
      "first-name" : "My",
      "last-name" : "Username",
      "display-name" : "My Username",
      "email" : "user@example.test",
      "password" : {
          "value" : "my_password"
      },
      "active" : true,
      "attributes" : {
        "attributes" : [
          {
              "name" : "attr-name",
              "values" : [
                "attr-value"
              ]
          }
        ]
      }
    }""";

  var response = User.fromJson(jsonDecode(data));
  print(response.name);
  print(response.firstName);
  print(response.lastName);
  print(response.displayName);
  print(response.email);
  print(response.active);
  print(response.password.value);
  print(response.attributes.attribute[0].name);
  print(response.attributes.attribute[0].value[0]);
}
