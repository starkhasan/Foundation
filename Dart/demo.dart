import 'dart:convert';

class User {
  String name;
  String email;
  User(this.name, this.email);
  User.fromJson(Map<String, dynamic> json)
      : name = json['name'],
        email = json['email'];

}

void main() {
  var userJson = '''
  {
    "name": "John Smith",
    "email": "john@example.com"
}''';
  var jsonString = jsonDecode(userJson);
  var userObject = User.fromJson(jsonString);
  print('Name -> ${userObject.name}\nEmail -> ${userObject.email}');
}
