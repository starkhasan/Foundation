import 'package:flutter/material.dart';
import 'package:flutterapp/UserResponse.dart';
import 'package:flutterapp/network/ApiCalling.dart';
import 'package:toast/toast.dart';

class SecondPage extends StatefulWidget {
  @override
  _SecondPageState createState() => _SecondPageState();
}

class _SecondPageState extends State<SecondPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Second Page'),
        actions: <Widget>[
          IconButton(
            icon: Icon(Icons.add_circle_outline),
            onPressed: (){
              Toast.show("Clicked",context,duration:Toast.LENGTH_SHORT,gravity: Toast.BOTTOM);
            },
          )
        ],
      ),
      body: Container(
        child: FutureBuilder<List<UserResponse>>(
          future: ApiService.user(),
              builder: (context, snapshot) {
                if (snapshot.connectionState == ConnectionState.done) {
                  return ListView.builder(
                    itemCount: snapshot.data.length,
                    itemBuilder: (context,index){
                      return ListTile(
                        selected: true,
                        dense: true,
                        leading: CircleAvatar(
                          backgroundImage: AssetImage('assets/images/about_device.png'),
                        ),
                        onTap: (){
                          Toast.show("$index CLicked", context,duration: Toast.LENGTH_SHORT,gravity: Toast.BOTTOM);
                        },
                        title: Text(
                          snapshot.data[index].username,
                          style: TextStyle(fontWeight: FontWeight.bold,fontSize: 18.0)
                        ),
                        subtitle: Text(
                          snapshot.data[index].username,
                          maxLines: 1,
                          style: TextStyle(fontWeight: FontWeight.bold,fontSize: 16.0),
                        )
                      );
                    },
                  );
                }else{
                  return Center(
                    child: CircularProgressIndicator(),
                  );
                }
              },
            ) 
      )
    );
  }
}