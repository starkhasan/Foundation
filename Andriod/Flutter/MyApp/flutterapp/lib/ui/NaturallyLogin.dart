
import 'package:flutter/material.dart';
import 'package:flutterapp/network/ApiCalling.dart';
import 'package:flutterapp/ui/LoginPage.dart';
import 'package:flutterapp/utils/drawer.dart';
import 'package:toast/toast.dart';

class NaturallyLogin extends StatefulWidget {
  @override
  _NaturallyLoginState createState() => _NaturallyLoginState();

}

class _NaturallyLoginState extends State<NaturallyLogin> {

  TextEditingController text1 = new TextEditingController();
  TextEditingController text2 = new TextEditingController();
  final bool isLoading=true;

  bool validation(){
    if(text1.text==""){
      Toast.show('Please Enter UserName',context,duration: Toast.LENGTH_SHORT,gravity: Toast.BOTTOM);
      return false;
    }else if(text2.text==""){
      Toast.show('Please Enter Password',context,duration: Toast.LENGTH_SHORT,gravity: Toast.BOTTOM);
      return false;
    }
    return true;
  }

  ListTile _title(String listtile,String listsubtitle,IconData listicon) => ListTile(
                dense: true,
                selected: true,
                title: Text(
                  listtile,
                  style: TextStyle(color: Colors.deepPurple,fontWeight: FontWeight.bold,fontStyle: FontStyle.italic,fontSize: 16.0),
                ),
                subtitle: Text(listsubtitle),
                leading: Icon(
                  listicon,
                  color: Colors.blue,
                  size: 30
                ),
              );
  

