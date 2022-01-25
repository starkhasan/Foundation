import 'dart:io';
import 'dart:convert';

class UserResponse{
  int userId;
  int id;
  String title;
  String body;

  UserResponse({required this.userId,required this.id,required this.title,required this.body});

  factory UserResponse.fromJson(Map<String, dynamic> json){
    return UserResponse(
      userId: json['userId'],
      id: json['id'],
      title: json['title'],
      body: json['body']
    );
  }
}

void main() async{
  //To perform the HTTP Request in Dart We have the HttpClient
  var client = HttpClient();
  HttpClientRequest request = await client.getUrl(Uri.parse('https://jsonplaceholder.typicode.com/posts'));
  HttpClientResponse httpResponse = await request.close();
  final stringData = await httpResponse.transform(Utf8Decoder()).join();
  client.close();
  List<UserResponse> response = await List<UserResponse>.from(jsonDecode(stringData).map((item) => UserResponse.fromJson(item)));
  for(var item in response){
    print('UserID => ${item.userId}\nID => ${item.id}\nTitle => ${item.title}\nBody => ${item.body}\n\n');
  }
}
