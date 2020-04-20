import 'package:flutter/material.dart';
import 'package:flutterapp/ui/MapView.dart';
import 'package:flutterapp/ui/Profile.dart';
import 'package:toast/toast.dart';

class DrawerLayout extends StatefulWidget {

  @override
  _DrawerLayoutState createState() => _DrawerLayoutState();
}

class _DrawerLayoutState extends State<DrawerLayout> {

  GlobalKey _drawerKey = GlobalKey();

  @override
  Widget build(BuildContext context) {
    return Drawer(
      key: _drawerKey,
      elevation: 10.0,
        child: Column(
          children: <Widget>[
            Container(
              height: 200,
              color: Colors.white,
              child: Stack(
                children: <Widget>[
                  Container(
                    height: 200,
                    color: Colors.white,
                  ),
                  Center(
                    child: Container(
                      margin: EdgeInsets.fromLTRB(10, 0, 10, 0),
                      child: Image.asset('assets/images/follohlogo.jpg')
                    )
                  )
                ]
              ),
            ),
            ListTile(
              leading: Icon(Icons.map),
              title: Text(
                'Google Map',
                style: TextStyle(color: Colors.black,fontFamily: 'MontserratSemiBold',fontSize: 16.0)
              ),
              onTap: () {
                Navigator.pop(context);
                Navigator.push(context, MaterialPageRoute(builder: (context) =>  MapView()));
              }
            ),
            Divider(height: 1.0),
            ListTile(
              leading: Icon(Icons.person),
              title: Text(
                'User',
                style: TextStyle(color: Colors.black,fontFamily: 'MontserratSemiBold',fontSize: 16.0)
              ),
              onTap: () => Toast.show('Clicked',context,duration: Toast.LENGTH_SHORT,gravity: Toast.BOTTOM)
            ),
            Divider(height:1.0),
            ListTile(
              leading:Icon(Icons.portrait),
              title: Text(
                'Profile',
                style: TextStyle(color: Colors.black,fontFamily: 'MontserratSemiBold',fontSize: 16.0)
              ),
              onTap: (){
                Navigator.pop(context);
                Navigator.push(context, MaterialPageRoute(builder: (context) => Profile()));
              },
            ),
            Expanded(
              child: Container(
                margin: EdgeInsets.fromLTRB(0, 0, 0, 20),
                alignment: Alignment.bottomCenter,
                child: RaisedButton(
                  elevation: 10.0,
                  padding: EdgeInsets.fromLTRB(70, 15, 70, 15),
                  color: Colors.blue,
                  onPressed: (){
                    Navigator.pop(context);
                    Toast.show("Logout",context,duration: Toast.LENGTH_SHORT,gravity: Toast.BOTTOM);
                  },
                  child: Text(
                    "Logout",
                    style: TextStyle(color: Colors.white,fontFamily: 'MontserratSemiBold',fontSize: 18.0),
                  ),
                )
              ),
            )
          ],
        ),
    );
  }
}