  fetchData(){
    var map = new Map<String,dynamic>();
    map['hash_code'] = '[aLRdAngCu2W]';
    map['device_token'] = 'etLH8gL6ljI:APA91bGs00_VrsrqpaaC9NKBiGKfQCh2msIz6H0szoahECQTCMOPQx-s1__fFNnh9EzSC5CwByc-8NiPeKURy_GQ3m0937QHO8XOLK2btLqf5_Kd2mQtY-yYmtYon2-Tvqk_f12Q-08H';
    map['device_type'] = 'android';
    map['username'] = text1.text.toString();
    map['password'] = text2.text.toString();
    var user = new Map();
    user['user']=map;
    return  ApiService.signin(user);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        centerTitle: true,
        title: Text(
          'Folloh',
          style: TextStyle(color: Colors.white,fontFamily: 'MontserratBold',fontSize: 20.0)
        ),
        actions: <Widget>[
          IconButton(
            icon: Icon(Icons.arrow_forward_ios),
            onPressed: () {
              Navigator.push(context, MaterialPageRoute(builder: (context) => LoginScreen()));
            }
          )
        ],
      ),
      drawer: DrawerLayout(),
      body: Container(
          margin: EdgeInsets.all(10.0),
          padding: EdgeInsets.all(10.0),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.start,
            children: <Widget>[
              TextField(
                controller: text1,
                obscureText: false,
                style: TextStyle(color: Colors.black,fontWeight: FontWeight.w600,fontStyle: FontStyle.normal,fontSize: 18.0,fontFamily: 'MontserratSemiBold'),
                showCursor: true,
                decoration: InputDecoration(
                  hintText: "Enter UserName",
                  border: OutlineInputBorder(
                    borderRadius: BorderRadius.circular(10.0),
                    borderSide: BorderSide(color: Colors.black)
                  )
                )
              ),
              SizedBox(height: 10),
              TextField(
                controller: text2,
                obscureText: true,
                autocorrect: false,
                style:TextStyle(color:Colors.black,fontWeight: FontWeight.w600,fontStyle: FontStyle.normal,fontSize: 18.0,fontFamily: 'MontserratSemiBold'),
                showCursor: true,
                decoration: InputDecoration(
                  hintText: 'Enter Password',
                  border: OutlineInputBorder(
                    borderRadius: BorderRadius.circular(10.0),
                    borderSide: BorderSide(color: Colors.black)
                  )
                ),
              ),
              SizedBox(height: 10),
              RaisedButton(
                padding: EdgeInsets.fromLTRB(100, 15, 100, 15),
                color: Colors.blue,
                child: Text(
                  'Submit',
                  style: TextStyle(color: Colors.white,fontSize: 18.0,fontWeight: FontWeight.bold,fontFamily: 'MontserratSemiBold'),
                ),
                onPressed: (){
                  if(validation()){
                    fetchData().then((result) {
                      if(result.status == 200){
                           Navigator.push(context, MaterialPageRoute(builder: (context) => LoginScreen()));
                        }else{
                          Toast.show(result.message, context,duration: Toast.LENGTH_SHORT,gravity: Toast.BOTTOM);
                        }
                    });
                  }
                },
              ),
              SingleChildScrollView(
                scrollDirection: Axis.horizontal,
                child: Row(
                  children: <Widget>[
                    Container(
                      margin: EdgeInsets.all(5),
                      height: 100,
                      width: 100,
                      child: Center(
                        child: Text('sdhj'),
                      ),
                      decoration: BoxDecoration(
                        color: Colors.white,
                        boxShadow: [BoxShadow(color: Colors.black12,blurRadius: 5.0,spreadRadius: 5.0,offset: Offset(1,3,))],
                        borderRadius: BorderRadius.all(Radius.circular(5))
                      ),
                    ),
                    Container(
                      margin: EdgeInsets.all(5),
                      height: 100,
                      width: 100,
                      child: Center(
                        child: Text('sdhj'),
                      ),
                      decoration: BoxDecoration(
                        color: Colors.white,
                        boxShadow: [BoxShadow(color: Colors.black12,blurRadius: 3.0,spreadRadius: 3.0,offset: Offset(1,3,))],
                        borderRadius: BorderRadius.all(Radius.circular(5))
                      )
                    ),
                    Container(
                      height: 100,
                      width: 100,
                      child: Center(
                        child: Text('sdhj'),
                      ),
                    ),
                    Container(
                      height: 100,
                      width: 100,
                      child: Center(
                        child: Text('sdhj'),
                      ),
                    ),
                    Container(
                      height: 100,
                      width: 100,
                      child: Center(
                        child: Text('sdhj'),
                      ),
                    ),
                    Container(
                      height: 100,
                      width: 100,
                      child: Center(
                        child: Text('sdhj'),
                      ),
                    ),
                    Container(
                      height: 100,
                      width: 100,
                      child: Center(
                        child: Text('sdhj'),
                      ),
                    )
                  ],
                ),
              ),
              Container(
                margin: EdgeInsets.fromLTRB(15, 30, 15, 10),
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    children: <Widget>[
                      Column(
                        children: <Widget>[
                          Image.asset('assets/images/about_device.png'),
                          SizedBox(height: 10.0),
                          Text('About Device')
                        ],
                      ),
                      Column(
                        children: <Widget>[
                          Image.asset('assets/images/interval.png'),
                          SizedBox(height: 10.0),
                          Text('Interval')
                        ],
                      ),
                      Column(
                        children: <Widget>[
                          Image.asset('assets/images/monitoring.png'),
                          SizedBox(height: 10.0),
                          Text('Monitoring')
                        ],
                      ),
                      Column(
                        children: [
                          GestureDetector(
                            onTap: (){
                              Toast.show('Clicked',context,duration: Toast.LENGTH_SHORT,gravity: Toast.BOTTOM);
                            },
                            child: Column(children: <Widget>[
                              Image.asset('assets/images/password.png'),
                              SizedBox(height: 10.0),
                              Text(
                                'Password',
                                textAlign: TextAlign.center, 
                                ),
                              ],
                            ),
                          ),
                        ],
                      ),
                      Column(
                        children: <Widget>[
                          Image.asset('assets/images/power_off.png'),
                          SizedBox(height: 10.0),
                          Text('Power-OFF')
                        ],
                      ),
                      Column(
                        children: <Widget>[
                          Image.asset('assets/images/reboot.png'),
                          SizedBox(height: 10.0),
                          Text('Reboot')
                        ],
                      )
                    ]
                )
              ),
              Expanded(
                child: ListView(
                  scrollDirection: Axis.vertical,
                  children: [
                    _title('Demo','Subtitle',Icons.ac_unit),
                    ListTile(
                      dense: true,
                      leading: Icon(Icons.ac_unit),
                      trailing: Icon(Icons.access_alarm),
                      title: Text('Demo'),
                      subtitle: Text('Subtitle'),
                    ),
                    Divider(),
                    ListTile(
                      dense: true,
                      leading: Icon(Icons.access_alarm),
                      trailing: Icon(Icons.access_time),
                      title: Text('Demo1'),
                      subtitle: Text('subtitle'),
                    ),
                    Divider(),
                    ListTile(
                      dense: true,
                      leading: Icon(Icons.access_alarm),
                      trailing: Icon(Icons.access_time),
                      title: Text('Demo1'),
                      subtitle: Text('subtitle'),
                    ),
                    Divider(),
                    Card(
                      elevation: 5,
                      child: ListTile(
                        dense: true,
                        leading: Icon(Icons.access_alarm),
                        trailing: Icon(Icons.access_time),
                        title: Text('Demo1'),
                        subtitle: Text('subtitle'),
                      ),
                    ),
                    Card(
                      elevation: 5,
                      child: ListTile(
                        dense: true,
                        leading: Icon(Icons.access_alarm),
                        trailing: Icon(Icons.access_time),
                        title: Text('Demo1'),
                        subtitle: Text('subtitle'),
                      ),
                    ),
                    Card(
                      elevation: 5,
                      child: ListTile(
                        dense: true,
                        leading: Icon(Icons.access_alarm),
                        trailing: Icon(Icons.access_time),
                        title: Text('Demo1'),
                        subtitle: Text('subtitle'),
                      ),
                    ),
                    Card(
                      elevation: 5,
                      child: ListTile(
                        dense: true,
                        leading: Icon(Icons.access_alarm),
                        trailing: Icon(Icons.access_time),
                        title: Text('Demo1'),
                        subtitle: Text('subtitle'),
                      ),
                    )
                  ],
                )
              ),
            ]
          ),
      ),
    );
  }
}

