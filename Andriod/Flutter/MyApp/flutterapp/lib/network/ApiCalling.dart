import 'dart:convert';
import '../FollohResponse.dart';
import '../UserResponse.dart';
import '../constant/Cv.dart';
import 'package:';

class ApiService{  

  static Future<List<dynamic>> login() async {
    final response = await http.get('${Cv.BASE_URL}/posts');
    var logindata;
    if(response.statusCode == 200){
      logindata = json.decode(response.body);
    }
    return logindata;
  }

  static Future<List<UserResponse>> user() async {
      final response = await http.get(Cv.BASE_URL_USER);
      if (response.statusCode == 200) {
          return List<UserResponse>.from(json.decode(response.body).map((x) => UserResponse.fromJson(x)));
      }else{
        throw Exception('Failed to load post');
      }
    }
  
    static Future<FollohResponse> signin(Map user) async {
      Map<String,String> headers1 = {'Content-Type':'application/json','Accept':'application/vnd.folloh.v1'};
      var body1 = json.encode(user);
      var response = await http.post(Cv.URL_NATURALLY,body:body1,headers: headers1);
      if (response.statusCode == 200) {
          return FollohResponse.fromJson(jsonDecode(response.body));
      }else{
        throw Exception('Failed to load post');
      }
    }
}
  
 